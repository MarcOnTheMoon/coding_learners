package _05_inheritance.d_comparisons;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PointDemo {
	public static void main(String[] args) {
		Point a1 = new Point(10, 25);
		Point b1 = new Point(10, 2);
		System.out.print("a1 == b1 : " + (a1 == b1) + "\t\t");
		System.out.println("a1.equals(b1) : " + a1.equals(b1));

		Point a2 = new Point(10, 25);
		Point b2 = new Point(10, 25);
		System.out.print("a2 == b2 : " + (a2 == b2) + "\t\t");
		System.out.println("a2.equals(b2) : " + a2.equals(b2));

		Point a3 = new Point(10, 25);
		Point b3 = a3;
		System.out.print("a3 == b3 : " + (a3 == b3) + "\t\t");
		System.out.println("a3.equals(b3) : " + a3.equals(b3));
	}
}

class Point {
	double x, y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Point)) {
			return false;
		}
		Point other = (Point) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x)) {
			return false;
		}
		if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y)) {
			return false;
		}
		return true;
	}
}