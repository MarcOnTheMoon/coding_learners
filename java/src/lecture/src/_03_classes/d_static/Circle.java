package _03_classes.d_static;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Circle {
	double x, y, radius;
	static final double PI = 3.141592653589793;
	static int count;
	
	Circle() {
		radius = 1.0;
		count++;
	}

	static double getPi() {
		return 3.141592653589793;
	}
	
	double getArea() {
		return PI * radius * radius;
	}
}
