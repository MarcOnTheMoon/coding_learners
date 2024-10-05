package _09_io.a_streams;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E01_PrintStream {

	public static void main(String[] args) {
		double tempHawaiiCelsius = 15.97;
		double tempHamburgCelsius = 22.71;
		
		String.format("Hawaii: %.1f �C", tempHawaiiCelsius);
		System.out.printf("Hamburg: %.1f �C", tempHamburgCelsius);
	}
}
