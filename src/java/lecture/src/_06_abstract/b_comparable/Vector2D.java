package _06_abstract.b_comparable;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Vector2D implements Comparable<Vector2D> {
	private double x, y;

	public Vector2D(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public double getAbs() {
		return Math.sqrt(x * x + y * y);
	}

	@Override
	public int compareTo(Vector2D other) {
		if (getAbs() < other.getAbs()) {
			return -1;
		} else if (getAbs() > other.getAbs()) {
			return 1;
		} else {
			return 0;
		}
	}
}
