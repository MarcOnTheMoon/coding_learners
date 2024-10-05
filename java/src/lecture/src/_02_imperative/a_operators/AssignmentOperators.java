package _02_imperative.a_operators;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AssignmentOperators {

	public static void main(String[] args) {
		int a = 1;
		a += 2; 						// a = a + 2 = 3
		System.out.println(a);
	 	System.out.println(a *= --a);	// a = a * 2 = 6
		System.out.println(a *= -a++);	// a = a * (-6) = -36
		System.out.println(a /= 10);	// a = -3
	}
}
