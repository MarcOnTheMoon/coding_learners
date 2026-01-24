package exercises._06_abstract.c_observer;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class News {
	private final int id;
	private static int nextID = 1;
	private final String category;
	private final String headline;
	
	public News(String category, String headline) {
		id = nextID++;
		this.category = category;
		this.headline = headline;
	}

	public int getId() {
		return id;
	}

	public String getCategory() {
		return category;
	}

	public String getHeadline() {
		return headline;
	}

	@Override
	public String toString() {
		return String.format("~%d %s: %s", id, category, headline);
	}
}
