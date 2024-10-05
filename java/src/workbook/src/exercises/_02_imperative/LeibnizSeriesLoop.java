package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LeibnizSeriesLoop {
	public static void main(String[] args) {
		int nMax = 1000, sign = 1;
		double pi = 0.0;

		// Calculate and print approximations for pi
		for (int n = 0; n <= nMax; n++) {
			pi += 4 * sign / (double)(2 * n + 1);
			sign *= -1;

			if ((n <= 10) || ((n % 250) == 0))
				System.out.printf("n = %5d: pi = %.6f\n", n, pi);
		}
	}
}
