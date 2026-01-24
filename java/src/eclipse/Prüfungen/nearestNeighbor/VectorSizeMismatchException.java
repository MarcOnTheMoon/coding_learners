package nearestNeighbor;

/** Exception indicating vector size mismatch.
 * 
 * The exception shall be thrown when a vector operation,
 * which requires vectors of equal dimension, is applied
 * to vectors with a different number of elements.
 * 
 * @author Marc Hensel
 * @version 1.0
 */
public class VectorSizeMismatchException extends RuntimeException {
	private static final long serialVersionUID = 20100610L;
}
