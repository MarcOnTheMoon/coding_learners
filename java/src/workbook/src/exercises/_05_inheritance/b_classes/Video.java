package exercises._05_inheritance.b_classes;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Video {
	private final String title;
	private final ImageSize size;
	private final Duration duration;

	public Video(String title, ImageSize size, Duration duration) {
		this.title = title;
		this.size = size;
		this.duration = duration;
	}

	public String getTitle() {
		return title;
	}

	public ImageSize getSize() {
		return size;
	}

	public Duration getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" (%s)", title, duration);
	}
}