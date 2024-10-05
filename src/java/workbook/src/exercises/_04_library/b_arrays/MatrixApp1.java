package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MatrixApp1 {

	public static void main(String[] args) {
		Matrix a = new Matrix(new int[][] {{2, -1, 1}, {1, 3, -4}, {2, 4, -2}});

		// Print matrix and sum
		System.out.printf("Matrix A with coefficient sum = %d:\n", a.sum());
		a.print();
	}
}
