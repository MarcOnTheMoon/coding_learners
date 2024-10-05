package _10_threads.d_race_conditions;

/** Demonstrates race condition using a counter.
 * <p>
 * "Normally" the counter should not change over time, because the
 * applied operation is counter = (counter + 1) - 1. This does not
 * hold for multiple threads using the non-synchronized method, however.<p>
 * <br><br>
 * Use the "setup section" below for experiments.
 * <br><br>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
class E08_RaceConditions {
	
	/* **************************************************
	 * ***
	 * ***               Setup section
	 * ***               -------------
	 * ***/	
	private static final int numberThreads = 6;
	private static final boolean isSynchronized = false;
	/* ***
	 * ***
	 * **************************************************/
	
	public static void main(String[] args) {
		Counter counter = new Counter();
		
		// Create and start "numberThreads" counter threads
		for (int i = 0; i < numberThreads; i++) {
			CounterThread thread = new CounterThread(counter, isSynchronized);
			thread.start();
		}
	}
}

/**
 * Implements counter with operation counter = (counter + 1) - 1.
 * Operation is available as synchronized and as non-synchronized method.
 */
class Counter {
	int counter = 0;
	
	// Non-synchronized method
	void increaseAndDecrease() {
		counter++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter--;
	}

	// Synchronized method
	synchronized void syncIncreaseAndDecrease() {
		counter++;
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		counter--;
	}
}

/**
 * Uses class Counter in endless loop.
 * Uses synchronized or non-synchronized methods of class Counter.
 */
class CounterThread extends Thread {
	private final Counter counter;
	private final boolean isSynchronized;
	
	public CounterThread(Counter counter, boolean isSynchronized) {
		this.counter = counter;
		this.isSynchronized = isSynchronized;
	}
	
	// This method is executed when the thread is started
	public void run() {
		while(true) {
			if (isSynchronized) {
				counter.syncIncreaseAndDecrease();
			} else {
				counter.increaseAndDecrease();
			}
			System.out.printf("Counter = %d\n", counter.counter);
		}
	}
}