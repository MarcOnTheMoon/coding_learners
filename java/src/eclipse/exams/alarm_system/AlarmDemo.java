package alarm_system;

public class AlarmDemo {

	public static void main(String[] args) {
		AlarmSystem system = new AlarmSystem();
		String pinCode = "2051";
		
		// Set pin code
		boolean isSuccess = system.setPinCode("0001", pinCode);
		System.out.printf("Set pin (incorrect old pin)\t: (successful: %b)\n", isSuccess);
		isSuccess = system.setPinCode("0000", pinCode);
		System.out.printf("Set pin (correct old pin)\t: (successful: %b)\n\n", isSuccess);

		// Add sensors
		ContactSensor doorSensor = new ContactSensor(system);
		MotionSensor motionSensor = new MotionSensor(system);
		
		// Trigger sensor with system off
		System.out.print("Trigger sensors\t\t\t: ");
		doorSensor.trigger();
		motionSensor.trigger();
		System.out.println(system);
		
		// Trigger sensor with system on
		System.out.print("Activate system\t\t\t: ");
		system.switchOn();
		System.out.println(system);
		
		// Trigger sensor with system on
		System.out.print("Trigger sensors\t\t\t: ");
		doorSensor.trigger();
		motionSensor.trigger();
		System.out.println(system);
		
		// Deactivate (incorrect pin code)
		System.out.print("Deactivate (incorrect pin)\t: ");
		system.switchOff("0000");
		System.out.println(system);
		
		// Deactivate (correct pin code)
		System.out.print("Deactivate (correct pin)\t: ");
		system.switchOff(pinCode);
		System.out.println(system);
	}
}
