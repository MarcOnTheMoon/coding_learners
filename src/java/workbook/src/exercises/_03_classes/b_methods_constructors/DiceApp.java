package exercises._03_classes.b_methods_constructors;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceApp {
	public static void main(String[] args) {
		Dice dice = new Dice();
		int numberThrows = 6;
		
		// Throw dice and print result and counters several times
		System.out.println("Dice | #1 | #2 | #3 | #4 | #5 | #6 | Overall");
		for (int i = 0; i < numberThrows; i++) {
			// Throw dice and print to the console
			dice.throwDice();
			System.out.printf(
					"%3d  | %2d | %2d | %2d | %2d | %2d | %2d | %3d\n",
					dice.getLastValue(),
					dice.getCount(1), dice.getCount(2), dice.getCount(3),
					dice.getCount(4), dice.getCount(5), dice.getCount(6),
					dice.getCount());
			
			// Reset counters after 2nd throw
			if (i == 1) {
				System.out.println("- Reset counters -");
				dice.resetCounters();
			}
		}
	}
}
