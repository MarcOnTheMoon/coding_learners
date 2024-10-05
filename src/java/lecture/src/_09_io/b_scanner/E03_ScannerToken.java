package _09_io.b_scanner;

import java.util.Scanner;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E03_ScannerToken {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Bitte einen Satz eingeben: ");
		System.out.println(scanner.next());
		scanner.close();
	}
}
