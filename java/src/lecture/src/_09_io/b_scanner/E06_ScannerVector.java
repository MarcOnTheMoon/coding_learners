package _09_io.b_scanner;

import java.util.ArrayList;
import java.util.Scanner;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E06_ScannerVector {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> vector = new ArrayList<Integer>();

		// Vektor einlesen
		System.out.print("Integer-Komponenten (mit anderem Zeichen beenden): ");
		while (scanner.hasNextInt()) {
			vector.add(scanner.nextInt());
		}
		scanner.close();
		
		// Vektor und Länge ausgeben
		if (vector.size() > 0) {
			System.out.print("a = [" + vector.get(0));
			long sumOfSquares = (long) vector.get(0) * vector.get(0);
			
			for (int i = 1; i < vector.size(); i++) {
				System.out.print(", " + vector.get(i));
				sumOfSquares += (long) vector.get(i) * vector.get(i);
			}
			System.out.println("]^T");
			System.out.printf("||a|| = %.2f\n", Math.sqrt(sumOfSquares));
		}
	}
}
