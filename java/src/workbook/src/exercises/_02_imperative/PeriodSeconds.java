package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PeriodSeconds {
	public static void main(String[] args) {
		int periodSeconds = 3867;
		int hours, minutes, seconds;

		// Calculate and print formatted time period
		seconds = periodSeconds % 60;
		minutes = (periodSeconds / 60) % 60;
		hours = periodSeconds / (60 * 60);
		System.out.printf(
				"A period of %d seconds corresponds to %d:%02d:%02d hours.\n",
				periodSeconds, hours, minutes, seconds);
	}
}
