package _03_classes.b_methods;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathUtilsDemo {

	public static void main(String[] args) {
		MathUtils math = new MathUtils();
		
		// Average value of two numbers
		System.out.println("Average:");
		double a1 = 3.5, a2 = 7;
		double mean = math.average(a1, a2);
		System.out.println(mean);
		System.out.println(math.average(1.5, 3.2));

		// Sum of digits in integer number (Quersumme)
		System.out.println("\nSum of digits:");
        System.out.println(math.sumOfDigits(0));
        System.out.println(math.sumOfDigits(2016));
	}
}
