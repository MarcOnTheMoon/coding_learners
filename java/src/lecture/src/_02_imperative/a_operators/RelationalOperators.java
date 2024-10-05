package _02_imperative.a_operators;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RelationalOperators {

	public static void main(String[] args) {
		int a = 7, b = 4;
		boolean parentheses = (a > b) == (a <= b);
		boolean priorities = a > b == a <= b;
		System.out.println(parentheses);
		System.out.println(priorities);
	}
}
