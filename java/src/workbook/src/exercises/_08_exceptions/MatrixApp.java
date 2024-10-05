package exercises._08_exceptions;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MatrixApp {

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		Matrix a = new Matrix(new int[][] {{2, 3}, {4, -1}});
		Matrix b = new Matrix(new int[][] {{2, -1, 1}, {3, 2, 4}});
		Matrix product;

		// Print matrices
		System.out.println("Matrix A:");
		a.print();

		System.out.println("Matrix B:");
		b.print();

		// Print product AB
		System.out.println("Multiplikation AB:");
		try {
			product = Matrix.multiply(a, b);
			product.print();
		} catch (LinearAlgebraException exception) {
			System.out.println(exception.getMessage());
		}

		// Print product BA
		System.out.println("Multiplikation BA:");
		try {
			product = Matrix.multiply(b, a);
			product.print();
		} catch (LinearAlgebraException exception) {
			System.out.println("WARNING: " + exception.getMessage());
		}
	}
}
