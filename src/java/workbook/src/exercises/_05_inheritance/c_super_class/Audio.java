package exercises._05_inheritance.c_super_class;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Audio extends Media {
	private final String artist;

	public Audio(String artist, String title, Duration duration) {
		super(title, duration);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", artist, super.toString());
	}
}
