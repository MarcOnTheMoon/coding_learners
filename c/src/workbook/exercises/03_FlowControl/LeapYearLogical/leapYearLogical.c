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

/* Main function */
int main(void)
{
	int year;
	int isLeapYear;

	// Get user input: year
	printf("Please enter a year: ");
	scanf("%d", &year);
	getchar();

	// Check whether year is a leap year
	isLeapYear = (((year % 4) == 0) && (((year % 100) != 0) || ((year % 400) == 0)));

	// Print the result to the console
	if (isLeapYear)
		printf("Year %d is a leap year.\n", year);
	else
		printf("Year %d is not a leap year.\n", year);

	getchar();
	return 0;
}
