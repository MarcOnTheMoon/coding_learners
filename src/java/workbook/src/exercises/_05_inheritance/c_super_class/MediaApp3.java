package exercises._05_inheritance.c_super_class;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MediaApp3 {

	public static void main(String[] args) {
		MediaLib mediaLib = new MediaLib();
	
		// Add contents to collection
		mediaLib.add(new Video("Was ist mit Bob?", new ImageSize(720, 576), new Duration(60 + 39, 0)));
		mediaLib.add(new Video("Der Marsianer", new ImageSize(1920, 1080), new Duration(2 * 60 + 31, 0)));
		mediaLib.add(new Audio("Rusk & Bread", "Marie", new Duration(4, 15)));
		mediaLib.add(new Audio("Sheryl Crow", "Hard to make a stand", new Duration("3:08")));
		
		// Print titles to the console
		mediaLib.print();
		
		// Print overall duration to the console
		System.out.printf("\nThe media collection contains fun for %s hours.\n", mediaLib.getDurationString());
	}
}
