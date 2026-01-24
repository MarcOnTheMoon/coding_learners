package exercises._06_abstract.c_observer;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class NewsChannel implements NewsReceiver {
	private final String name;
	private final String ressort;

	public NewsChannel(String name, String ressort) {
		super();
		this.name = name;
		this.ressort = ressort;
	}

	@Override
	public void onNews(NewsProvider provider, int newsID) {
		News news = provider.getNews(newsID);
		
		if (news.getCategory().equalsIgnoreCase(ressort)) {
			System.out.printf("+++ %s aktuell +++\n", name);
			System.out.println(news.getHeadline() + "\n");
		}		
	}

}
