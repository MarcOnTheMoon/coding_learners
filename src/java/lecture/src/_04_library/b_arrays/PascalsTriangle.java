package _04_library.b_arrays;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PascalsTriangle {

	/** Create Pascal's triangle.
	 * 
	 * @param rows Number of rows to create
	 * @return triangle with Pascal's coefficients
	 */
	public static int[][] createPascalsTriangle(int rows) {
		int[][] triangle = new int[rows][];
	
		// Create data structure
		for (int row = 0; row < triangle.length; row++) {
			triangle[row] = new int[row + 1];
		}
		
		// Set coefficient values
		for (int row = 0; row < triangle.length; row++) {
			int[] thisRow = triangle[row];
			
			// Set first and last element to 1
			thisRow[0] = 1;
			thisRow[thisRow.length - 1] = 1;
			
			// Set other elements from row above
			for (int column = 1; column < thisRow.length - 1; column++) {
				thisRow[column] = triangle[row - 1][column - 1] + triangle[row - 1][column];
			}
		}
		return triangle;
	}

	/** Print matrix coefficients to screen.
	 * 
	 * @param matrix Matrix to print
	 */
	public static void printMatrix(int[][] matrix) {
		for (int row = 0; row < matrix.length; row++) {			
			for (int column = 0; column < matrix[row].length; column++) {
				System.out.print(matrix[row][column] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		final int numberRows = 7;
		int[][] triangle = createPascalsTriangle(numberRows);
		printMatrix(triangle);
	}

}
