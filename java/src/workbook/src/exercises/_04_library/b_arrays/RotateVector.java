package exercises._04_library.b_arrays;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class RotateVector {

	/** Rotate a 2D vector.
	 * 
	 * @param x Vector to be rotated
	 * @param angleInDegree Angle to rotate by [degree]
	 */
	static void rotateVector(double[] x, double angleInDegree) {
		double angleInRad = Math.PI / 180.0 * angleInDegree;
		double cosAlpha = Math.cos(angleInRad);
		double sinAlpha = Math.sin(angleInRad);
		double[] x0 = {x[0], x[1]};
		
		x[0] = x0[0] * cosAlpha - x0[1] * sinAlpha;
		x[1] = x0[0] * sinAlpha + x0[1] * cosAlpha;
	}

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		double[] x = { 2., 3. };
		double angleInDegree = 90.0;

		// Print input data to the console
		System.out.printf(Locale.US, "Input vector  : (%.1f %.1f)^T\n", x[0], x[1]);
		System.out.printf(Locale.US, "Rotate by     : %.1f degree\n", angleInDegree);
		
		// Rotate vector and print to the console
		rotateVector(x, angleInDegree);
		System.out.printf(Locale.US, "Rotated vector: (%.1f %.1f)^T\n", x[0], x[1]);
	}

}
