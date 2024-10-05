package labs.introduction;

import static org.junit.Assert.*;

import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.04.17<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestPoint2D {
	final private double DOUBLE_EPS = 0.000001;		// Precision in comparison of double numbers

	/** Test if constructor sets the correct values.<p>
	 *
	 * Tests getters implicitly.
	 */
	@Test
	public void test_01_Getters() {
		Point2D a = new Point2D(1, -2);

		assertEquals(1, a.getX());
		assertEquals(-2, a.getY());
	}

	/** Test if standard constructor sets the correct values.<p>
	 *
	 * Tests getters implicitly.
	 */
	@Test
	public void test_01_Getters_StandardConstructor() {
		Point2D a = new Point2D();

		assertEquals(0, a.getX());
		assertEquals(0, a.getY());
	}

	/** Test that add() is correct and that argument is not modified.
	 */
	@Test
	public void test_02_add() {
		Point2D a1 = new Point2D(2, 1);
		Point2D a2 = new Point2D(4, 2);
		Point2D a3 = a1.add(a2);

		// Test result of operation
		assertEquals(6, a1.getX());
		assertEquals(3, a1.getY());

		// Assure argument has not been modified
		assertEquals(4, a2.getX());
		assertEquals(2, a2.getY());

		// Assure return value is reference to first operand.
		assertSame(a3, a1);
	}

	/** Test that absolute value is calculated correctly.
	 */
	@Test
	public void test_05_getDistanceFromOrigin() {
		Point2D a = new Point2D(-3, -4);
		double distance = 5.0;		// = sqrt(3*3 + 4*4) = sqrt(25)

		assertEquals(distance, a.getDistanceFromOrigin(), DOUBLE_EPS);
	}
}
