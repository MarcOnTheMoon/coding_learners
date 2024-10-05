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
	int maximumNumber = 20;

	// Print all numbers
	for (int i = 1; i <= maximumNumber; i++)
		printf("%2d ", i);
	putchar('\n');

	// Print odd numbers
	for (int i = 1; i <= maximumNumber; i += 2)
		printf("%2d ", i);
	putchar('\n');

	// Print even numbers
	for (int i = 2; i <= maximumNumber; i += 2)
		printf("%2d ", i);
	putchar('\n');

	getchar();
	return 0;
}
