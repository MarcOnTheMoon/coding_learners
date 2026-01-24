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
public class DiceDistribution {
	public static void main(String[] args) {
		int numberThrows = (int)(100 * 1.e6);
		int[] counts = new int[6];
		
		// Throw dice n times
		for (long i = 0; i < numberThrows; i++)
			counts[(int)(6.0 * Math.random())]++;
		
		// Print percentage of thrown numbers
		System.out.printf("Distribution throwing dice %d million times:\n", numberThrows / (int)1.e6);
		
		for (int i = 0; i < 6; i++) {
			System.out.printf(
					Locale.US, "Roll %d: %,d (%.2f %%)\n",
					i + 1, counts[i], 100 * counts[0] / (double) numberThrows);
		}
	}
}
