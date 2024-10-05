package _03_classes.c_constructors;

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
	
	Circle(double x, double y, double radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	Circle() {
		this(0.0, 0.0, 1.0);
	}

	Circle(double radius) {
		this(0.0, 0.0, radius);
	}

	Circle(Circle circle) {
		this(circle.x, circle.y, circle.radius);
	}

	double getX() {
		return x;
	}

	double getY() {
		return y;
	}

	double getRadius() {
		return radius;
	}

	void setX(double x) {
		this.x = x;
	}

	void setY(double y) {
		this.y = y;
	}

	void setRadius(double radius) {
		if (radius >= 0.0) {
			this.radius = radius;
		}
	}		
}
