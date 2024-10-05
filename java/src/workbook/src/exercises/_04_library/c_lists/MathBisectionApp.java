package exercises._04_library.c_lists;

import java.util.ArrayList;
import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathBisectionApp {
	public static void main(String[] args) {
		Parabola function = new Parabola(-1.0, 0.0, 4.0);
		ZeroCrossing zero = new ZeroCrossing(function);
		double xl = 1.8, xr = 2.3, delta = 1.0e-2;
		
		// Print function's formula to the console
		System.out.print("Zero-crossing for ");
		function.print();
		System.out.println(":");
		
		// Apply bisection and print results to the console
		ArrayList<double[]> borders = zero.bisection(xl, xr, delta); 
		if (borders.size() > 0) {
			double x0 = zero.getX0();
			
			for (int i = 0; i < borders.size(); i++) {
				double[] xLeftRight = borders.get(i);
				System.out.printf(Locale.US, "Bisection interval: [%.3f , %.3f]\n", xLeftRight[0], xLeftRight[1]);
			}
				
			System.out.printf(Locale.US, "\nApproximated x0   : %.6f\n", x0);
			System.out.printf(Locale.US, "Approximated f(x0): %.3e\n", function.f(x0));
		} else {
			System.out.println("Failed to dertermine zero-crossing!");
		}
	}
}
