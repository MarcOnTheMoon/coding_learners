package _06_abstract._geometry;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public abstract class Shape implements Comparable<Shape> {
	private double x, y;

	public Shape(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public abstract double getArea();
	
	public int compareTo(Shape other) {
		double thisArea = getArea();
		double otherArea = other.getArea();
		
		if (thisArea < otherArea) {
			return -1;
		} else if (thisArea > otherArea) {
			return 1;
		} else {
			return 0;
		}
	}
}
