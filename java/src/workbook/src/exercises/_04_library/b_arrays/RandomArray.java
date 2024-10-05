package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RandomArray {
	static final int MAX_VALUE = 25;
	int[] values;
	
	/** Instantiate object.
	 * 
	 * @param size Number of array values
	 */
	RandomArray(int size) {
		// Instantiate array
		values = new int[size];
		
		// Initialize with random numbers in [1, MAX_VALUE]
		for (int i = 0; i < values.length; i++)
			values[i] = (int)(MAX_VALUE * Math.random()) + 1;
	}
	
	/** Check whether the array contains a specific value.
	 * 
	 * @param value Value to look for in array
	 * @return true, if the array contains the value
	 */
	boolean contains(int value) {
		for (int item : values) {
			if (item == value)
				return true;
		}
		return false;
	}
	
	/** Sort the array values ascending.
	 */
	void sort() {
		for (int i = 1; i < values.length; i++) {
			// Swap, if neighboring values are in incorrect order
			if (values[i] < values[i - 1]) {
				// Swap elements
				int swap = values[i];
				values[i] = values[i - 1];
				values[i - 1] = swap;
				
				// Move lower value to the left
				if (--i >= 1)
					i--;
			}
		}
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		if (values.length > 0)
		 output.append(values[0]);
		
		for (int i = 1; i < values.length; i++)
			output.append(", ").append(values[i]);
		
		return output.toString();
	}
}
