package exercises._03_classes.b_methods_constructors;

/** Class representing a die with results in 1 to 6.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Dice {
	int lastValue;
	int count1, count2, count3, count4, count5, count6;
	
	/** Get result of last throw.
	 * 
	 * @return last dice value thrown
	 */
	int getLastValue() {
		return lastValue;
	}
	
	/** Get number of throws since start or last reset.
	 * 
	 * @return number of times the dice has been thrown
	 */
	int getCount() {
		return count1 + count2 + count3 + count4 + count5 + count6;
	}

	/** Get number of times a specific value has been thrown since start or last reset.
	 * 
	 * @param value Value to get the count for (in 1 to 6) 
	 * @return number of times value has been thrown
	 */
	int getCount(int value) {
		return switch (value) {
			case 1 -> count1;
			case 2 -> count2;
			case 3 -> count3;
			case 4 -> count4;
			case 5 -> count5;
			case 6 -> count6;
			default -> -1;
		};
	}

	/** Reset counting the number of throws.
	 */
	void resetCounters() {
		count1 = count2 = count3 = count4 = count5 = count6 = 0;
	}

	/** Throw the dice.
	 * 
	 * @return the value thrown in 1 to 6
	 */
	int throwDice() {
		// Get random value
		lastValue = (int)(6.0 * Math.random()) + 1;
		
		// Increment count
		switch (lastValue) {
			case 1 -> count1++;
			case 2 -> count2++;
			case 3 -> count3++;
			case 4 -> count4++;
			case 5 -> count5++;
			case 6 -> count6++;
		}

		return lastValue;
	}
}
