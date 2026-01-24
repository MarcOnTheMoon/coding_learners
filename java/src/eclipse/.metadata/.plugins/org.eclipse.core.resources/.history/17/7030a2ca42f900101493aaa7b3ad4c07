package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class CompareArrays {
	/** Check if arrays contains the same values.
	 * 
	 * @param a First array
	 * @param b Second array
	 * @return true, if a and b are of same size with identical values
	 */
	static boolean equalContents(int[] a, int[] b) {
		// Arrays of different length
		if (a.length != b.length)
			return false;
		
		// Compare contents
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}
	
	/** Get string containing array's values.
	 * 
	 * @param a Array with values
	 * @return String containing the array's values
	 */
	static String arrayToString(int[] a) {
		StringBuilder output = new StringBuilder();
		
		if (a.length > 0)
			output.append(a[0]);
		
		for (int i = 1; i < a.length; i++)
			output.append(" ").append(a[i]);
		
		return output.toString();
	}

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		int[] reference = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] copy = new int[] { 1, 2, 3, 4, 5, 6 };
		int[] otherValues = new int[] { 1, 2, 3, 4, 6, 7 };
		int[] otherSize = new int[] { 1, 2, 3 };
		
		// Print reference array
		System.out.printf("Compare array %s to:\n", arrayToString(reference));
		
		// Compare to other arrays
		System.out.printf("a) Exact copy  : %-12s -> %s\n", arrayToString(reference), equalContents(reference, copy));
		System.out.printf("b) Other values: %-12s -> %s\n", arrayToString(otherValues), equalContents(reference, otherValues));
		System.out.printf("c) Other size  : %-12s -> %s\n", arrayToString(otherSize), equalContents(reference, otherSize));
	}
}
