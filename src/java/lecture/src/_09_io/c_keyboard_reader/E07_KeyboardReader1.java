package _09_io.c_keyboard_reader;

import java.io.IOException;
import java.io.InputStreamReader;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E07_KeyboardReader1 {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		
		System.out.print("Bitte ein Zeichen eingeben: ");
		System.out.println(reader.read());	// Code des Zeichens
		System.out.println(reader.read());	// Immer 13 (carriage return)
		System.out.println(reader.read());	// Immer 10 (line feed)
		reader.close();
	}
}