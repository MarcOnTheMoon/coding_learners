package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * R1 = 1000 and R2 = 2200 give a good compromise, because<br>
 * - U_RX = 3.4 V is not exceeding 3.3 V too much for I_RX = 0 mA and<br>
 * - U_RX = 3.1 V is not dropping below 3 V for I_RX = 0.5 mA.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LogicLevel {
	public static void main(String[] args) {
		int r1 = 1000, r2 = 2200;
		double u0 = 5.0, uRX, iRX;

		// Calculate and print results for I_RX = 0 mA
		iRX = 0;
		uRX = r2 / (double)(r1 + r2) * (u0 - r1 * iRX);
		System.out.printf("U_RX = %.1f V for I_RX = %.1f mA.\n", uRX, 1.0e3 * iRX);

		// Calculate and print results for I_RX = 0.5 mA
		iRX = 0.5e-3;
		uRX = r2 / (double)(r1 + r2) * (u0 - r1 * iRX);
		System.out.printf("U_RX = %.1f V for I_RX = %.1f mA.\n", uRX, 1.0e3 * iRX);
	}
}
