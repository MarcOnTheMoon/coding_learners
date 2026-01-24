package exercises._04_library.c_lists;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class BookStackApp {

	public static void main(String[] args) {
		Book hansen = new Book("James", "Hansen", "First Man (The Life of Neil Armstrong)");
		Book springsteen = new Book("Bruce", "Springsteen", "Born to run");
		Book straeter = new Book("Torsten", "Sträter", "Es ist nie zu spät, unpünktlich zu sein");
		BookStack books = new BookStack();

		// Add books to stack
		books.push(springsteen);
		books.push(hansen);
		books.push(straeter);
		System.out.println(books);
		
		// Remove books from stack
		System.out.println("Removing -> " + books.pop().getSurname());
		System.out.println("Removing -> " + books.pop().getSurname());
		System.out.println(books);
		System.out.println("Removing -> " + books.pop().getSurname());
		System.out.println("Removing -> " + books.pop());
	}
}
