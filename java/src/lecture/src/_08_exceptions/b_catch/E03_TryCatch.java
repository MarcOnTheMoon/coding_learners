package _08_exceptions.b_catch;

/** Illustrate catching an exception.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E03_TryCatch {

	public static void main(String[] args) {
		int a = 3;
		int b = 0;
		
		printRatio(a, b);
		System.out.println("Exiting main()");
	}
	
	public static void printRatio(int a, int b) {
		try {
			int ratio = a / b;
			System.out.println("Ratio = " + ratio);
		} catch (ArithmeticException e) {
			System.out.println("Exception caught in printRatio()");
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.toString(): " + e + "\n");
		}
		System.out.println("Exiting printRatio()");
	}
}
