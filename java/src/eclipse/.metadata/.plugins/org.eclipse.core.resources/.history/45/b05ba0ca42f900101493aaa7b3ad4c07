package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MatrixVector {
	
	/** Calculate matrix vector product y = A * x.
	 *  
	 * @param matrix Matrix A with dimension 3 x 3
	 * @param vector Vector x with dimension 3 x 1
	 * @return vector y = A * x with dimension 3 x 1
	 */
	static int[] product3x3(int[][] matrix, int[] vector) {
		final int DIMENSION = 3;
		int[] y = new int[DIMENSION];
		
		// Ensure that dimensions are correct
		if ((matrix.length != DIMENSION) || (matrix[0].length != DIMENSION) || (vector.length != DIMENSION))
			return null;
		
		// Calculate product
		for (int row = 0; row < DIMENSION; row++)
		{
			for (int column = 0; column < DIMENSION; column++)
				y[row] += matrix[row][column] * vector[column];
		}
		
		return y;
	}

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		int[][] a = {
				{ 1, 2, 0 },
				{ 0, 2, 1 },
				{ 3, 0, 1 }};
		int[] x = { 2, 1, 3 }, y;

		// Calculate product
		y = product3x3(a, x);

		// Print result
		System.out.printf("         |%d %d %d|   |%d|   |%d|\n", a[0][0], a[0][1], a[0][2], x[0], y[0]);
		System.out.printf("y = Ax = |%d %d %d| * |%d| = |%d|\n", a[1][0], a[1][1], a[1][2], x[1], y[1]);
		System.out.printf("         |%d %d %d|   |%d|   |%d|\n", a[2][0], a[2][1], a[2][2], x[2], y[2]);
	}
}
