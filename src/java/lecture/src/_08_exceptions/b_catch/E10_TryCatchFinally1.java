package _08_exceptions.b_catch;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E10_TryCatchFinally1 {

	static int recursiveIncrease(int i) {
		return recursiveIncrease(i + 1);		// F�hrt zu Endlos-Rekursion
	}

	public static void main(String[] args) {
		int[] a = new int[4];

		try {
			a[4] = 0;
		} catch (ArrayIndexOutOfBoundsException e1) {
			recursiveIncrease(7);
			System.out.println("Caught ArrayIndexOutOfBoundsException");
		} finally {
			System.out.println("Finally");
		}
		System.out.println("Exiting main()");
	}
}
