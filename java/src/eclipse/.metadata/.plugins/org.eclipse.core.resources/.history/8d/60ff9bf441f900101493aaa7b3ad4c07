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
public class EulerNumber {
	public static void main(String[] args) {
		System.out.println("Approximation of Euler number:");
		
		for (int n = 0; n <= 5; n++) {
			double e = 0.0;
			
			// Euler number as sum of inverted factorials
			for (int k = 0; k <= n; k++) {
				// Calculate factorial
				long factorial = 1;
				for (int p = 2; p <= k; p++) {
					factorial *= p;
				}
				
				// Add to sum
				e += 1.0 / factorial;
			}
			
			// Print result to the console
			System.out.printf(Locale.US, "n = %d: %.9f\n", n, e);
		}
	}
}
