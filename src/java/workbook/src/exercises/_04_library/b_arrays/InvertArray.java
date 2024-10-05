package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class InvertArray {

	public static void main(String[] args) {
		int[] a = new int[]{1, 2, 5, 9, 11, 20, 26};

		// Print array to the console
		System.out.print("Source   : ");
		for (int i = 0; i < a.length; i++)
			System.out.printf("%2d ", a[i]);

		// Invert array order
		for (int i = 0; i < a.length / 2; i++) {
			int swapValue = a[i];
			a[i] = a[a.length - (i + 1)];
			a[a.length - (i + 1)] = swapValue;
		}
		
		// Print reordered array to the console
		System.out.print("\nReordered: ");
		for (int i = 0; i < a.length; i++)
			System.out.printf("%2d ", a[i]);
	}
}
