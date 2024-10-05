package labs.lab1.vector;

import static org.junit.Assert.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.junit.Test;

/** Unit tests for lab assignment.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestVector2D {
	final private double DOUBLE_EPS = 0.000001;		// Precision in comparison of double numbers
	
	/** Test if all instance variables are private.
	 */
	@Test
	public final void test_R01_areVariablesPrivate() {
		assertTrue(areVariablesPrivate("lab1.vector.Vector2D"));
	}

	/** Test if constructor sets the correct values.<p>
	 * 
	 * Tests getters implicitly.
	 */
	@Test
	public void test_R02_R03_Getters() {
		Vector2D a = new Vector2D(1.5, -2.4);

		assertEquals(1.5, a.getX(), DOUBLE_EPS);
		assertEquals(-2.4, a.getY(), DOUBLE_EPS);
	}

	/** Test that add() is correct and that argument is not modified.
	 */
	@Test
	public void test_R04_add() {
		Vector2D a1 = new Vector2D(2.5, 1.3);
		Vector2D a2 = new Vector2D(4.5, 2.7);
		Vector2D a3 = a1.add(a2);

		// Test result of operation
		assertEquals(7.0, a1.getX(), DOUBLE_EPS);
		assertEquals(4.0, a1.getY(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(4.5, a2.getX(), DOUBLE_EPS);
		assertEquals(2.7, a2.getY(), DOUBLE_EPS);
		
		// Assure return value is reference to first operand.
        assertSame(a3, a1);
	}

	/** Test that subtract() is correct and that argument is not modified.
	 */
	@Test
	public void test_R04_subtract() {
		Vector2D a1 = new Vector2D(2.5, 1.3);
		Vector2D a2 = new Vector2D(4.5, 2.7);
		Vector2D a3 = a1.subtract(a2);

		// Test result of operation
		assertEquals(-2.0, a1.getX(), DOUBLE_EPS);
		assertEquals(-1.4, a1.getY(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(4.5, a2.getX(), DOUBLE_EPS);
		assertEquals(2.7, a2.getY(), DOUBLE_EPS);
		
		// Assure return value is reference to first operand.
        assertSame(a3, a1);
	}

	/** Test that multiply() is correct.
	 */
	@Test
	public void test_R04_multiply() {
		double c = -1.25;
		Vector2D a1 = new Vector2D(2.1, 3.7);
		Vector2D a2 = a1.multiply(c);

		// Test result of operation
		assertEquals((2.1 * c), a1.getX(), DOUBLE_EPS);
		assertEquals((3.7 * c), a1.getY(), DOUBLE_EPS);
		
		// Assure return value is reference to first operand.
        assertSame(a2, a1);
	}
	
	/** Test that absolute value is calculated correctly.
	 */
	@Test
	public void test_R05_getAbsolute() {
		Vector2D a = new Vector2D(-3.0, -4.0);
		double abs = 5.0;		// = sqrt(3*3 + 4*4) = sqrt(25)

		assertEquals(abs, a.getAbsolute(), DOUBLE_EPS);
	}

	/** Test that mul(Vector2D, Vector2D) is correct and that arguments are not modified.
	 */
	@Test
	public void test_R06_static_multiply() {
		Vector2D a1 = new Vector2D(2.1, 3.5);
		Vector2D a2 = new Vector2D(4.2, 5.7);
		double product = Vector2D.multiply(a1, a2);

		// Test result of operation
		assertEquals((2.1 * 4.2 + 3.5 * 5.7), product, DOUBLE_EPS);

		// Assure arguments have not been modified
		assertEquals(2.1, a1.getX(), DOUBLE_EPS);
		assertEquals(3.5, a1.getY(), DOUBLE_EPS);
		assertEquals(4.2, a2.getX(), DOUBLE_EPS);
		assertEquals(5.7, a2.getY(), DOUBLE_EPS);
	}

	/** Test that toString returns correct string.
	 */
	@Test
	public void test_R07_toString() {
		Vector2D a1 = new Vector2D(1.2, 2.3);
		Vector2D a2 = new Vector2D(-3.456, -4);

		// Test that returned string is correct
		assertEquals("(1.2 , 2.3)^T", a1.toString());
		assertEquals("(-3.456 , -4.0)^T", a2.toString());
		
		// Test that number is not modified
		// (in particular, components not replaced by their absolute values).
		assertEquals(1.2, a1.getX(), DOUBLE_EPS);
		assertEquals(2.3, a1.getY(), DOUBLE_EPS);
		assertEquals(-3.456, a2.getX(), DOUBLE_EPS);
		assertEquals(-4.0, a2.getY(), DOUBLE_EPS);
	}
	
	/** Test if in class all modifiers of instance variables are "private".
	 * 
	 * @param fullClassName Class name (including packages, e.g.: "histogram.Histogram")
	 * @return True if all instance variables are private
	 */
	public static boolean areVariablesPrivate(String fullClassName) {
		try {
			Class<?> c = Class.forName(fullClassName);
			Field[] fields = c.getDeclaredFields();

			for (Field f : fields) {
				int modifier = f.getModifiers();
				boolean isPrivate = (modifier & Modifier.PRIVATE) != 0;

				if (!isPrivate) {
					return false;
				}
			}
			return true;
		} catch (ClassNotFoundException e) {
			fail("Class not found");
		}
		return false;
	} 
}
