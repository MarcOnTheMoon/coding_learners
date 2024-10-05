package exercises._06_abstract.a_zero_crossing;

/** Class representing a mathematical logarithm f(x) = log_b(x) with base b.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Logarithm extends Function {
	private final int base;
	
	public Logarithm(int base) {
		super();
		this.base = base;
	}

	@Override
	public double f(double x) {
		return Math.log(x) / Math.log(base);
	}

	@Override
	public double f1(double x) {
		return 1.0 / (Math.log(base) * x);
	}
	
	@Override
	public String toString() {
		return String.format("f(x) = log%d(x)", base);
	}
}
