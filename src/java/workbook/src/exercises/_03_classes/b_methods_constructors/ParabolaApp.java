package exercises._03_classes.b_methods_constructors;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ParabolaApp {
	public static void main(String[] args) {
		Parabola function = new Parabola(-1.0, 0.0, 4.0);
		int xLimit = 4;
		
		// Print function
		System.out.print("Selected values for ");
		function.print();
		System.out.print(":\n\n");

		// Print table with selected function values
		System.out.print("  x ");
		for (int i = -xLimit; i <= xLimit; i++)
			System.out.printf(" | %3d", i);

		System.out.print("\nf(x)");
		for (int i = -xLimit; i <= xLimit; i++)
			System.out.printf(" | %3.0f", function.f(i));
		System.out.println();
	}
}
