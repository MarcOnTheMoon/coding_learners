package exercises._03_classes.c_static;

/** Class providing mathematical functions.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathFunctions {
	/** Factorial n! = 1 * 2 * 3 * ... * n.
	 * 
	 * @param n Number n for which to calculate the factorial n!
	 * @return factorial n!
	 */
	static long factorial(int n) {
		long factorial = 1;
		
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}
}
