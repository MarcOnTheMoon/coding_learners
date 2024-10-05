package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RowReferences {

	/** Print coefficients as matrix to the console.
	 * 
	 * @param data Matrix coefficients to print
	 */
	static void print(int[][] data) {
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				System.out.printf("%3d ", data[y][x]);
			}
			System.out.println();
		}
		System.out.println();
	}

	/** Application starting point.
	 * 
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {
		int[][] a = new int[3][];
		
		// Init matrix with first and last rows referencing same array
		a[0] = new int[] {0, 1, 1};
		a[1] = new int[] {2, 4, 2};
		a[2] = a[0];
		
		// Print matrix coefficients to the console
		print(a);
		
		// Modify coefficients and print coefficients to the console
		System.out.println("Assign a[0][1] = 3 and a[2][0] = 5:\n");
		a[0][1] = 3;
		a[2][0] = 5;
		print(a);
	}
}
