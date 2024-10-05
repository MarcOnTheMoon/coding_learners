package labs.lab2.calendar;

import static org.junit.Assert.*;
import org.junit.Test;

/** Unit tests for classes Person, User, and Users.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestUsers {

	/** Test class Person.
	 */
	@Test
	public final void testPerson() {
		Person person = new Person("Marc", "Hensel");
		
		assertEquals("Marc", person.getFirstName());
		assertEquals("Hensel", person.getSurname());
		assertEquals("Marc Hensel", person.toString());
	}

	/** Test class User.
	 */
	@Test
	public final void testUser() {
		User user = new User("Marc", "Hensel");
		
		// Is superclass Person?
		assertEquals(Person.class, User.class.getSuperclass());
		
		// Has user a calendar of class Calendar?
        assertNotNull(user.getCalendar());
		assertEquals(Calendar.class, user.getCalendar().getClass());
		
		// User IDs
		User.setNextUserID(7);
		User same = new User("Marc", "Hensel");			// ID: 7
		User smaller = new User("Norbert", "Hansen");	// ID: 8
		User bigger = new User("Albert", "Henze");		// ID: 9
		
		assertEquals(7, same.getUserID());
		assertEquals(8, smaller.getUserID());
		assertEquals(9, bigger.getUserID());
		
		// Correct comparison?
		assertTrue(user.compareTo(same) == 0);
		assertTrue(user.compareTo(smaller) > 0);
		assertTrue(user.compareTo(bigger) < 0);
		
		assertTrue(same.compareTo(user) == 0);
		assertTrue(smaller.compareTo(user) < 0);
		assertTrue(bigger.compareTo(user) > 0);
	}

	/** Test class Users.
	 */
	@Test
	public final void testUsers() {
		Users users = new Users();

		// Test empty list
		assertEquals(User[].class, users.getUsers().getClass());
		assertEquals(0, users.getUsers().length);
		assertEquals("", users.toString());
		
		// Test list with one user
		users.createNewUser("Marc", "Hensel");
		assertEquals(1, users.getUsers().length);
		assertEquals("Marc Hensel\n", users.toString());
		
		// Test list with three users (sorted by surname)
		users.createNewUser("Albert", "Henze");
		users.createNewUser("Norbert", "Hansen");
		assertEquals(3, users.getUsers().length);
		assertEquals("Norbert Hansen\nMarc Hensel\nAlbert Henze\n", users.toString());
		
	}
}
