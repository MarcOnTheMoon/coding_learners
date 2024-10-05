package _02_imperative.b_flow_control;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class BreakContinue {

	public static void main(String[] args) {
		// break
		System.out.println("Break (bei i == 2):");
		for (int i = 0; i <= 4; i++) {
			if (i == 2) {
				break;
			}
			System.out.println("  i = " + i);
		}

		// continue
		System.out.println("\nContinue (bei i == 2):");
		for (int i = 0; i <= 4; i++) {
			if (i == 2) {
				continue;
			}
			System.out.println("  i = " + i);
		}
	}
}
