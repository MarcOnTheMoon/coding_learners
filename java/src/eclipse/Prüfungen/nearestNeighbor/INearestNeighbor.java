package nearestNeighbor;

import java.util.ArrayList;

/** Interface for class to determine nearest neighbors for two types.
 * 
 * @author Marc Hensel
 * @version 1.0
 */
public interface INearestNeighbor {

	public void setMeanVectors(MathVector meanA, MathVector meanB);
	
	public MathVector getMeanA();
	public MathVector getMeanB();
	public ArrayList<MathVector> getListA();
	public ArrayList<MathVector> getListB();
	public ArrayList<MathVector> getListNew();

	public void addToListNew(MathVector mathVector);
	
	public void updateMeanVectors();
}
