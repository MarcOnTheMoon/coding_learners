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
public class NewsApp implements NewsReceiver {
	private final ArrayList<News> newsBuffer = new ArrayList<News>();

	@Override
	public void onNews(NewsProvider provider, int newsID) {
		newsBuffer.add(provider.getNews(newsID));
	}

	public boolean hasNext() {
		return newsBuffer.size() > 0;
	}
	
	public void displayNext() {
		if (hasNext()) {
			News news = newsBuffer.remove(0);
			System.out.printf("App display <-> %s\n", news.getHeadline());
		}
	}
}
