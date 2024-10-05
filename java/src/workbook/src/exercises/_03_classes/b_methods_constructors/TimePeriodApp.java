package exercises._03_classes.b_methods_constructors;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TimePeriodApp {
	public static void main(String[] args) {
		TimePeriod period = new TimePeriod(1, 18, 6);
		
		// Print period the the console
		System.out.print("TimePeriod(1, 18, 6)   : ");
		period.printFormatted();
		
		// Add seconds and print to the console
		System.out.print("\naddSeconds(61)         : ");
		period.addSeconds(61);
		period.printFormatted();
		
		// Set time with too large value and print to the console
		System.out.print("\nsetPeriod(0, 61, 3606) : ");
		period.setPeriod(0, 61, 3606);
		period.printFormatted();
		System.out.println();
	}
}
