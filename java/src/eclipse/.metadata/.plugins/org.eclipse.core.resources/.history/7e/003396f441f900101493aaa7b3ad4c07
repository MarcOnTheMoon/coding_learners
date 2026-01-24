package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LeibnizSeries {
	public static void main(String[] args) {
		int n = 0;
		double sign = 1.0;
		double pi = 4. * sign / (2. * n + 1.);

		// n = 0
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 1
		n = n + 1;
		sign = -1. * sign;
		pi = pi + 4. * sign / (2. * n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 2
		sign *= -1.;
		pi += 4. * sign / (2. * ++n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 3
		sign *= -1.;
		pi += 4. * sign / (2. * ++n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 4
		sign *= -1.;
		pi += 4. * sign / (2. * ++n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 5
		sign *= -1.;
		pi += 4. * sign / (2. * ++n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);

		// n = 6
		sign *= -1.;
		pi += 4. * sign / (2. * ++n + 1.);
		System.out.println("n = " + n + ": pi = " + pi);
	}
}
