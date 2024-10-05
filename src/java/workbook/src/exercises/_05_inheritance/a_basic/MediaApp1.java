package exercises._05_inheritance.a_basic;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MediaApp1 {

	public static void main(String[] args) {
		MediaLib mediaLib = new MediaLib();
	
		// Add contents to collection
		mediaLib.add(new Video("Was ist mit Bob?"));
		mediaLib.add(new Video("Der Marsianer"));
		mediaLib.add(new Audio("Rusk & Bread", "Marie"));
		mediaLib.add(new Audio("Sheryl Crow", "Hard to make a stand"));
		
		// Print titles to the console
		mediaLib.print();
	}
}
