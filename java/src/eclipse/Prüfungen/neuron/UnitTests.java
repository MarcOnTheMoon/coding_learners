package neuron;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Test;

/** Unit tests provided for the final exam E3-OP.
 *  
 * @version SoSe 2022
 * @author Marc Hensel (http://www.haw-hamburg.de/marc-hensel)
 */
public class UnitTests {
	private static double precissionDouble = 0.000001;		// Precision in comparison of double numbers
	
	@Test
	public final void test_1_Functions() {
		// Identity
		Identity identity = new Identity();
		assertEquals(-0.26, identity.f(-0.26), precissionDouble);
		assertEquals(1.5, identity.f(1.5), precissionDouble);

		// ReLU
		ReLU relu = new ReLU();
		assertEquals(0.0, relu.f(-0.26), precissionDouble);
		assertEquals(1.5, relu.f(1.5), precissionDouble);

		// Sigmoid
		Sigmoid sigmoid = new Sigmoid();
		assertEquals(0.5, sigmoid.f(0.0), precissionDouble);
	}

	@Test
	public final void test_2_Constructor1_Getters() throws Exception {
		double[] weights = {0.0, 0.5, 1.0};
		double bias = 0.75;
		Neuron neuron = new Neuron(weights, bias, new Identity());
		
		assertEquals(weights.length, neuron.getNumberOfWeights(), precissionDouble);
		assertEquals(weights[0], neuron.getWeight(0), precissionDouble);
		assertEquals(weights[1], neuron.getWeight(1), precissionDouble);
		assertEquals(weights[2], neuron.getWeight(2), precissionDouble);
		assertEquals(bias, neuron.getBias(), precissionDouble);
	}

	@Test
	public final void test_3_Constructor2_Getters() throws Exception {
		int numberOfWeights = 4;
		Neuron neuron = new Neuron(numberOfWeights, new Identity());
		
		assertEquals(numberOfWeights, neuron.getNumberOfWeights(), precissionDouble);
		assertTrue((neuron.getBias() >= 0.0) && (neuron.getBias() <= 1.0));
	}
	
	@Test
	public final void test_4_Weights() throws Exception {
		Neuron neuron = new Neuron(new double[] {0.0, 0.0, 0.0}, 0.75, new Identity());

		neuron.setWeight(0, 0.1);
		neuron.setWeight(1, 0.2);
		neuron.setWeight(2, 0.3);

		assertEquals(0.1, neuron.getWeight(0), precissionDouble);
		assertEquals(0.2, neuron.getWeight(1), precissionDouble);
		assertEquals(0.3, neuron.getWeight(2), precissionDouble);
	}
	
	@Test
	public final void test_5_Bias() throws Exception {
		Neuron neuron = new Neuron(new double[] {0.0}, 0.75, new Identity());

		neuron.setBias(0.22);
		assertEquals(0.22, neuron.getBias(), precissionDouble);
	}

	@Test
	public final void test_6_Calculations() throws Exception {
		double[] x = {2.0, 3.0};
		Sigmoid function = new Sigmoid();
		Neuron neuron = new Neuron(new double[] {1.0, 2.0}, -0.3, function);
		
		assertEquals(7.7, neuron.calcZ(x), precissionDouble);
		assertEquals(function.f(7.7), neuron.calcOutput(x), precissionDouble);
	}

	@Test
	public final void test_7_Exception() throws Exception {
		Neuron neuron = new Neuron(new double[] {1.0, 2.0}, 0.5, new Identity());

		try {
			neuron.calcZ(new double[] {0.75});
		} catch (LengthMismatchException e) {
			return;
		}
		fail();
	}
}
