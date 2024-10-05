package exercises._02_imperative;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class BankAccount {
	public static void main(String[] args) {
		double balance = 1000.0, rate = 0.35;
		double balanceDoubled = 2.0 * balance;
		int years = 0;

		// Determine years until doubling balance
		while (balance < balanceDoubled) {
			balance *= 1 + rate / 100.0;
			years++;
		}
		
		// Print data range to console
		System.out.printf(
				Locale.US,
				"Given a rate of %.2f%% a balance of %.2f EUR has doubled after %d years.\n",
				rate, balanceDoubled / 2.0, years);
		System.out.printf(Locale.US, "Balance: %.2f\n", balance);
	}
}
