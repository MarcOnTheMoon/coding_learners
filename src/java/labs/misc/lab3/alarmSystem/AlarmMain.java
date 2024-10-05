package labs.lab3.alarmSystem;

/** Sample application for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AlarmMain {
	public static void main(String[] args) {
		int pinCode = 1234;
		AlarmSystem system = new AlarmSystem(pinCode);
		AlarmSensor sensorDoor = new AlarmSensor("Haust�r");
		AlarmSensor sensorKitchen = new AlarmSensor("K�che");
		AlarmSensor sensorLivingRoom = new AlarmSensor("Wohnzimmer");
		AlarmSensor sensorBedroom = new AlarmSensor("Schlafzimmer");
		AlarmSensor sensorBathroom = new AlarmSensor("Bad");
		
		// Add alarm sensors to the central unit
		system.addSensor(sensorDoor);
		system.addSensor(sensorKitchen);
		system.addSensor(sensorLivingRoom);
		system.addSensor(sensorBedroom);
		system.addSensor(sensorBathroom);
		
		// Switch on alarm system
		System.out.println("Alarmanlage einschalten:");
		System.out.println(system.getStatus());
		system.switchOn();
		System.out.println(system.getStatus());
		
		// Trigger sensors
		System.out.println("\nSensoren auslösen:");
		sensorDoor.trigger();
		sensorBathroom.trigger();
		
		// Switch off alarm system
		System.out.println("\nAlarmanlage ausschalten:");
		system.switchOff(pinCode + 7);
		System.out.println(system.getStatus());
		system.switchOff(pinCode);
		System.out.println(system.getStatus());
	}

}
