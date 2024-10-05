package labs.lab2.calendar;

import static org.junit.Assert.*;
import org.junit.Test;

/** Unit tests for classes DateTime, CalendarItem, and Calendar.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.31<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TestCalendar {

	/** Test class DateTime.
	 */
	@Test
	public final void testDateTime() {
		DateTime dateTime = new DateTime(71, 4, 7, 1, 9);

		// Getters and toString()
		assertEquals(71, dateTime.getYear());
		assertEquals(4, dateTime.getMonth());
		assertEquals(7, dateTime.getDay());
		assertEquals(1, dateTime.getHour());
		assertEquals(9, dateTime.getMinute());
		assertEquals("07.04.0071 01:09", dateTime.toString());

		// Correct comparison?		
		DateTime same = new DateTime(71, 4, 7, 1, 9);
		DateTime smaller = new DateTime(71, 4, 7, 1, 2);
		DateTime bigger = new DateTime(71, 4, 7, 1, 10);

        assertEquals(0, dateTime.compareTo(same));
		assertTrue(dateTime.compareTo(smaller) > 0);
		assertTrue(dateTime.compareTo(bigger) < 0);

        assertEquals(0, same.compareTo(dateTime));
		assertTrue(smaller.compareTo(dateTime) < 0);
		assertTrue(bigger.compareTo(dateTime) > 0);
	}

	/** Test class CalendarItem.
	 */
	@Test
	public final void testCalendarItem() {
		User user = new User("Marc", "Hensel");
		DateTime dateTime = new DateTime(2013, 3, 5, 7, 49);
		CalendarItem item = new CalendarItem("Betreff", user, dateTime, 90);
		
		// Getter
		assertEquals("Betreff", item.getSubject());
		assertEquals(user, item.getOwner());
		assertEquals(User[].class, item.getParticipants().getClass());
		assertEquals(0, item.getParticipants().length);
		assertEquals(dateTime, item.getDateTime());
		assertEquals(90, item.getDurationInMinutes());

		// Add participants (no duplicates in list)
		User user2 = new User("Albert", "Heinze");
		User user3 = new User("Norbert", "Hinze");

		item.addParticipant(user2);
		assertEquals(1, item.getParticipants().length);
		assertEquals(user2, item.getParticipants()[0]);

		item.addParticipant(user3);
		assertEquals(2, item.getParticipants().length);
		assertEquals(user2, item.getParticipants()[0]);
		assertEquals(user3, item.getParticipants()[1]);

		item.addParticipant(user2);		// Duplicates
		item.addParticipant(user3);
		assertEquals(2, item.getParticipants().length);

		// Remove participant
		item.removeParticipant(user2);
		assertEquals(1, item.getParticipants().length);
		assertEquals(user3, item.getParticipants()[0]);
		
		// toString()
		String expected = "";

		expected += "05.03.2013 07:49 (90 min):\n";
		expected += "Subject:\tBetreff\n";
		expected += "Organizer:\tMarc Hensel\n";
		assertEquals(expected, item.toString());
	}

	/** Test class Calendar.
	 */
	@Test
	public final void testCalendar() {
		User user = new User("Marc", "Hensel");
		Calendar calendar = user.getCalendar();
		
		// Getter
		assertEquals(user, calendar.getOwner());
		assertEquals(CalendarItem[].class, calendar.getItems().getClass());
		assertEquals(0, calendar.getItems().length);
		
		// Create item
		User user2 = new User("Albert", "Heinze");
		User user3 = new User("Norbert", "Hinze");
		DateTime dateTime = new DateTime(2013, 3, 5, 7, 49);
		User[] participants = {user2, user3};
		
		CalendarItem item = calendar.createItem("Betreff", dateTime, 90, participants);
		assertEquals("Betreff", item.getSubject());
		assertEquals(user, item.getOwner());
		assertEquals(2, item.getParticipants().length);
		assertEquals(user2, item.getParticipants()[0]);
		assertEquals(user3, item.getParticipants()[1]);
		assertEquals(dateTime, item.getDateTime());
		assertEquals(90, item.getDurationInMinutes());

		assertEquals(1, calendar.getItems().length);
		assertEquals(item, calendar.getItems()[0]);

		// Add item (tested implicitly: new item at user2 is added to calendar of user)
		CalendarItem item2 = user2.getCalendar().createItem("Item 2", null, 0, new User[]{user});
		assertEquals(2, calendar.getItems().length);
		assertEquals(item, calendar.getItems()[0]);
		assertEquals(item2, calendar.getItems()[1]);

		assertEquals(2, user2.getCalendar().getItems().length);	// ... and added to calendar of user2
		assertEquals(item, user2.getCalendar().getItems()[0]);
		assertEquals(item2, user2.getCalendar().getItems()[1]);

		// Remove item (user2 is owner of calendar item)
		user2.getCalendar().removeItem(item2);
		assertEquals(1, calendar.getItems().length);			// In calendar of participant (user)
		assertEquals(item, calendar.getItems()[0]);
		
		assertEquals(1, user2.getCalendar().getItems().length);	// In calendar of owner (user2)
		assertEquals(item, user2.getCalendar().getItems()[0]);
		
		// toString(): calendar of user (contains only CalendarItem "item")
		String expected = "";
		expected += "*** Calendar of Marc Hensel ***\n";
		expected += "05.03.2013 07:49 (90 min):\n";
		expected += "Subject:\tBetreff\n";
		expected += "Organizer:\tMarc Hensel\n\n";
		assertEquals(expected, calendar.toString());

		// toString(): calendar of user2 (contains only CalendarItem "item")
		String expected2 = "";
		expected2 += "*** Calendar of Albert Heinze ***\n";
		expected2 += "05.03.2013 07:49 (90 min):\n";
		expected2 += "Subject:\tBetreff\n";
		expected2 += "Organizer:\tMarc Hensel\n\n";
		assertEquals(expected2, user2.getCalendar().toString());

	}
}
