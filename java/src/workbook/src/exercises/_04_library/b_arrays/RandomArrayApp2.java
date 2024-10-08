package exercises._04_library.b_arrays;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RandomArrayApp2 {
	public static void main(String[] args) {
		RandomArray numbers = new RandomArray(10);
		
		// Sort values ascending
		numbers.sort();

		// Print the array's values to the console
		System.out.println("Random array: " + numbers);
		
		// Check, which numbers in [1, 5] are in array
		for (int i = 1; i <= 5; i++) {
			System.out.printf("Contains %d: %b%n", i, numbers.contains(i));
		}
	}
}
