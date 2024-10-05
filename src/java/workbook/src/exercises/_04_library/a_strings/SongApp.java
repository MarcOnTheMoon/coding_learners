package exercises._04_library.a_strings;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SongApp {

	public static void main(String[] args) {
		Song walkThisWorld = new Song("Heather", "Nova", "Walk this world");
		Song reckless = new Song("James", "Reyne", "Reckless");
				
		// Print objects' attributes to the console
		System.out.println("Playlist:");
		System.out.println(walkThisWorld);
		System.out.println(reckless);
	}
}
