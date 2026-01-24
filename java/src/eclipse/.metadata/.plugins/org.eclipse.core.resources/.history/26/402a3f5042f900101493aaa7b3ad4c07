package exercises._03_classes.c_static;

/** Class representing a member.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Member {
	Person person;
	int id;
	static int lastId = 0;

	/** Instantiate object.
	 * <p>
	 * The next member is automatically assigned a membership identifier. 
	 * 
	 * @param firstName First name
	 * @param surname Surname
	 */
	Member(String firstName, String surname) {
		person = new Person(firstName, surname);
		id = ++lastId;
	}
	
	/** Get the first name.
	 * 
	 * @return the first name
	 */
	String getFirstName() {
		return person.getFirstName();
	}
	
	/** Get the surname.
	 * 
	 * @return the surname
	 */
	String getSurname() {
		return person.getSurname();
	}

	/** Get the membership identifier.
	 * 
	 * @return the id
	 */
	int getId() {
		return id;
	}
	
	/** Get the overall number of members.
	 * 
	 * @return number of members
	 */
	static int getNumberMembers() {
		return lastId;
	}
}
