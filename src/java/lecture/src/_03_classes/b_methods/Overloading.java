package _03_classes.b_methods;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Overloading {
	
	int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}
	
	double max(double a, double b) {
		return (a > b) ? a : b;		// Compact if/else syntax
	}
	
	int max(int a, int b, int c) {
		return max( max(a, b), c);
	}
	
	short max(short a, short b) {
		System.out.println("Aaaarrrghhh!");
		return 7;
	}
}
