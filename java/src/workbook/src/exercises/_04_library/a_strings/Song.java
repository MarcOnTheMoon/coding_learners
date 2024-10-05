package exercises._04_library.a_strings;

/** Class representing a song with artist and title.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Song {
	Person artist;
	String title;
	
	Song(Person artist, String title) {
		super();
		this.artist = artist;
		this.title = title;
	}

	Song(String firstName, String surname, String title) {		
		this(new Person(firstName, surname), title);
	}

	Person getArtist() {
		return artist;
	}

	String getTitle() {
		return title;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", artist, title);
	}
}
