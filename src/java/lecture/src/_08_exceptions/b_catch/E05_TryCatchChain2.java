package _08_exceptions.b_catch;

/** Illustrate catching an exception by calling method.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E05_TryCatchChain2 {

	public static void main(String[] args) {
		try {
			int ratio = getRatio(3, 0);
			System.out.println("Ratio = " + ratio);
		} catch (ArithmeticException e) {
			System.out.println("Exception caught in main()");
		}
		System.out.println("Exiting main()");
	}
	
	public static int getRatio(int a, int b) {
		int ratio = a / b;
		System.out.println("Exiting getRatio()");
		return ratio;
	}
}
