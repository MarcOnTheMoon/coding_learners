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
public class BisectionMethod {
	public static void main(String[] args) {
		double xl = 0.0, xr = 4.0;
		double delta = 1.0e-6;

		// Initial function values
		double fl = xl * xl - 2.0 * xl - 1.0;
		double fr = xr * xr - 2.0 * xr - 1.0;

		// Determine zero-crossing by bisection method
		System.out.println("Zero-crossing for f(x) = x^2 - 2x - 1 by bisection method:");
		System.out.printf(Locale.US, "x0 in [%.9f , %.9f]\n", xl, xr);

		while (xr - xl > delta) {
			// Adapt interval
			double xm = 0.5 * (xl + xr);
			double fm = xm * xm - 2.0 * xm - 1.0;

			if (fm * fl > 0) {
				xl = xm;
				fl = fm;
			} else {
				xr = xm;
				fr = fm;
			}

			// Print interval
			System.out.printf(Locale.US, "x0 in [%.9f , %.9f]\n", xl, xr);
		}
		System.out.println();

		// Print results to console
		System.out.printf(Locale.US, "Stopped at interval size: %.9f\n", delta);
		System.out.printf(Locale.US, "Approximated x0         : %.9f\n", 0.5 * (xl + xr));
		System.out.printf(Locale.US, "Approximated f(x0)      : %.9f\n", 0.5 * (fl + fr));
	}
}
