package exercises._10_threads;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PrimeThreadApp {
	private static final boolean isPrintNumbers = false;
	private static final long maxNumber = 250000;
	private static final int numberThreads = 8;

	public static void main(String[] args) {
		long startTimeNano, stopTimeNano;

		// Find prime numbers
		System.out.printf(Locale.US,
				"Find prime numbers up to N = %,d using %d thread(s).\n",
				maxNumber, numberThreads);

		startTimeNano = System.nanoTime();
		PrimeNumbers primeNumbers = new PrimeNumbers(maxNumber, numberThreads);
		stopTimeNano = System.nanoTime();
		
		// Print result to the console
		if (isPrintNumbers) {
			for (int i = 2; i < primeNumbers.getPrimes().size(); i++) {
				System.out.printf("%4d ", primeNumbers.getPrimes().get(i));
				if ((i % 15) == 14)
					System.out.println();
			}
			System.out.println();
		}
		System.out.printf(Locale.US, "Time taken: %.3f s", (stopTimeNano - startTimeNano) / 1.e9);
	}
}
