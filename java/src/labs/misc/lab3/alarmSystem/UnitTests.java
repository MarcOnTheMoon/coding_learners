package labs.lab3.alarmSystem;

import static org.junit.Assert.*;

import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class UnitTests {

	@SuppressWarnings("unused")
	@Test
	public final void testInterfacesImplemented() {
		Observable observable = new AlarmSensor("Sensor name");
		Observer observer = new AlarmSystem(1234);
	}

	@Test
	public final void testUpdate() {
		AlarmSensor sensor = new AlarmSensor("Sensor name");
		ConcreteObserver observer = new ConcreteObserver();

		// Does AlarmSensor reference by interface Observable (and NOT by concrete class AlarmSystem)?
		sensor.setObserver(observer);
		assertFalse(observer.isUpdateCalled);

		// Does AlarmSensor call method update() of observer?
		sensor.trigger();
		assertTrue(observer.isUpdateCalled);
	}

	@Test
	public final void testSensorName() {
		// Does toString() method return sensor name?
		AlarmSensor sensor = new AlarmSensor("Sensor name");
		assertEquals("Sensor name", sensor.toString());
	}

	@Test
	public final void testSensorObserver() {
		AlarmSensor sensor = new AlarmSensor("Sensor name");

		// Initially no observer?
		assertNull(sensor.getObserver());

		// Does getObserver() return the observer set using setObserver()?
		AlarmSystem observer = new AlarmSystem(1234);
		sensor.setObserver(observer);
		assertEquals(observer, sensor.getObserver());
	}

	@Test
	public final void testSystemSwitchOnOff() {
		int pinCode = 1234;
		AlarmSystem system = new AlarmSystem(pinCode);

		// Initially system switched off and getStatus() returning correct string?
		assertEquals("Anlage nicht scharfgeschaltet", system.getStatus());

		// Does switchOn() switch on system and getStatus() returning correct string?
		system.switchOn();
		assertEquals("Anlage scharfgeschaltet", system.getStatus());
		system.switchOn();
		assertEquals("Anlage scharfgeschaltet", system.getStatus());

		// Switch off with incorrect PIN codes => System remains switched on?
		system.switchOff(pinCode + 3);
		assertEquals("Anlage scharfgeschaltet", system.getStatus());
		system.switchOff(pinCode * 10);
		assertEquals("Anlage scharfgeschaltet", system.getStatus());

		// Switch off with correct PIN code => System switched off?
		system.switchOff(pinCode);
		assertEquals("Anlage nicht scharfgeschaltet", system.getStatus());
	}

	@Test
	public final void testSystemSensors() {
		AlarmSystem system = new AlarmSystem(1234);
		AlarmSensor sensor1 = new AlarmSensor("Sensor 1");
		AlarmSensor sensor2 = new AlarmSensor("Sensor 2");

		// Initially no sensors connected to system?
		assertFalse(system.containsSensor(sensor1));
		assertFalse(system.containsSensor(sensor2));
		assertNull(sensor1.getObserver());
		assertNull(sensor2.getObserver());

		// Sensor 1 connected to system?
		system.addSensor(sensor1);
		assertTrue(system.containsSensor(sensor1));
		assertFalse(system.containsSensor(sensor2));
		assertEquals(system, sensor1.getObserver());
		assertNull(sensor2.getObserver());

		// Sensors 1 and 2 connected to system?
		system.addSensor(sensor2);
		assertTrue(system.containsSensor(sensor1));
		assertTrue(system.containsSensor(sensor2));
		assertEquals(system, sensor1.getObserver());
		assertEquals(system, sensor2.getObserver());
	}
}
