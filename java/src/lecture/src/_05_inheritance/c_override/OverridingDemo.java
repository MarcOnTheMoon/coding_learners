package _05_inheritance.c_override;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class OverridingDemo {
	public static void main(String[] args) {
		Person person = new Person("Birgit Janssen");		
		System.out.println("person: " + person);
		System.out.println("person.toString(): " + person.toString());
		
		Pilot pilot = new Pilot("Jan Birgerson", "Winglet Airways");
		System.out.println("pilot.toString(): " + pilot.toString());
		System.out.println();
		
		Object objectRef = pilot;
		Person personRef = pilot;
		System.out.println("objectRef.toString(): " + objectRef.toString());		
		System.out.println("personRef.toString(): " + personRef.toString());		
		System.out.println();
		
		System.out.println("Pilot.toString(): " + pilot.toString());
		System.out.println("super.toString(): " + pilot.toStringOfSuperClass());		
	}
}

