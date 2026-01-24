package analysis;

import org.junit.Test;

import static org.junit.Assert.*;

/** Unit tests provided for the final exam E3-OP.
 *
 * @version SoSe 2024
 * @author Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">http://www.haw-hamburg.de/marc-hensel</a>)
 */
public class UnitTests {
	// Default values
	final private double DOUBLE_EPS = 0.001;	// Precision in comparison of double numbers

	@Test
	public final void testR04_Function_zeroCrossing() {
		// Create function f(x) = x^2 - 4
		Function function = new Function() {
			@Override
			public double f(double x) {
				return x * x - 4.0;
			}

			@Override
			public double df(double x) {
				return 2.0 * x;
			}
			
		};
		
		// Assert left and right zero-crossings are found
		double xl = function.zeroCrossing(-3.0, 1.0e-6, 100);
		double xr = function.zeroCrossing(4.0, 1.0e-6, 100);
		assertEquals(-2.0, xl, DOUBLE_EPS);
		assertEquals(2.0, xr, DOUBLE_EPS);
	}

	@Test
	public final void testR09_QuadraticFunction_getCoefficient(){
		double a2 = 3.2, a1 = 2.1, a0 = 1.0;
		QuadraticFunction polynom = new QuadraticFunction(a2, a1, a0);
		
		assertEquals(a0, polynom.getCoefficient(0), DOUBLE_EPS);
		assertEquals(a1, polynom.getCoefficient(1), DOUBLE_EPS);
		assertEquals(a2, polynom.getCoefficient(2), DOUBLE_EPS);
	}

	@Test
	public final void testR09_QuadraticFunction_f(){
		double a2 = 1.0, a1 = 0.0, a0 = -1.0;
		QuadraticFunction polynom = new QuadraticFunction(a2, a1, a0);
		
		assertEquals(-1.0, polynom.f(0.0), DOUBLE_EPS);		// f(0) = 1 * 0^2 - 1 = -1
		assertEquals(0.0, polynom.f(1.0), DOUBLE_EPS);		// f(1) = 1 * 1^2 - 1 = 0
		assertEquals(3.0, polynom.f(2.0), DOUBLE_EPS);		// f(2) = 1 * 2^2 - 1 = 3
	}

	@Test
	public final void testR10_QuadraticFunction_df(){
		double a2 = 1.0, a1 = 0.0, a0 = -1.0;
		QuadraticFunction polynom = new QuadraticFunction(a2, a1, a0);
		
		assertEquals(0.0, polynom.df(0.0), DOUBLE_EPS);		// f'(0) = 2 * 0 = 0
		assertEquals(2.0, polynom.df(1.0), DOUBLE_EPS);		// f'(1) = 2 * 1 = 2
		assertEquals(4.0, polynom.df(2.0), DOUBLE_EPS);		// f'(3) = 2 * 2 = 4
	}

	@Test
	public final void testR11_QuadraticFunction_add(){
		double a2 = 1.0, a1 = 2.0, a0 = 3.0;
		double b2 = 4.0, b1 = 5.0, b0 = 6.0;
		QuadraticFunction polynomA = new QuadraticFunction(a2, a1, a0);
		QuadraticFunction polynomB = new QuadraticFunction(b2, b1, b0);

		polynomA.add(polynomB);
		assertEquals(a0 + b0, polynomA.getCoefficient(0), DOUBLE_EPS);
		assertEquals(a1 + b1, polynomA.getCoefficient(1), DOUBLE_EPS);
		assertEquals(a2 + b2, polynomA.getCoefficient(2), DOUBLE_EPS);
	}

	@Test
	public final void testR12_QuadraticFunction_multiply(){
		double k = -1.5; 
		double a2 = 1.0, a1 = -2.0, a0 = 2.25;
		QuadraticFunction polynom = new QuadraticFunction(a2, a1, a0);

		polynom.multiply(k);
		assertEquals(k * a0, polynom.getCoefficient(0), DOUBLE_EPS);
		assertEquals(k * a1, polynom.getCoefficient(1), DOUBLE_EPS);
		assertEquals(k * a2, polynom.getCoefficient(2), DOUBLE_EPS);
	}

	@Test
	public final void testR13_QuadraticFunction_zeroCrossings(){
		// Zero-crossings exist
		QuadraticFunction polynom = new QuadraticFunction(1.0, 0.0, -4.0);
		double[] zeros = polynom.zeroCrossings();
		assertEquals(-2.0, zeros[0], DOUBLE_EPS);
		assertEquals(2.0, zeros[1], DOUBLE_EPS);
		
		// Zero-crossings do not exist
		polynom = new QuadraticFunction(1.0, 0.0, 1.0);
		assertEquals(null, polynom.zeroCrossings());
	}
}
