package _08_exceptions.a_throw;

/** Illustrate to explicitly throw an exception.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E02_ThrowException {

	public static void main(String[] args) {
		int a = 3;
		int b = 0;
		
		printRatio(a, b);
		System.out.println("Exiting main()");
	}
	
	public static void printRatio(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Division by zero");
		}
		
		System.out.println("Ratio = " + (a / b));
	}
}










