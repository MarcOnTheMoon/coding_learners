package exercises._10_threads;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PrimeNumbers {
	private final ArrayList<Long> primes = new ArrayList<Long>();

	/** Instantiate object with all prime numbers in [2, N].
	 * 
	 * @param maxNumber Maximum number N to consider
	 */
	public PrimeNumbers(long maxNumber) {
		for (long number = 1; number <= maxNumber; number++) {
			if (PrimeNumbers.isPrime(number)) {
				primes.add(number);
			}
		}
	}

	/** Instantiate object with all prime numbers in [2, N].
	 * 
	 * @param maxNumber Maximum number N to consider
	 * @param numberThreads Number of parallel threads to use in determination of prime numbers
	 */
	public PrimeNumbers(long maxNumber, int numberThreads) {
		PrimeNumberThread[] threads = new PrimeNumberThread[numberThreads];
		long intervalSize = maxNumber / numberThreads;
		long start = 0;
		
		// Create and start threads
		for (int i = 0; i < numberThreads - 1; i++) {
			threads[i] = new PrimeNumberThread(start, start + intervalSize - 1);
			threads[i].start();
			start += intervalSize;
		}
		threads[numberThreads - 1] = new PrimeNumberThread(start, maxNumber);
		threads[numberThreads - 1].start();
		
		// Wait for threads to complete and append results to list
		for (int i = 0; i < numberThreads; i++) {
			try {
				threads[i].join();
				primes.addAll(threads[i].getPrimes());
			} catch (InterruptedException e) {
				System.out.println("INFO Thread interrupted");
			}
		}
	}

	/** Get all prime numbers in [2, N].
	 * <p>
	 * The upper bound N is set using a constructor.
	 * 
	 * @return all prime numbers in [2, N]
	 */
	public ArrayList<Long> getPrimes() {
		return primes;
	}

	/** Check whether a number is prime.
	 * 
	 * @param number Number to check
	 * @return true, if number is prime
	 */
	static boolean isPrime(long number) {
		// Number too small (i.e. <= 1) => No prime number
		if (number <= 1)
			return false;
		
		// Even number (except for 2) => No prime number
		if ((number % 2) == 0)
			return (number == 2);

		// Odd numbers: Found odd divisor => No prime number
		for (long index = 3; index < number/2; index += 2) {
			if( (number % index) == 0) {
				return false;
			}
		}
		return true;		
	}	
}

/** Thread to find prime numbers in a specific range [min, max].<br><br>
 */
class PrimeNumberThread extends Thread {
	private final ArrayList<Long> primes = new ArrayList<Long>();
	private final long min, max;
	
	PrimeNumberThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	public ArrayList<Long> getPrimes() {
		return primes;
	}

	@Override
	public void run() {
		for (long number = min; number <= max; number++) {
			if (PrimeNumbers.isPrime(number)) {
				primes.add(number);
			}
		}
	}
}