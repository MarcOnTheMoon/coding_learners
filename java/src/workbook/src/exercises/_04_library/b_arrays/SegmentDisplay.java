package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SegmentDisplay {
	static final byte[][] digitSignals = {
			{ 1, 1, 1, 1, 1, 1, 0 },		// Digit '0'
			{ 0, 1, 1, 0, 0, 0, 0 },		// Digit '1'
			{ 1, 1, 0, 1, 1, 0, 1 },		// ...
			{ 1, 1, 1, 1, 0, 0, 1 },
			{ 0, 1, 1, 0, 0, 1, 1 },
			{ 1, 0, 1, 1, 0, 1, 1 },
			{ 1, 0, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 0, 1, 1 }			// Digit '9'
	};
	
	/** Get display signals a to g corresponding to a digit.
	 * 
	 * @param digit Digit to get signals for [0,..,9]
	 * @return control signals [a, b, c, d, e, f, g]
	 */
	static byte[] digitToSignals(int digit) {
		if ((digit >= 0) && (digit <= 9))
			return digitSignals[digit];
		else
			return null;
	}
	
	/** Print display segments for given signals a to g.
	 * 
	 * @param signals Control signals [a, b, c, d, e, f, g] 
	 */
	static void print(byte[] signals) {
		System.out.printf("  %s\n", signals[0] == 1 ? "---" : "   ");
		System.out.printf(" %c   %c\n", signals[5] == 1 ? '|' : ' ', signals[1] == 1 ? '|' : ' ');
		System.out.printf("  %s\n", signals[6] == 1 ? "---" : "   ");
		System.out.printf(" %c   %c\n", signals[4] == 1 ? '|' : ' ', signals[2] == 1 ? '|' : ' ');
		System.out.printf("  %s\n", signals[3] == 1 ? "---" : "   ");
	}
}
