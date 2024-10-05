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
public class BookStack {
	ArrayList<Book> books = new ArrayList<Book>();
	
	/** Add a book object on top of the stack.
	 * 
	 * @param book Book to add
	 */
	void push(Book book) {
		books.add(book);
	}
	
	/** Remove the topmost book from the stack.
	 * 
	 * @return removed book (or null for empty stack)
	 */
	Book pop() {
		if (books.size() > 0) {
			return books.remove(books.size() - 1);
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder stack = new StringBuilder("Book stack:\n");
		
		for (Book book : books) {
			stack.insert(0, book.toString() + "\n");
		}
		return stack.toString();
	}
}
