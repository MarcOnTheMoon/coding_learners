package exercises._04_library.c_lists;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PersonQueueApp {

	public static void main(String[] args) {
		Person warteschon = new Person("Horst-Gudrun", "Warteschon");
		Person hensel = new Person("Marc", "Hensel");
		Person hintermann = new Person("Janick-Nick", "Hintermann");
		PersonQueue people = new PersonQueue();

		// People enter queue
		people.enter(warteschon);
		System.out.println(people);
		people.enter(hensel);
		System.out.println(people);
		people.enter(hintermann);
		System.out.println(people);
		
		// People leave queue
		System.out.println("Leave -> " + people.leave());
		System.out.println("Leave -> " + people.leave());
		System.out.println(people);
		System.out.println("Leave -> " + people.leave());
		System.out.println("Leave -> " + people.leave());
	}
}
