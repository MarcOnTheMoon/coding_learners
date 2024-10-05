package exercises._06_abstract.c_observer;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class NewsProvider {
	private final ArrayList<News> archive = new ArrayList<News>();
	private final ArrayList<NewsReceiver> receivers = new ArrayList<NewsReceiver>();

	public void registerReceiver(NewsReceiver receiver) {
		if (!receivers.contains(receiver))
			receivers.add(receiver);
	}

	public void deregisterReceiver(NewsReceiver receiver) {
		if (receivers.contains(receiver))
			receivers.remove(receiver);
	}
	
	public void createNews(String category, String headline) {
		// Add news to archive
		News news = new News(category, headline);
		int id = news.getId();
		archive.add(news);

		// Notify receivers
		for (NewsReceiver receiver : receivers)
			receiver.onNews(this, id);
	}
	
	public News getNews(int id) {
		for (News news : archive) {
			if (news.getId() == id)
				return news;
		}
		return null;
	}
	
	public void printArchive() {
		System.out.println("Nachrichten-Archiv:");
		for (News news : archive)
			System.out.println(news);
	}
}
