package exercises._03_classes.a_classes;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SongApp {
	public static void main(String[] args) {
		// Initialize song creating person, first
		Person dido = new Person();
		dido.firstName = "Dido";
		dido.surname = "Armstrong";

		Song isobel = new Song();
		isobel.artist = dido;
		isobel.title = "Isobel";
		
		// Initialize song without explicit reference to person
		Song believe = new Song();
		believe.artist = new Person();
		believe.artist.firstName = "Sheryl";
		believe.artist.surname = "Crow";
		believe.title = "I shall believe";
				
		// Print objects' attributes to the console
		System.out.println("Playlist:");
		System.out.printf("%s (%s %s)\n", isobel.title, isobel.artist.firstName, isobel.artist.surname);
		System.out.printf("%s (%s %s)\n", believe.title, believe.artist.firstName, believe.artist.surname);
	}
}
