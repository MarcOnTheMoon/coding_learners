package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LeapYear {
	public static void main(String[] args) {
		int year = 2000;
		boolean isLeapYear;

		// Check whether year is a leap year
		if ((year % 4) == 0) {
			if (((year % 100) == 0) && ((year % 400) != 0))
				isLeapYear = false;
			else
				isLeapYear = true;
		} else
			isLeapYear = false;

		// Print the result to the console
		if (isLeapYear)
			System.out.printf("Year %d is a leap year.\n", year);
		else
			System.out.printf("Year %d is not a leap year.\n", year);
	}
}
