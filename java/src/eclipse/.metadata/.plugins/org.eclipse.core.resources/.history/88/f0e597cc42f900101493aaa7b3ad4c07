package exercises._04_library.c_lists;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Lottery {
	ArrayList<Integer> remaining = new ArrayList<Integer>();
	ArrayList<Integer> drawn = new ArrayList<Integer>();

	/** Initialize new drawing with numbers 1 to 49.
	 */
	void reset() {
		remaining.clear();
		drawn.clear();

		for (int i = 1; i <= 49; i++)
			remaining.add(i);		
	}

	/** Draw 6 random numbers.
	 */
	void drawNumbers() {
		// Reset lists
		reset();

		// Draw numbers
		for (int i = 1; i <= 6; i++) {
			// Remove random element from remaining numbers
			int index = (int)(remaining.size() * Math.random());
			Integer number = remaining.remove(index);

			// Insert sorted into list of drawn numbers
			int position = -1;
			while (++position < drawn.size()) {			// Start with position = 0
				if (drawn.get(position) > number)
					break;
			}
			drawn.add(position, number);
		}
	}

	@Override
	public String toString() {
		// No numbers have been drawn (empty list)
		if (drawn.isEmpty())
			return "";

		// Numbers have been drawn
		StringBuilder output = new StringBuilder(String.format("%2d", drawn.get(0)));
		for (int i = 1; i < drawn.size(); i++)
			output.append(String.format(", %2d", drawn.get(i)));

		return output.toString();
	}
}
