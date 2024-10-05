package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MathCircle {
	public static void main(String[] args) {
		double radius = 1.0;
		final double PI = 3.141592653589793;
		
		System.out.println("Radius : " + radius);
		if (radius >= 0.0) {
			System.out.println("Umfang : " + 2.0 * PI * radius);
			System.out.println("Fl�che : " + PI * radius * radius);
		} else {
			System.out.println("Negativer Radius?! Wohl nicht in Mathe aufgepasst.");
		}
	}
}
