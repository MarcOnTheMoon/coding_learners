package exercises._04_library.b_arrays;

import javax.swing.JOptionPane;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SegmentDisplayApp {

	public static void main(String[] args) {
		int digit;

		// Get digit from user
		do {
			String input = JOptionPane.showInputDialog("Please enter a digit (0..9)");
			digit = input.charAt(0) - '0';
		} while ((digit < 0) || (digit > 9));
		
		// Get control signals a to g for the digit
		byte[] controlSignals = SegmentDisplay.digitToSignals(digit);

		// Print control signals a to g
		System.out.printf("Control signals of 7 segment display (digit '%d'):\n\n", digit);
		System.out.println(" a | b | c | d | e | f | g\n---+---+---+---+---+---+---");
		System.out.printf(" %d ", controlSignals[0]);
		for (int i = 1; i < 7; i++)
			System.out.printf("| %d ", controlSignals[i]);

		// Print simulated display
		System.out.print("\n\nDisplay:\n");
		SegmentDisplay.print(controlSignals);
	}

}
