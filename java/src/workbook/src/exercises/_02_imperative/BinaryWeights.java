package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class BinaryWeights {
	public static void main(String[] args) {
		int n = 0, weight = 1;

		// Calculate and print binary weights
		System.out.println("2^" + n + " = " + weight);
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
		System.out.println("2^" + ++n + " = " + (weight *= 2));
	}
}
