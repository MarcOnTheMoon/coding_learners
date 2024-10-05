package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class InitArray {

	public static void main(String[] args) {
		int[] a = new int[50];

		// Assign array values
		for (int i = 0; i < a.length; i++)
			a[i] = a.length - i;
		
		// Print array values to the console
		for (int i = 0; i < a.length; i++) {
			System.out.printf("%2d ", a[i]);
			if ((i % 10) == 9)
				System.out.println();
		}
	}
}
