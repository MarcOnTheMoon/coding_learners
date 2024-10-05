package exercises._04_library.c_lists;

/** Class representing a mathematical parabola f(x) = a2 * x^2 + a1 * x + a0.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Parabola {
	double a2, a1, a0;
	
	/** Instantiate function f(x) = a2 * x^2 + a1 * x + a0.
	 * 
	 * @param a2 Coefficient a2
	 * @param a1 Coefficient a1
	 * @param a0 Coefficient a0
	 */
	Parabola(double a2, double a1, double a0) {
		super();
		this.a2 = a2;
		this.a1 = a1;
		this.a0 = a0;
	}

	/** Evaluate function f(x) for specific x.
	 * 
	 * @param x Value x to get f(x) for
	 * @return function value f(x)
	 */
	double f(double x) {
		return (a2 * x + a1) * x + a0;
	}
	
	/** Evaluate first derivative f'(x) for specific x.
	 * 
	 * @param x Value x to get f'(x) for
	 * @return first derivative f'(x)
	 */
	double f1(double x) {
		return 2.0 * a2 * x + a1;
	}

	/** Print parabola's formula to the console.
	 */
	void print() {
		System.out.printf("f(x) = %+.0f * x^2 %+.0f * x %+.0f", a2, a1, a0);
	}
}
