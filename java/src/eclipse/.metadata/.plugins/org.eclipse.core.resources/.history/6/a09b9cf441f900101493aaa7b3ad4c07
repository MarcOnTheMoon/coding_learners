package exercises._02_imperative;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathSeries {
	public static void main(String[] args) {
		double sum = 0.0, summand = 1.0, delta = 1.0e-10;
		int nummberSummands = 0;

		// Sum up until next summand is below delta
		while (summand > delta) {
			sum += summand;
			summand *= 0.5;
			nummberSummands++;
		}

		// Print results to the console
		System.out.printf(Locale.US, "Approximated value: %.11f\n", sum);
		System.out.println("Summands added    : " + nummberSummands);
		System.out.printf(Locale.US, "Stopped at delta  : %.1e\n", delta);
	}
}
