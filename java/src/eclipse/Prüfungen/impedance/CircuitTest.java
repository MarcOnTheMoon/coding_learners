package impedance;

import static org.junit.Assert.*;
import org.junit.*;

/** Test suite for PVL Wintersemester 2011/12.
 * 
 * @author Marc Hensel
 * @version 2011-10-25
 */
public class CircuitTest {
	final private double DOUBLE_EPS = 0.00001;		// Precision in comparison of double numbers

	@Test
	public final void testResistor_getValueInOhm() {
		Resistor r = new Resistor(2.5);
		assertEquals(2.5, r.getValueInOhm(), DOUBLE_EPS);
	}

	@Test
	public final void testResistor_getImpedanceAtOmega() {
		Resistor r = new Resistor(2.5);
		double omega = 0.0;
		Complex expected = new Complex(2.5, 0.0);
		Complex actual = r.getImpedanceAtOmega(omega);		

		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Test for different omega: omega must not influence impedance.
		omega = 3.1;
		actual = r.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
	}

	@Test
	public final void testResistor_compareTo() {
		Resistor r1 = new Resistor(0.9);
		Resistor r2 = new Resistor(1.0);
		Resistor r3 = new Resistor(1.1);

		assertEquals(1, r2.compareTo(r1));
		assertEquals(0, r2.compareTo(r2));
		assertEquals(-1, r2.compareTo(r3));
	}

	@Test
	public final void testCapacitor_getValueInFarad() {
		Capacitor c = new Capacitor(2.5);
		assertEquals(2.5, c.getValueInFarad(), DOUBLE_EPS);
	}

	@Test
	public final void testCapacitor_getImpedanceAtOmega() {
		double omega = 1.0;
		double coulomb = 2.5;
		Capacitor c = new Capacitor(coulomb);
		Complex expected = new Complex(0.0, -1.0/(omega * coulomb));
		Complex actual = c.getImpedanceAtOmega(omega);		

		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Test for different omega
		omega = 3.1;
		expected = new Complex(0.0, -1.0/(omega * coulomb));
		actual = c.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
	}

	@Test
	public final void testInductor_getValueInHenry() {
		Inductor l = new Inductor(2.5);
		assertEquals(2.5, l.getValueInHenry(), DOUBLE_EPS);
	}

	@Test
	public final void testInductor_getImpedanceAtOmega() {
		double omega = 1.0;
		double henry = 2.5;
		Inductor l = new Inductor(henry);
		Complex expected = new Complex(0.0, omega * henry);
		Complex actual = l.getImpedanceAtOmega(omega);		

		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Test for different omega
		omega = 3.1;
		expected = new Complex(0.0, omega * henry);
		actual = l.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
	}

	@Test
	public final void testSeriesCircuit_addImpedance_getImpedances() {
		SeriesCircuit series = new SeriesCircuit();
		Impedance[] impedances;
		
		// Try to add "null" reference
		series.addImpedance(null);
		impedances = series.getImpedances();
		assertEquals(0, impedances.length);
		
		// Add first impedance
		Resistor r = new Resistor(1.0);
		series.addImpedance(r);
		impedances = series.getImpedances();
		assertEquals(1, impedances.length);
		assertEquals(r, impedances[0]);
		
		// Add second impedance
		Capacitor c = new Capacitor(2.0);
		series.addImpedance(c);
		impedances = series.getImpedances();
		assertEquals(2, impedances.length);
		assertEquals(r, impedances[0]);
		assertEquals(c, impedances[1]);
		
		// Allow adding impedances multiple times
		series.addImpedance(c);
		impedances = series.getImpedances();
		assertEquals(3, impedances.length);
	}

	@Test
	public final void testSeriesCircuit_getImpedanceAtOmega() {
		SeriesCircuit series = new SeriesCircuit();
		double omega = 1.0;
		
		// Add first real impedance
		Resistor r1 = new Resistor(2.0);
		series.addImpedance(r1);		
		Complex expected = new Complex(2.0, 0.0);
		Complex actual = series.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Add second real impedance
		Resistor r2 = new Resistor(3.0);
		series.addImpedance(r2);		
		expected = new Complex(5.0, 0.0);
		actual = series.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Add imaginary impedance
		Inductor l = new Inductor(2.5);
		series.addImpedance(l);
		expected = new Complex(5.0, 2.5);
		actual = series.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);

