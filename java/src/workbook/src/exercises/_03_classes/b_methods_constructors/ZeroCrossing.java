package exercises._03_classes.b_methods_constructors;

/** Class to determine zero-crossings of mathematical parabolas.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ZeroCrossing {
	double x0 = 0.0;
	Parabola function;
	
	/** Instantiate object.
	 * 
	 * @param function Mathematical function to analyze
	 */
	public ZeroCrossing(Parabola function) {
		super();
		this.function = function;
	}

	/** Get zero-crossing.
	 * <p>
	 * Note that a zero-crossing must be determined by calling an
	 * appropriate method, first.
	 * 
	 * @return the x-value of the zero-crossing 
	 */
	double getX0() {
		return x0;
	}

	/** Set the mathematical function (parabola).
	 * 
	 * @param function Mathematical function to analyze
	 */
	public void setFunction(Parabola function) {
		if (function != null)
			this.function = function;
	}

	/** Determine a zero-crossing applying the bisection method.
	 * 
	 * @param xl Left (lower) border of the start interval [xl, xr]
	 * @param xr Right (upper) border of the start interval [xl, xr]
	 * @param delta Bisection stops at interval size < delta 
	 * @return true if bisection method succeeded, else false
	 */
	boolean bisection(double xl, double xr, double delta) {
		// Assert a mathematical function has been assigned
		if (function == null)
			return false;
		
		// Initial function values
		double fl = function.f(xl);
		double fr = function.f(xr);
		
		// Check that zero-crossing exists in interval
		if (fl * fr > 0)
			return false;

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
		}
		
		// Store approximated zero crossing and return
		x0 = 0.5 * (xl + xr);
		return true;
	}
	
	/** Determine a zero-crossing using Newton's method.
	 * 
	 * @param x0 Start value
	 * @param delta Method stops at Delta x <= delta 
	 * @param maxIterations Maximum number of iteration steps
	 * @return true, if the method was successful within maximum number of iterations
	 */
	boolean newton(double x0, double delta, int maxIterations) {
		double x, x1;

		// Do iterations
		x1 = x0;
		do
		{
			x = x1;
			x1 = x - function.f(x) / function.f1(x);
		} while ((Math.abs(x1 - x) > delta) && (--maxIterations > 0));
		
		// Method successful
		if (Math.abs(x1 - x) < delta) {
			this.x0 = x1;
			return true;
		}
		
		return false;
	}
}
