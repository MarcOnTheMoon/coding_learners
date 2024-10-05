/*****************************************************************************************************
 * Lecture sample code.
 * Calculate rate of return for bank account using a for-loop.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	double balance = 1000.0;
	double rate = 2.0;

	printf("Initial balance: %.2f EUR\n", balance);
	for (int year = 1; year <= 15; year++)
	{
		balance += balance * rate / 100.0;
		printf("After %2d years : %.2f EUR\n", year, balance);
	}

	getchar();
	return 0;
}
