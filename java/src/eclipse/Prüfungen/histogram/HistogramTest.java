package histogram;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Simple unit tests for class Histogram.<p>
 * Notes:<br>
 * - The tests do NOT fully test the given requirements.<br>
 * - The constructor is tested implicitly, only.
 * @author Marc Hensel
 * @version 2010-12-27
 */
public class HistogramTest {
	final private double DOUBLE_EPS = 0.00001;		// Precision in comparison of double numbers

	@Test
	public final void testHistogramGetValueAt() {
		int maxIndex = 256;
		int[] samples = new int[] {0, 1, 1, 2, 3, 3, 3, 3, 254, 255, 255}; 
		Histogram histogram = new Histogram(maxIndex, samples);
		assertEquals(1, histogram.getValueAt(0));
		assertEquals(2, histogram.getValueAt(1));
		assertEquals(1, histogram.getValueAt(2));
		assertEquals(4, histogram.getValueAt(3));
		assertEquals(1, histogram.getValueAt(254));
		assertEquals(2, histogram.getValueAt(255));
	}

	@Test
	public final void testHistogramGetMaxIndex() {
		int maxIndex = 10;
		Histogram histogram = new Histogram(maxIndex, new int[20]);
		assertEquals(maxIndex, histogram.getMaxIndex());
	}

	@Test
	public final void testHistogramGetMaxValue() {
		/* Note: The maximum histogram value is 4, because there is 4x the value "3"
		 * in the input data "testData".
		 */
		int maxIndex = 256;
		int[] samples = new int[] {0, 1, 1, 2, 3, 3, 3, 3, 254, 255, 255}; 
		Histogram histogram = new Histogram(maxIndex, samples);
		assertEquals(4, histogram.getMaxValue());
	}

	@Test
	public final void testHistogramClearValueAt() {
		int maxIndex = 256;
		int[] samples = new int[] {0, 1, 1, 2, 3, 3, 3, 3, 254, 255, 255}; 
		Histogram histogram = new Histogram(maxIndex, samples);
		
		// Before
		assertEquals(1, histogram.getValueAt(0));
		assertEquals(2, histogram.getValueAt(1));
		assertEquals(1, histogram.getValueAt(2));
		
		histogram.clearValueAt(1);
				
		// After
		assertEquals(1, histogram.getValueAt(0));
		assertEquals(0, histogram.getValueAt(1));
		assertEquals(1, histogram.getValueAt(2));
	}

	@Test
	public final void testHistogramGetNumbertOfSamples() {
		int maxIndex = 10;
		int numberSamples = 101;
		Histogram histogram = new Histogram(maxIndex, new int[numberSamples]);
		assertEquals(numberSamples, histogram.getNumberOfSamples());
	}

	@Test
	public final void testHistogramMean() {
		int maxIndex = 256;
		int[] samples = new int[]{1, 2, 2, 3, 3, 4};
		Histogram histogram = new Histogram(maxIndex, samples);
		assertEquals(2.5, histogram.mean(), DOUBLE_EPS);
	}

	@Test
	public final void testHistogramStandardDeviation() {
		int maxIndex = 256;
		int[] samples = new int[]{1, 3};
		Histogram histogram = new Histogram(maxIndex, samples);
		assertEquals(Math.sqrt(2.0), histogram.standardDeviation(), DOUBLE_EPS);
	}
}
