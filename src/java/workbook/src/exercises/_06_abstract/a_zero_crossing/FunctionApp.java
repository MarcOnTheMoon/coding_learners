package exercises._06_abstract.a_zero_crossing;

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
public class FunctionApp {
	public static void main(String[] args) {
		ArrayList<Function> functions = new ArrayList<Function>();
		Function parabola = new Parabola(1.0, 0.0, 0.0);
		Function log2 = new Logarithm(2);
		final int X_MAX = 8;

		// Create list of functions
		functions.add(parabola);
		functions.add(log2);
		
		// Print selected values of functions
		System.out.printf("%-16s", "x");
		for (int x = 1; x <= X_MAX; x++)
			System.out.printf(Locale.US, "   %4.1f", (double)x);
		System.out.println();
		
		for (Function function : functions) {
			System.out.printf("%-16s", function.toString().replace(',', '.'));
			for (int x = 1; x <= X_MAX; x++)
				System.out.printf(Locale.US, " | %4.1f", function.f(x));
			System.out.println(" |");
		}
	}
}
