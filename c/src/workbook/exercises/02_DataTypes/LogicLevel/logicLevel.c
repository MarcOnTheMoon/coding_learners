/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Main function.
*
* R1 = 1000 and R2 = 2200 give a good compromise, because
* - U_RX = 3.4 V is not exceeding 3.3 V too much for I_RX = 0 mA and
* - U_RX = 3.1 V is not dropping below 3 V for I_RX = 0.5 mA.
*/
int main(void)
{
	int r1, r2;
	double u0 = 5.0, uRX, iRX;

	// Get user input: grade counts
	printf("Please enter resistances R1 and R2 separated by a comma: ");
	scanf("%d,%d", &r1, &r2);
	getchar();

	// Calculate and print results for I_RX = 0 mA
	iRX = 0;
	uRX = r2 / (double)(r1 + r2) * (u0 - r1 * iRX);
	printf("U_RX = %.1f V for I_RX = %.1f mA.\n", uRX, 1.0e3 * iRX);

	// Calculate and print results for I_RX = 0.5 mA
	iRX = 0.5e-3;
	uRX = r2 / (double)(r1 + r2) * (u0 - r1 * iRX);
	printf("U_RX = %.1f V for I_RX = %.1f mA.\n", uRX, 1.0e3 * iRX);

	getchar();
	return 0;
}
