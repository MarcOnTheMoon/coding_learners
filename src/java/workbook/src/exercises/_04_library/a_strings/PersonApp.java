package exercises._04_library.a_strings;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PersonApp {
	
	public static void main(String[] args) {
		Person person = new Person("Marc", "Hensel");
		
		System.out.println(person);
		System.out.println(person.toString());
//		System.out.println(person + 1);				// Compiler error
		System.out.println(person.toString() + 1);
	}
}
