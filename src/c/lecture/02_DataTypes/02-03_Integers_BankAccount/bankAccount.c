/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operations for integer numbers.
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
	int balance = 1000;
	int rate = 2;

	printf("Initial balance: %d EURO\n", balance);
	balance = (balance * (100 + rate)) / 100;
	printf("Balance after 1 year : %d EURO\n", balance);
	balance = (balance * (100 + rate)) / 100;
	printf("Balance after 2 years: %d EURO\n", balance);
	balance = (balance * (100 + rate)) / 100;
	printf("Balance after 3 years: %d EURO\n", balance);
	getchar();
	return 0;
}
