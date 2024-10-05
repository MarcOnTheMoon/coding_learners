package _10_threads.b_class_interface;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E01_RunThread1 {
	
	public static void main(String[] args) {
		Thread thread = new Thread();
		System.out.println("Objekt erzeugt");
		
		thread.start();
		System.out.println("Thread gestartet");
	}
}
