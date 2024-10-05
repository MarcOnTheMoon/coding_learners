package exercises._06_abstract.a_zero_crossing;

/** Class to determine zero-crossings of mathematical functions.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ZeroCrossing {

	/** Determine a zero-crossing applying the bisection method.
	 * 
	 * @param function Mathematical function to analyze
	 * @param xl Left (lower) border of the start interval [xl, xr]
	 * @param xr Right (upper) border of the start interval [xl, xr]
	 * @param delta Bisection stops at interval size < delta 
	 * @return center value x0 = (xl + xr)/2 of the final interval (or null)
	 */
	public static Double bisection(Function function, double xl, double xr, double delta) {
		double[] interval = {xl, xr};
 
		// Assert a mathematical function has been assigned
		if (function == null)
			return null;
		
		// Initial function values
		double fl = function.f(xl);
		double fr = function.f(xr);
		
		// Check that zero-crossing exists in interval
		if (fl * fr > 0)
			return null;

		// Bisect interval
		while (xr - xl > delta) {
			// Adapt interval
			double xm = 0.5 * (xl + xr);
			double fm = function.f(xm);

			if (fm * fl > 0) {
				xl = xm;
				fl = fm;
			} else {
				xr = xm;
				fr = fm;
			}
			interval[0] = xl;
			interval[1] = xr;
		}
		
		return 0.5 * (xl + xr);
	}
	
	/** Determine a zero-crossing using Newton's method.
	 * 
	 * @param function Mathematical function to analyze
	 * @param x0 Start value
	 * @param delta Method stops at Delta x <= delta 
	 * @param maxIterations Maximum number of iteration steps
	 * @return approximated zero-crossing x0 (or empty list)
	 */
	public static Double newton(Function function, double x0, double delta, int maxIterations) {
		double x1, x2;

		// Do iterations
		x2 = x0;
		do
		{
			x1 = x2;
			x2 = x1 - function.f(x1) / function.f1(x1);
		} while ((Math.abs(x2 - x1) > delta) && (--maxIterations > 0));
		
		// Method successful?
		return (Math.abs(x2 - x1) < delta) ? x2 : null;
	}
}
