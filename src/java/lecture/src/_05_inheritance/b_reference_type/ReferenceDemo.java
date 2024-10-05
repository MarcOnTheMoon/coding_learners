package _05_inheritance.b_reference_type;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ReferenceDemo {	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Pilot pilot = new Pilot("Birgit Janssen", "Winglet Airways");
		Person personRef = pilot;
		Object objectRef = pilot;
		
		System.out.println(personRef.name);
//		System.out.println(personRef.airline);
	}
}
