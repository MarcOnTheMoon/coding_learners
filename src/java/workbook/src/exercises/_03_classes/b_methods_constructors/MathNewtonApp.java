package exercises._03_classes.b_methods_constructors;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathNewtonApp {
	public static void main(String[] args) {
		Parabola function = new Parabola(-1.0, 0.0, 4.0);
		ZeroCrossing zero = new ZeroCrossing(function);
		double x1 = 1.0, delta = 1.0e-6;
		int maxIterations = 1000;
		
		// Print function's formula to the console
		System.out.print("Zero-crossing for ");
		function.print();
		System.out.println(":");
		
		// Apply Newton's method and print results to the console
		if (zero.newton(x1, delta, maxIterations)) {
			double x0 = zero.getX0();
			System.out.printf(Locale.US, "Approximated x0   : %.6f\n", x0);
			System.out.printf(Locale.US, "Approximated f(x0): %.3e\n", function.f(x0));
		} else {
			System.out.println("Failed to dertermine zero-crossing!");
		}
	}
}
