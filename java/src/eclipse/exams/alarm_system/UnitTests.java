package alarm_system;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UnitTests {

	@Test
	public final void test_AlarmSystem_Basic() {
		AlarmSystem system = new AlarmSystem();
		String correctCode = "0000";
		String incorrectCode = "1706";

		// Initial values
		assertEquals(false, system.isOn());
		assertEquals(false, system.isAlarm());

		// Trigger alarm (System off => No alarm)
		system.onSensorTriggered();
		assertEquals(false, system.isOn());
		assertEquals(false, system.isAlarm());

		// Switch on
		system.switchOn();
		assertEquals(true, system.isOn());
		assertEquals(false, system.isAlarm());

		// Trigger alarm (System on => Alarm)
		system.onSensorTriggered();
		assertEquals(true, system.isOn());
		assertEquals(true, system.isAlarm());

		// Switch off (using incorrect code => System remains on)
		system.switchOff(incorrectCode);
		assertEquals(true, system.isOn());
		assertEquals(true, system.isAlarm());

		// Switch off (using correct code => System is off)
		system.switchOff(correctCode);
		assertEquals(false, system.isOn());
		assertEquals(false, system.isAlarm());
	}

	@Test
	public final void test_AlarmSystem_PinCode() {
		AlarmSystem system = new AlarmSystem();
		String correctCode = "0000";
		String incorrectCode = "1706";

		// Change pin code (using correct old code "0000")
		assertEquals(true, system.setPinCode(correctCode, "2140"));

		// Change pin code (using incorrect old code)
		assertEquals(false, system.setPinCode(incorrectCode, "2140"));
	}

	@Test
	public final void test_AlarmSystem_Sensors() {
		AlarmSystem system = new AlarmSystem();

		// Empty list exists for new object
		assertEquals(0, system.getSensors().size());

		// Create sensors to add
		AlarmSystem dummySystem = new AlarmSystem();
		MotionSensor sensor1 = new MotionSensor(dummySystem);
		MotionSensor sensor2 = new MotionSensor(dummySystem);
		ContactSensor sensor3 = new ContactSensor(dummySystem);

		// Add sensors
		system.addSensor(sensor1);
		assertEquals(1, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor1));

		system.addSensor(sensor2);
		assertEquals(2, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor1));
		assertTrue(system.getSensors().contains(sensor2));

		system.addSensor(sensor3);
		assertEquals(3, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor1));
		assertTrue(system.getSensors().contains(sensor2));
		assertTrue(system.getSensors().contains(sensor3));

		// Cannot add sensor twice (no duplicates)
		system.addSensor(sensor1);
		assertEquals(3, system.getSensors().size());

		system.addSensor(sensor2);
		system.addSensor(sensor3);
		assertEquals(3, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor1));
		assertTrue(system.getSensors().contains(sensor2));
		assertTrue(system.getSensors().contains(sensor3));
	}

	@Test
	public final void test_AlarmSystem_toString() {
		AlarmSystem system = new AlarmSystem();

		// On: false, alarm: false
		assertEquals("System state (on: false, alarm: false)", system.toString());

		// On: true, alarm: false
		system.switchOn();
		assertEquals("System state (on: true, alarm: false)", system.toString());

		// On: true, alarm: true
		system.onSensorTriggered();
		assertEquals("System state (on: true, alarm: true)", system.toString());
	}

	@Test
	public final void test_Sensor() {
		AlarmSystem system = new AlarmSystem();

		// Create instance of Sensor (Implement trigger() => Not abstract anymore)
		Sensor sensor = new Sensor(system) {
			public void trigger() {
			}			
		};

		// Sensor added to systems's list
		assertEquals(1, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor));
	}

	@Test
	public final void test_MotionSensor() {
		AlarmSystem system = new AlarmSystem();
		MotionSensor sensor = new MotionSensor(system);

		// Sensor added to systems's list
		assertEquals(1, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor));

		// Trigger with system off => No alarm
		sensor.trigger();
		assertEquals(false, system.isAlarm());

		// Trigger with system on => Alarm
		system.switchOn();
		sensor.trigger();
		assertEquals(true, system.isAlarm());
	}

	@Test
	public final void test_ContactSensor() {
		AlarmSystem system = new AlarmSystem();
		ContactSensor sensor = new ContactSensor(system);

		// Initial values
		assertEquals(false, sensor.isOpen());

		// Sensor added to systems's list
		assertEquals(1, system.getSensors().size());
		assertTrue(system.getSensors().contains(sensor));

		// Trigger inverts isOpen (true <-> false)
		// System off => No alarm
		sensor.trigger();
		assertEquals(true, sensor.isOpen());
		assertEquals(false, system.isAlarm());

		sensor.trigger();
		assertEquals(false, sensor.isOpen());
		assertEquals(false, system.isAlarm());

		sensor.trigger();
		assertEquals(true, sensor.isOpen());
		assertEquals(false, system.isAlarm());

		// Trigger with system on: Close door/window => No alarm
		system.switchOn();
		sensor.trigger();
		assertEquals(false, sensor.isOpen());
		assertEquals(false, system.isAlarm());

		// Trigger with system on: Open door/window => Alarm
		sensor.trigger();
		assertEquals(true, sensor.isOpen());
		assertEquals(true, system.isAlarm());
	}
}
