package _08_exceptions.c_custom_classes;

//@SuppressWarnings("serial")
//class NegativeParamException extends Exception {
//}

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E13_OwnException2 {

	public static void main(String[] args) throws NegativeParamException {
		double x = 25.0; 
		System.out.printf("sqrt(%f) = %f", x, squareRoot(x));
	}

	public static double squareRoot(double x) throws NegativeParamException {
		if (x < 0.0) {
			throw new NegativeParamException();
		}
		return Math.sqrt(x);
	}
}
