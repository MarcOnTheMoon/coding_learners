package nearest_neighbor;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class SimpleUnitTests {

	@Test
	public void testVectorGetSize() {
		MathVector v = new MathVector(2);
		assertEquals(2, v.getSize());
	}

	@Test
	public void testVectorGetElement() {
		MathVector v = new MathVector(new double[]{1,2});
		assertEquals((int)1, (int)v.getElement(0));
		assertEquals((int)2, (int)v.getElement(1));
	}

	@Test
	public void testVectorGetAbs() {
		MathVector v = new MathVector(new double[]{3,4});
		assertEquals((int)5, (int)v.getAbs());
	}

	@Test
	public void testVectorAdd() {
		MathVector v1 = new MathVector(new double[]{1,2});
		MathVector v2 = new MathVector(new double[]{3,4});
		v1.add(v2);
		assertEquals((int)4, (int)v1.getElement(0));
		assertEquals((int)6, (int)v1.getElement(1));
	}

	@Test
	public void testVectorSubtract() {
		MathVector v1 = new MathVector(new double[]{1,2});
		MathVector v2 = new MathVector(new double[]{4,3});
		MathVector v = MathVector.subtract(v1,v2);
		assertEquals((int)-3, (int)v.getElement(0));
		assertEquals((int)-1, (int)v.getElement(1));
	}

	@Test
	public void testVectorMultiply() {
		MathVector v = new MathVector(new double[]{1,2});
		v.multiply(-2.0);
		assertEquals((int)-2, (int)v.getElement(0));
		assertEquals((int)-4, (int)v.getElement(1));
	}

	@Test
	public void testVectorToString() {
		MathVector v = new MathVector(new double[]{1.201, 2.3, 3.4, 4});
		String expected = "[1.201, 2.3, 3.4, 4.0]";
		String actual = v.toString();	
		assertEquals(expected, actual);
	}

	@Test
	public void testVectorCompareTo() {
		MathVector vRef = new MathVector(new double[]{2});
		MathVector vLt = new MathVector(new double[]{1.999});
		MathVector vEq = new MathVector(new double[]{-2});
		MathVector vGt = new MathVector(new double[]{2.001});
		assertTrue(vRef.compareTo(vLt) > 0);
		assertEquals(0, vRef.compareTo(vEq));
		assertTrue(vRef.compareTo(vGt) < 0);
	}

	@Test
	public void testNeighborSetMeanVectors() {
		MathVector v1 = new MathVector(new double[]{1,2});
		MathVector v2 = new MathVector(new double[]{3,4});
		NearestNeighbor nn = new NearestNeighbor(2);
		
		nn.setMeanVectors(v1, v2);
		MathVector v1NN = nn.getMeanA();
		MathVector v2NN = nn.getMeanB();
		assertEquals((int)v1.getElement(0), (int)v1NN.getElement(0));
		assertEquals((int)v1.getElement(1), (int)v1NN.getElement(1));
		assertEquals((int)v2.getElement(0), (int)v2NN.getElement(0));
		assertEquals((int)v2.getElement(1), (int)v2NN.getElement(1));
	}

	@Test
	public void testNeighborAddToListNew() {
		MathVector v = new MathVector(new double[]{1,2});
		NearestNeighbor nn = new NearestNeighbor(2);		
		nn.addToListNew(v);
		ArrayList<MathVector> list = nn.getListNew();
		MathVector vNN = list.get(0);
		assertEquals((int)v.getElement(0), (int)vNN.getElement(0));
		assertEquals((int)v.getElement(1), (int)vNN.getElement(1));
	}

	@Test
	public void testNeighborUpdateMeanVectors() {
		NearestNeighbor nn = new NearestNeighbor(2);
		nn.setMeanVectors(new MathVector(new double[]{1,0}), new MathVector(new double[]{2,0}));
		nn.addToListNew(new MathVector(new double[]{0,0}));
		nn.addToListNew(new MathVector(new double[]{3,0}));
		nn.updateMeanVectors();
		
		// Check new mean vectors
		MathVector meanA = nn.getMeanA();
		MathVector meanB = nn.getMeanB();
		assertEquals((int)0, (int)meanA.getElement(0));
		assertEquals((int)0, (int)meanA.getElement(1));
		assertEquals((int)3, (int)meanB.getElement(0));
		assertEquals((int)0, (int)meanB.getElement(1));
		
		// Check list sizes
		assertEquals(1, nn.getListA().size());
		assertEquals(1, nn.getListB().size());
		assertEquals(0, nn.getListNew().size());
	}
}
