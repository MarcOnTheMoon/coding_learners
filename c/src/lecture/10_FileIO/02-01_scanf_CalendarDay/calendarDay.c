/*****************************************************************************************************
 * Lecture sample code.
 * Read formatted input from the keyboard.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int dayOfMonth, month, year;
	char *monthAbbr[] = { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };

	/* Read user input and print to the console */
	printf("Enter calendar day (dd.mm.yyyy): ");
	while (scanf("%2d.%2d.%4d", &dayOfMonth, &month, &year) == 3)
	{
		// Print to the console
		if ((month >= 1) && (month <= 12))
			printf("You have entered %s %.2d, %d.\n", monthAbbr[month - 1], dayOfMonth, year);
		else
			printf("Month must be within 1 to 12.\n");

		// Clear keyboard buffer and prompt for next input
		while (getchar() != '\n')
			continue;
		printf("Next day (q to quit): ");
	}

	/* Clear keyboard buffer */
	while (getchar() != '\n')
		continue;

	getchar();
	return 0;
}
