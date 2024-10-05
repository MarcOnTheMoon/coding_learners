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
#include <stdio.h>

/* Main function */
int main(void)
{
	double balance = 1000.0, rate = 0.35;
	double balanceDoubled = 2.0 * balance;
	int years = 0;

	// Determine years until doubling balance
	while (balance < balanceDoubled)
	{
		balance *= 1 + rate / 100.0;
		years++;
	}
	
	// Print data range to console
	printf("Given a rate of %.2f%% a balance of %.2f EUR has doubled after %d years.\n", rate, balanceDoubled / 2.0, years);
	printf("Balance: %.2f\n", balance);

	getchar();
	return 0;
}
