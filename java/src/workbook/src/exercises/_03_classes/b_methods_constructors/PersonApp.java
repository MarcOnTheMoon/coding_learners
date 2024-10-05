package exercises._03_classes.b_methods_constructors;

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
		Person hensel = new Person("Marc", "Hensel");
		Person dido = new Person("Dido", "Armstrong");
		
		// Print objects' attributes to the console
		System.out.println("There are objects for these two people:");
		System.out.printf("%s %s\n", hensel.getFirstName(), hensel.getSurname());
		System.out.printf("%s\n", dido.getFullName());
	}
}
