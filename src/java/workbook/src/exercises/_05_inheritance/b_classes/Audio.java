package exercises._05_inheritance.b_classes;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Audio {
	private final String artist;
	private final String title;
	private final Duration duration;

	public Audio(String artist, String title, Duration duration) {
		this.artist = artist;
		this.title = title;
		this.duration = duration;
	}

	public String getArtist() {
		return artist;
	}
	
	public String getTitle() {
		return title;
	}

	public Duration getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return String.format("%s: %s (%s)", artist, title, duration);
	}
}
