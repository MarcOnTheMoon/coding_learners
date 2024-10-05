package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MatrixApp2 {

	public static void main(String[] args) {
		Matrix a = new Matrix(new int[][] {{2, -1, 1}, {1, 3, -4}, {2, 4, -2}});
		Matrix b = new Matrix(new int[][] {{1, 2, 3}, {2, 1, 4}, {2, 3, 1}});
		Matrix unity = new Matrix(new int[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}});
		Matrix product;

		// Print products
		System.out.println("Multiplikation AE:");
		product = Matrix.multiply(a, unity);
		product.print();

		System.out.println("Multiplikation EA:");
		product = Matrix.multiply(unity, a);
		product.print();

		System.out.println("Multiplikation AB:");
		product = Matrix.multiply(a, b);
		product.print();
	}
}
