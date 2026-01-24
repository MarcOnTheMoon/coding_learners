package exercises._06_abstract.a_zero_crossing;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ZeroCrossingApp {
	public static void main(String[] args) {
		Function parabola = new Parabola(-1.0, 0.0, 4.0);
		Function log6 = new Logarithm(6);
		Double x0;

		// Zero-crossing (Newton's method and bisection) of parabola
		System.out.printf(Locale.US, "Zero-crossing for %s:\n", parabola.toString().replace(',', '.'));		
		x0 = ZeroCrossing.newton(parabola, 1.0, 1.0e-5, 1000); 
		System.out.printf(Locale.US, "Newton    : x0 = % .6f, f(x0) = % .3e\n", x0, parabola.f(x0));
		x0 = ZeroCrossing.bisection(parabola, 1.8, 2.3, 1.0e-5); 
		System.out.printf(Locale.US, "Bisection : x0 = % .6f, f(x0) = % .3e\n", x0, parabola.f(x0));

		// Zero-crossing (Newton's method and bisection) of logarithm
		System.out.printf(Locale.US, "\nZero-crossing for %s:\n", log6.toString().replace(',', '.'));
		x0 = ZeroCrossing.newton(log6, 0.1, 1.0e-5, 1000); 
		System.out.printf(Locale.US, "Newton    : x0 = % .6f, f(x0) = % .3e\n", x0, log6.f(x0));
		x0 = ZeroCrossing.bisection(log6, 0.0, 3.0, 1.0e-5); 
		System.out.printf(Locale.US, "Bisection : x0 = % .6f, f(x0) = % .3e\n", x0, log6.f(x0));
	}
}
