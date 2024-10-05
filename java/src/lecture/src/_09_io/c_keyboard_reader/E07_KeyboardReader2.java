package _09_io.c_keyboard_reader;

import java.io.BufferedReader;
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
public class E07_KeyboardReader2 {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
		System.out.print("Bitte erste Zeile eingeben:  ");
		String line1 = bufferedReader.readLine();
		System.out.print("Bitte zweite Zeile eingeben: ");
		String line2 = bufferedReader.readLine();

		System.out.println(line1);
		System.out.println(line2);
		reader.close();
	}
}
