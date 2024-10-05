package exercises._03_classes.c_static;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MemberApp {
	public static void main(String[] args) {
		// Create first member and print to the console
		Member marc = new Member("Marc", "Hensel");
		System.out.printf("We have %d member(s):\n", Member.getNumberMembers());
		System.out.printf("%s, %s (Member %d)\n\n", marc.getSurname(), marc.getFirstName(), marc.getId());

		// Create second member and print to the console
		Member jana = new Member("Jana", "Musterfrau");
		System.out.printf("We have %d member(s):\n", Member.getNumberMembers());
		System.out.printf("%s, %s (Member %d)\n", marc.getSurname(), marc.getFirstName(), marc.getId());
		System.out.printf("%s, %s (Member %d)\n", jana.getSurname(), jana.getFirstName(), jana.getId());
	}
}
