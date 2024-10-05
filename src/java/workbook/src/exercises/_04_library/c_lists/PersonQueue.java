package exercises._04_library.c_lists;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PersonQueue {
	ArrayList<Person> people = new ArrayList<Person>();

	/** Person enters queue (at the end).
	 * 
	 * @param person Person to add to queue
	 */
	void enter(Person person) {
		people.add(person);
	}
	
	/** First person in queue leave the queue.
	 * 	
	 * @return person that has left the queue (or null for empty queue)
	 */
	Person leave() {
		if (people.size() > 0) {
			return people.remove(0);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder output = new StringBuilder("Queue:\n");
		
		for (Person person : people) {
			output.append(person.toString()).append("\n");
		}
		return output.toString();
	}
}
