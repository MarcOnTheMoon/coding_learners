package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class FloatGap {
	public static void main(String[] args) {
		long number = 0L;
		float thisFloat, nextFloat;
		
		// Determine gap
		do {
			thisFloat = (float) number;
			nextFloat = (float) ++number;
		} while (nextFloat - thisFloat > 0.9999);
		
		// Print results to the console
		System.out.println("(float) number:             " + (long)thisFloat);
		System.out.println("(float) (number + 1):       " + (long)nextFloat);
		System.out.println("Not representable as float: " + number);
	}
}
