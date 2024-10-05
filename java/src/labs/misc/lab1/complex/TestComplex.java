package labs.lab1.complex;

import static org.junit.Assert.*;
import org.junit.Test;

/** Unit tests for class Complex.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestComplex {
	final private double DOUBLE_EPS = 0.000001;		// Precision in comparison of double numbers

	/** Test if default constructor initializes to z = 0 + 0*j.<p>
	 *
	 * Tests getters implicitly.
	 */
	@Test
	public void test_R02_Complex_R04_Getters() {
		Complex	z = new Complex();

		assertEquals(0.0, z.getReal(), DOUBLE_EPS);
		assertEquals(0.0, z.getImag(), DOUBLE_EPS);
	}

	/** Test if constructor sets the correct values.<p>
	 *
	 * Tests getters implicitly.
	 */
	@Test
	public void test_R03_Complex_R04_Getters() {
		double real = -1.23;
		double imag = -4.56;
		Complex	z = new Complex(real, imag);

		assertEquals(real, z.getReal(), DOUBLE_EPS);
		assertEquals(imag, z.getImag(), DOUBLE_EPS);
	}

	/** Test that add(Complex) is correct and that argument is not modified
	 */
	@Test
	public void test_R05_add() {
		Complex	z1 = new Complex(2.5, 1.3);
		Complex	z2 = new Complex(4.5, 2.7);
		Complex z3 = z1.add(z2);

		// Test result of operation
		assertEquals(7.0, z1.getReal(), DOUBLE_EPS);
		assertEquals(4.0, z1.getImag(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(4.5, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.7, z2.getImag(), DOUBLE_EPS);

		// Assure return value is reference to first operand.
		assertSame(z3, z1);
	}

	/** Test that subtract(Complex) is correct and that argument is not modified
	 */
	@Test
	public void test_R05_subtract() {
		Complex	z1 = new Complex(2.5, 1.3);
		Complex	z2 = new Complex(4.5, 2.7);
		Complex z3 = z1.subtract(z2);

		// Test result of operation
		assertEquals(-2.0, z1.getReal(), DOUBLE_EPS);
		assertEquals(-1.4, z1.getImag(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(4.5, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.7, z2.getImag(), DOUBLE_EPS);

		// Assure return value is reference to first operand.
		assertSame(z3, z1);
	}

	/** Test that multiply(Complex) is correct and that argument is not modified
	 */
	@Test
	public void test_R05_multiply() {
		Complex	z1 = new Complex(2, 3);
		Complex	z2 = new Complex(4, 5);
		Complex z3 = z1.multiply(z2);

		// Test result of operation
		assertEquals((2*4 - 3*5), z1.getReal(), DOUBLE_EPS);
		assertEquals((2*5 + 3*4), z1.getImag(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(4.0, z2.getReal(), DOUBLE_EPS);
		assertEquals(5.0, z2.getImag(), DOUBLE_EPS);

		// Assure return value is reference to first operand.
		assertSame(z3, z1);
	}

	/** Test that divide(Complex) is correct and that argument is not modified
	 */
	@Test
	public void test_R05_divide_trivial() {
		Complex	z1 = new Complex(-6, 8);
		Complex	z2 = new Complex(0, 2);
		Complex z3 = z1.divide(z2);		// = -6/(2i) + (8i)/2i = 3i + 4

		// Test result of operation
		assertEquals(4.0, z1.getReal(), DOUBLE_EPS);
		assertEquals(3.0, z1.getImag(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(0.0, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.0, z2.getImag(), DOUBLE_EPS);

		// Assure return value is reference to first operand.
		assertSame(z3, z1);
	}

	/** Test that divide(Complex) is correct and that argument is not modified
	 */
	@Test
	public void test_R05_divide_complex() {
		Complex	z1 = new Complex(3, 4);
		Complex	z2 = new Complex(1, 2);
		Complex z3 = z1.divide(z2);		// = (3*1 + 4*2)/5 + (1*4 - 3*2)/5*i

		// Test result of operation
		assertEquals((3*1 + 4*2)/5.0, z1.getReal(), DOUBLE_EPS);
		assertEquals((1*4 - 3*2)/5.0, z1.getImag(), DOUBLE_EPS);

		// Assure argument has not been modified
		assertEquals(1.0, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.0, z2.getImag(), DOUBLE_EPS);

		// Assure return value is reference to first operand.
		assertSame(z3, z1);
	}

	/** Test that absolute value is calculated correctly.
	 */
	@Test
	public void test_R06_getAbsolute() {
		Complex	z = new Complex(-3.0, -4.0);
		double abs = 5.0;		// = sqrt(3*3 + 4*4) = sqrt(25)

		assertEquals(abs, z.getAbsolute(), DOUBLE_EPS);
	}

	/** Test that phase value is calculated correctly
	 */
	@Test
	public void test_R07_getPhase() {
		Complex z;
		double phase;

		// Origin
		z = new Complex(0.0, 0.0);
		assertEquals(0.0, z.getPhase(), DOUBLE_EPS);

		// Phase = x/4 * PI
		double a = 2.0;
		Complex[] arrayComplex = {
				new Complex( a,  0),	//   0� = 0   * PI
				new Complex( a,  a),	//  45� = 1/4 * PI
				new Complex( 0,  a),	//  90� = 1/2 * PI
				new Complex(-a,  a),	// 135� = 3/4 * PI
				new Complex(-a,  0),	// 180� = 1   * PI
				new Complex(-a, -a),	// 225� = 5/4 * PI
				new Complex( 0, -a),	// 270� = 3/2 * PI
				new Complex( a, -a)		// 315� = 7/4 * PI
		};

		for (int i = 0; i < 8; i++) {
			z = arrayComplex[i];
			phase = i/4.0 * Math.PI;
			assertEquals(phase, z.getPhase(), DOUBLE_EPS);
		}
	}

	/** Test that add(Complex,Complex) is correct and that arguments are not modified
	 */
	@Test
	public void test_R08_static_add() {
		Complex	z1 = new Complex(2.5, 1.3);
		Complex	z2 = new Complex(4.5, 2.7);
		Complex z = Complex.add(z1, z2);

		// Test result of operation
		assertEquals(7.0, z.getReal(), DOUBLE_EPS);
		assertEquals(4.0, z.getImag(), DOUBLE_EPS);

		// Assure arguments have not been modified
		assertEquals(2.5, z1.getReal(), DOUBLE_EPS);
		assertEquals(1.3, z1.getImag(), DOUBLE_EPS);
		assertEquals(4.5, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.7, z2.getImag(), DOUBLE_EPS);
	}

	/** Test that subtract(Complex,Complex) is correct and that arguments are not modified
	 */
	@Test
	public void test_R08_static_subtract() {
		Complex	z1 = new Complex(2.5, 1.3);
		Complex	z2 = new Complex(4.5, 2.7);
		Complex z = Complex.subtract(z1, z2);

		// Test result of operation
		assertEquals(-2.0, z.getReal(), DOUBLE_EPS);
		assertEquals(-1.4, z.getImag(), DOUBLE_EPS);

		// Assure arguments have not been modified
		assertEquals(2.5, z1.getReal(), DOUBLE_EPS);
		assertEquals(1.3, z1.getImag(), DOUBLE_EPS);
		assertEquals(4.5, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.7, z2.getImag(), DOUBLE_EPS);
	}

	/** Test that multiply(Complex,Complex) is correct and that arguments are not modified
	 */
	@Test
	public void test_R08_static_multiply() {
		Complex	z1 = new Complex(2, 3);
		Complex	z2 = new Complex(4, 5);
		Complex z = Complex.multiply(z1, z2);

		// Test result of operation
		assertEquals((2*4 - 3*5), z.getReal(), DOUBLE_EPS);
		assertEquals((2*5 + 3*4), z.getImag(), DOUBLE_EPS);

		// Assure arguments have not been modified
		assertEquals(2.0, z1.getReal(), DOUBLE_EPS);
		assertEquals(3.0, z1.getImag(), DOUBLE_EPS);
		assertEquals(4.0, z2.getReal(), DOUBLE_EPS);
		assertEquals(5.0, z2.getImag(), DOUBLE_EPS);
	}

	/** Test that divide(Complex,Complex) is correct and that arguments are not modified
	 */
	@Test
	public void test_R08_static_divide() {
		Complex	z1 = new Complex(3, 4);
		Complex	z2 = new Complex(1, 2);
		Complex z = Complex.divide(z1, z2);

		// Test result of operation
		assertEquals((3*1 + 4*2)/5.0, z.getReal(), DOUBLE_EPS);
		assertEquals((1*4 - 3*2)/5.0, z.getImag(), DOUBLE_EPS);

		// Assure arguments have not been modified
		assertEquals(3.0, z1.getReal(), DOUBLE_EPS);
		assertEquals(4.0, z1.getImag(), DOUBLE_EPS);
		assertEquals(1.0, z2.getReal(), DOUBLE_EPS);
		assertEquals(2.0, z2.getImag(), DOUBLE_EPS);
	}

	/** Test that toString returns correct string<p>
	 *
	 * Numbers should have at least 1 digit after the dot.
	 */
	@Test
	public void test_R09_toString() {
		Complex	z1 = new Complex(1.2, 2.3);
		Complex	z2 = new Complex(-3.456, -4);

		assertEquals("(1.2 + 2.3*j)", z1.toString());
		assertEquals("(-3.456 - 4.0*j)", z2.toString());

		// Test that number is not modified
		// (in particular, components not replaced by their absolute values).
		assertEquals(-3.456, z2.getReal(), DOUBLE_EPS);
		assertEquals(-4.0, z2.getImag(), DOUBLE_EPS);
	}
}
