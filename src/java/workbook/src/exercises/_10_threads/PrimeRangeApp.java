package exercises._10_threads;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PrimeRangeApp {
	private static final long MAX_NUMBER = 250;

	public static void main(String[] args) {
		PrimeNumbers primeNumbers = new PrimeNumbers(MAX_NUMBER);

		// Print prime numbers up to MAX_NUMBER to the console
		for (int i = 0; i < primeNumbers.getPrimes().size(); i++) {
			System.out.printf("%4d ", primeNumbers.getPrimes().get(i));
			if ((i % 15) == 14)
				System.out.println();
		}
		System.out.println();
	}
}
