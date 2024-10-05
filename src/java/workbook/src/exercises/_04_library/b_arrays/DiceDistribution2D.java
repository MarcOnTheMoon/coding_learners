package exercises._04_library.b_arrays;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceDistribution2D {

	public static void main(String[] args) {
		final int NUMBER_ROLLS = (int)1.e6;
		int[][] histogram = new int[6][6];
		
		// Simulate dice rolls
		for (int i = 0; i < NUMBER_ROLLS; i++) {
			int dice1 = (int)(6.0 * Math.random());
			int dice2 = (int)(6.0 * Math.random());
			histogram[dice1][dice2]++;
		}

		// Print results to the console
		System.out.printf(Locale.US, "Frequency in %% when rolling two dices %,d times:\n\n", NUMBER_ROLLS);
		System.out.println("  |   1     2     3     4     5     6");
		System.out.println("--+------------------------------------");
		
		for (int y = 0; y < histogram.length; y++) {
			System.out.print((y + 1) + " |");
			
			for (int x = 0; x < histogram[y].length; x++) {
				double percentage = 100.0 * (histogram[y][x] / (double)NUMBER_ROLLS);
				System.out.printf(Locale.US, "%5.2f ", percentage);		
			}
			System.out.println();
		}
	}
}
