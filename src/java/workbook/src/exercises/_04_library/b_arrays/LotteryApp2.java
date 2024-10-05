package exercises._04_library.b_arrays;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LotteryApp2 {
	public static void main(String[] args) {
		final int MILLION = (int)1.E6;
		final int NUMBER_GAMES = 50 * MILLION;
		int countWin = 0;
		int countLose = 0;
		Lottery lottery = new Lottery(6, 49);
		
		// Initialize own tip
		int[] coupon = new Lottery(6, 49).drawNumbers();
		
		// Play lottery and compare to own tip
		for (int i = 0; i < NUMBER_GAMES; i++) {
			int[] numbers = lottery.drawNumbers();
			
			if (CompareArrays.equalContents(coupon, numbers))
				countWin++;
			else
				countLose++;
		}
		
		// Display results
		System.out.printf(Locale.US, "Number games : %,10d (%d millions)\n", NUMBER_GAMES, NUMBER_GAMES / MILLION);
		System.out.printf(Locale.US, "You win      : %,10d\n", countWin);
		System.out.printf(Locale.US, "You lose     : %,10d\n", countLose);
	}
}