		omega = 3.5;
		expected = new Complex(5.0, omega * 2.5);
		actual = series.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
	}

	@Test
	public final void testParallelCircuit_addImpedance_getImpedances() {
		ParallelCircuit parallel = new ParallelCircuit();
		Impedance[] impedances;
		
		// Try to add "null" reference
		parallel.addImpedance(null);
		impedances = parallel.getImpedances();
		assertEquals(0, impedances.length);
		
		// Add first impedance
		Resistor r = new Resistor(1.0);
		parallel.addImpedance(r);
		impedances = parallel.getImpedances();
		assertEquals(1, impedances.length);
		assertEquals(r, impedances[0]);
		
		// Add second impedance
		Capacitor c = new Capacitor(2.0);
		parallel.addImpedance(c);
		impedances = parallel.getImpedances();
		assertEquals(2, impedances.length);
		assertEquals(r, impedances[0]);
		assertEquals(c, impedances[1]);
		
		// Allow adding impedances multiple times
		parallel.addImpedance(c);
		impedances = parallel.getImpedances();
		assertEquals(3, impedances.length);
	}

	@Test
	public final void testParallelCircuit_getImpedanceAtOmega() {
		ParallelCircuit parallel = new ParallelCircuit();
		double omega = 1.0;
		
		// Add first real impedance
		Resistor r1 = new Resistor(2.0);
		parallel.addImpedance(r1);		
		Complex expected = new Complex(2.0, 0.0);
		Complex actual = parallel.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Add second real impedance
		Resistor r2 = new Resistor(3.0);
		parallel.addImpedance(r2);		
		expected = new Complex(6.0/5.0, 0.0);	// Z = (R1 * R2) / (R1 + R2)
		actual = parallel.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
		
		// Add imaginary impedance
		Capacitor c = new Capacitor(2.5);
		parallel.addImpedance(c);
		Complex expectedInverse = new Complex((2.0+3.0)/(2.0*3.0), 2.5);
		expected = Complex.div(new Complex(1.0, 0.0), expectedInverse);
		actual = parallel.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);

		omega = 3.5;
		expectedInverse = new Complex((2.0+3.0)/(2.0*3.0), omega * 2.5);
		expected = Complex.div(new Complex(1.0, 0.0), expectedInverse);
		actual = parallel.getImpedanceAtOmega(omega);
		assertEquals(expected.getReal(), actual.getReal(), DOUBLE_EPS);
		assertEquals(expected.getImag(), actual.getImag(), DOUBLE_EPS);
	}

	@Test
	public final void testException_getMessage() {
		NegativeNumberException exception = new NegativeNumberException(-1.5);
		assertEquals("-1.5", exception.getMessage());
	}

	@Test
	public final void testException_thrownInConstructors() {
		// Test constructor of class Resistor
		boolean isThrown = false;
		try {
			@SuppressWarnings("unused")
			Resistor r = new Resistor(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}
		assertTrue(isThrown);

		// Test constructor of class Capacitor
		isThrown = false;
		try {
			@SuppressWarnings("unused")
			Capacitor c = new Capacitor(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}
		assertTrue(isThrown);

		// Test constructor of class Inductor
		isThrown = false;
		try {
			@SuppressWarnings("unused")
			Inductor l = new Inductor(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}		
		assertTrue(isThrown);
	}

	@Test
	public final void testException_thrownInGetImpedanceAtOmega() {
		// Test implementation in class Resistor
		boolean isThrown = false;
		Resistor r = new Resistor(1.0);
		try {
			r.getImpedanceAtOmega(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}
		assertTrue(isThrown);

		// Test implementation in class Capacitor
		isThrown = false;
		Capacitor c = new Capacitor(1.0);
		try {
			c.getImpedanceAtOmega(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}
		assertTrue(isThrown);

		// Test implementation in class Inductor
		isThrown = false;
		Inductor l = new Inductor(1.0);
		try {
			l.getImpedanceAtOmega(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}		
		assertTrue(isThrown);

		// Test implementation in class SeriesCircuit
		isThrown = false;
		SeriesCircuit series = new SeriesCircuit();
		try {
			series.getImpedanceAtOmega(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}		
		assertTrue(isThrown);

		// Test implementation in class ParallelCircuit
		isThrown = false;
		ParallelCircuit parallel = new ParallelCircuit();
		try {
			parallel.getImpedanceAtOmega(-0.1);
		} catch (NegativeNumberException e) {
			isThrown = true;
		}		
		assertTrue(isThrown);
	}
}
