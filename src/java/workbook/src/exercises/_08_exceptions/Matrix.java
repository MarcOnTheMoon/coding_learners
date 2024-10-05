package exercises._08_exceptions;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Matrix {
	private final int[][] data;
	
	/** Initialize matrix with 2D coefficients.
	 * 
	 * @param coefficients Matrix coefficients (M x N)
	 */
	public Matrix(int[][] coefficients) {
		this.data = coefficients.clone();
	}
	
	/** Calculate sum of all coefficients.
	 * 
	 * @return sum of coefficients
	 */
	public int sum() {
		int sum = 0;
		
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				sum += data[y][x];
			}
		}
		return sum;
	}

	/** Calculate matrix multiplication C = A * B.
	 * 
	 * @param a Matrix A with dimension M x N
	 * @param b Matrix B with dimension N x R
	 * @return product C = A * B with dimension M x R 
	 */
	public static Matrix multiply(Matrix a, Matrix b) {
		int aRows = a.data.length; 
		int aColumns = a.data[0].length; 
		int bRows = b.data.length; 
		int bColumns = b.data[0].length; 
				
		// Correct dimensions?
		if (aColumns != bRows) {
			String message = String.format("Dimensions do not match in matrix multiplication: %d != %d", aColumns, bRows);
			throw new LinearAlgebraException(message);
		}
		
		// Create product
		int[][] product = new int[aRows][bColumns];
		
		for (int y = 0; y < aRows; y++) {
			for (int x = 0; x < bColumns; x++) {
				int sum = 0;
				
				for (int i = 0; i < aColumns; i++)
					sum += a.data[y][i] * b.data[i][x];
				product[y][x] = sum;
			}
		}
		return new Matrix(product);
	}
	
	/** Print coefficients as matrix to the console.
	 */
	public void print() {
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				System.out.printf("%3d ", data[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
