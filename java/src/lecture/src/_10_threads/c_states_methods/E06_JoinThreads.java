package _10_threads.c_states_methods;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E06_JoinThreads {

	public static void main(String[] args) throws InterruptedException {
		SleepyThread sleepy = new SleepyThread();
		sleepy.start();
		
		while (sleepy.isAlive()) {
			System.out.println("Wake up!");
			Thread.sleep(400);
			sleepy.join();
		}	
		System.out.println("At last ...");
	}
}

class SleepyThread extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println("I'm sooo tired ...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Okay, I'm awake again.");
	}
}
