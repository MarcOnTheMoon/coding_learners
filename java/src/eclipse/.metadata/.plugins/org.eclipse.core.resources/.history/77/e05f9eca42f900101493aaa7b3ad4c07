package exercises._04_library.b_arrays;

import java.util.Arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Lottery {
	int[] numbers;
	int maxValue;
	
	/** Instantiate lottery.
	 *  
	 * @param numbersToDraw Numbers to draw (e.g., 6 for "6 out of 49") 
	 * @param maxValue Maximum value of the numbers (e.g., 49 for "6 out of 49")
	 */
	Lottery(int numbersToDraw, int maxValue) {
		numbers = new int[numbersToDraw];
		this.maxValue = maxValue;
	}
	
	/** Draw the random numbers.
	 * 
	 * @return the numbers drawn in ascending order
	 */
	int[] drawNumbers() {
		// Clear array of drawn numbers (else duplicate might exclude old results)
		Arrays.fill(numbers, 0);
		
		// Draw random numbers
		for (int i = 0, number; i < numbers.length; i++) {
			// No duplicate numbers
			do {
				number = (int)(maxValue * Math.random()) + 1;
			} while (contains(number));
			numbers[i] = number;
		}

		// Sort ascending
		sort();
		
		return numbers;
	}
	
	/** Check whether the drawn numbers contain a specific value.
	 * 
	 * @param number Value to look for in array
	 * @return true, if the drawn numbers contain the value
	 */
	boolean contains(int number) {
		for (int item : numbers) {
			if (item == number)
				return true;
		}
		return false;
	}

	/** Sort the array of drawn numbers ascending.
	 */
	void sort() {
		for (int i = 1; i < numbers.length; i++) {
			// Swap, if neighboring values are in incorrect order
			if (numbers[i] < numbers[i - 1]) {
				// Swap
				int swap = numbers[i];
				numbers[i] = numbers[i - 1];
				numbers[i - 1] = swap;
				
				// Move lower value to the left
				if (i >= 2)
					i -= 2;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();

		output.append(String.format("%2d", numbers[0]));
		for (int i = 1; i < numbers.length; i++)
			output.append(String.format(", %2d", numbers[i]));
		
		return output.toString();
	}
}
