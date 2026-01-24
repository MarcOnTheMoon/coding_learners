package exercises._06_abstract.c_observer;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class NewsMain {

	public static void main(String[] args) {
		NewsProvider newsProvider = new NewsProvider();
		NewsChannel sportChannel = new NewsChannel("Sport-Kanal", "Sport");
		NewsChannel scienceChannel = new NewsChannel("Wissen-1", "Wissenschaft");
		NewsApp app = new NewsApp();
		
		// Register listeners
		newsProvider.registerReceiver(sportChannel);
		newsProvider.registerReceiver(scienceChannel);
		newsProvider.registerReceiver(app);
		
		// Create and send news messages
		newsProvider.createNews("Panorama", "Panzerknacker rauben Dagobert Duck aus!");
		newsProvider.createNews("Kultur", "Heute mal nichts Neues");
		newsProvider.createNews("Sport", "HSV gewinnt in Kreisliga B");
		newsProvider.createNews("Panorama", "Wahnsinn - Tomate sieht rot!");
		newsProvider.createNews("Wissenschaft", "Skelett eines Dino-Teenagers mit Sitzsack gefunden");

		// Display news stored in app
		while (app.hasNext())
			app.displayNext();
		System.out.println();
		
		// Print all news in archive
		newsProvider.printArchive();
	}
}
