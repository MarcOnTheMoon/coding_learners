/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operations for and formatted printing of floating point numbers.
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
	float balance = 1000;
	float rate = 2;

	printf("Initial balance: %.2f EURO\n", balance);
	balance = balance * (1 + rate / 100);
	printf("Balance after 1 year : %.2f EURO\n", balance);
	balance = balance * (1 + rate / 100);
	printf("Balance after 2 years: %.2f EURO\n", balance);
	balance = balance * (1 + rate / 100);
	printf("Balance after 3 years: %.2f EURO\n", balance);
	getchar();
	return 0;
}
