package library;

import static org.junit.Assert.*;

import org.junit.Test;


public class LibraryTest {

	@Test
	public final void testR3Person_getFirstName() {
		Person person = new Person("Marc", "Hensel");
		assertEquals("Marc", person.getFirstName());
	}

	@Test
	public final void testR3Person_getSurname() {
		Person person = new Person("Marc", "Hensel");
		assertEquals("Hensel", person.getSurname());
	}

	@Test
	public final void testR4Person_toString() {
		Person person = new Person("Marc", "Hensel");
		assertEquals("Marc Hensel", person.toString());
	}

	@Test
	public final void testR8Member_Constructor() {
		Member member = new Member("Marc", "Hensel");
		assertEquals("Marc", member.getFirstName());
		assertEquals("Hensel", member.getSurname());
	}
	
	@Test
	public final void testR13Book_getAuthor() {
		Person author = new Person("Marc", "Hensel");
		String title = "Lernkartenbuch Java";
		Book book = new Book(author, title);
		
		assertEquals(author, book.getAuthor());
	}
	
	@Test
	public final void testR13Book_getTitle() {
		Person author = new Person("Marc", "Hensel");
		String title = "Lernkartenbuch Java";
		Book book = new Book(author, title);
		
		assertEquals(title, book.getTitle());
	}
	
	@Test
	public final void testR13Book_getMember() {
		Person author = new Person("Marc", "Hensel");
		String title = "Lernkartenbuch Java";
		Book book = new Book(author, title);
		assertEquals(null, book.getMember());
	}
	
	@Test
	public final void testR14Book_setMember() {
		Person author = new Person("Marc", "Hensel");
		String title = "Lernkartenbuch Java";
		Book book = new Book(author, title);		
		Member member = new Member("Your", "Name");
		
		book.setMember(member);
		assertEquals(member, book.getMember());
	}

	@Test
	public final void testR15Book_Comparable() {
		Book b1a = new Book(new Person("Abc", "Def"), "Abc");
		Book b1b = new Book(new Person("Abc", "Def"), "Abc");
		Book b2a = new Book(new Person("Aac", "Def"), "Abc");
		Book b2b = new Book(new Person("Acc", "Def"), "Abc");
		Book b3a = new Book(new Person("Abc", "Ddf"), "Abc");
		Book b3b = new Book(new Person("Abc", "Dff"), "Abc");
		Book b4a = new Book(new Person("Abc", "Def"), "Abb");
		Book b4b = new Book(new Person("Abc", "Def"), "Abd");
		
		assertEquals( 0, b1a.compareTo(b1b));
		assertEquals( 1, b1a.compareTo(b2a));
		assertEquals(-1, b1a.compareTo(b2b));
		assertEquals( 1, b1a.compareTo(b3a));
		assertEquals(-1, b1a.compareTo(b3b));
		assertEquals( 1, b1a.compareTo(b4a));
		assertEquals(-1, b1a.compareTo(b4b));
	}

	@Test
	public final void testR19Library_lendBook() {
		Library library = new Library();
		Person author = new Person("Marc", "Hensel");
		Book book1 = new Book(author, "Lernkartenbuch Java");
		Book book2 = new Book(author, "Lernkartenbuch Projektmanagement");
		
		library.addBook(book1);
		library.addBook(book2);
		
		Member member = new Member("Your", "Name");
		Person author2 = new Person("Marc", "Hensel");
		Book lendBook = library.lendBook(member, author2, "Lernkartenbuch Projektmanagement");
		assertEquals(book2, lendBook);
	}

	@Test
	public final void testR19Library_lendBook_setMember() {
		Library library = new Library();
		Person author = new Person("Marc", "Hensel");
		Book book1 = new Book(author, "Lernkartenbuch Java");
		Book book2 = new Book(author, "Lernkartenbuch Projektmanagement");

		library.addBook(book1);
		library.addBook(book2);
		
		Member member = new Member("Your", "Name");
		Person author2 = new Person("Marc", "Hensel");
		library.lendBook(member, author2, "Lernkartenbuch Java");
		assertEquals(member, book1.getMember());
	}

	@Test
	public final void testR19Library_lendBook_returnNull() {
		Library library = new Library();
		Person author = new Person("Marc", "Hensel");
		Book book1 = new Book(author, "Lernkartenbuch Java");
		Book book2 = new Book(author, "Lernkartenbuch Projektmanagement");

		library.addBook(book1);
		library.addBook(book2);
		
		Member member = new Member("Your", "Name");
		Person author2 = new Person("Marc", "Hensel");
		Book lendBook = library.lendBook(member, author2, "Lernkartenbuch Bildverarbeitung");
		assertEquals(null, lendBook);
	}

	@Test
	public final void testR20Library_returnBook() {
		Library library = new Library();
		Person author = new Person("Marc", "Hensel");
		Book book = new Book(author, "Lernkartenbuch Java");
		Member member = new Member("Your", "Name");
		
		library.addBook(book);		
		book.setMember(member);
		assertEquals(member, book.getMember());

		library.returnBook(book);
		assertEquals(null, book.getMember());
	}

	@Test
	public final void testR21Library_toString() {
		Library library = new Library();
		Person author = new Person("Marc", "Hensel");

		library.addBook(new Book(author, "Real-Time Noise Reduction of Medical X-Ray Image Sequences"));
		library.addBook(new Book(author, "Lernkartenbuch Java"));
		library.addBook(new Book(author, "Lernkartenbuch Projektmanagement"));
		library.addBook(new Book(author, "Kurvendiskussion (2. Ausgabe)"));
		library.addBook(new Book(author, "Lernkartenbuch Java"));
		library.addBook(new Book(author, "Kurvendiskussion (1. Ausgabe)"));
	
		String expected = "Books:\n";
		expected += "Hensel, Marc: Kurvendiskussion (1. Ausgabe)\n";
		expected += "Hensel, Marc: Kurvendiskussion (2. Ausgabe)\n";
		expected += "Hensel, Marc: Lernkartenbuch Java\n";
		expected += "Hensel, Marc: Lernkartenbuch Java\n";
		expected += "Hensel, Marc: Lernkartenbuch Projektmanagement\n";
		expected += "Hensel, Marc: Real-Time Noise Reduction of Medical X-Ray Image Sequences\n";

		assertEquals(expected, library.toString());
	}
}

