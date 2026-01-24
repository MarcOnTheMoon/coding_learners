package nearestNeighbor;

/** Interface for class to represent n-dimensional vectors.
 * 
 * @author Marc Hensel
 * @version 1.0
 */
public interface IMathVector {

	public int getSize();
	public double getElement(int index);
	public double getAbs();

	public void add(MathVector other) throws VectorSizeMismatchException;	
	public MathVector multiply(double factor);

	public MathVector clone();	
	public String toString();
	public int compareTo(MathVector other);
}
