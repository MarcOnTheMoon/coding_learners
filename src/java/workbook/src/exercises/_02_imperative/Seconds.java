package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Seconds {
	public static void main(String[] args) {
		int secondsPerHour = 60 * 60;
		int secondsPerDay = 24 * secondsPerHour;
		int secondsPerWeek = 7 * secondsPerDay;
		int secondsInApril = 30 * secondsPerDay;

		System.out.println("Sekunden pro Stunde : " + secondsPerHour);
		System.out.println("Sekunden pro Tag    : " + secondsPerDay);
		System.out.println("Sekunden pro Woche  : " + secondsPerWeek);
		System.out.println("Sekunden im April   : " + secondsInApril);
	}
}
