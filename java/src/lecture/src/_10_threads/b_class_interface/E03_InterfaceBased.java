package _10_threads.b_class_interface;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
class PrintRunnable implements Runnable {
	@Override
	public void run() {
		System.out.println("Hurra, ich laufe parallel!");
	}
}

public class E03_InterfaceBased {	
	
	public static void main(String[] args) {
		PrintRunnable runnable = new PrintRunnable();
		Thread thread = new Thread(runnable);
		
		System.out.println("Objekte erzeugt");
		thread.start();
		System.out.println("Thread gestartet");
	}
}
