/*****************************************************************************************************
 * Lecture sample code.
 * Print weekday to console using a switch-statement.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	int weekday;

	/* Get user input: Day of the week */
	printf("Enter a day (1: Monday, 2: Tuesday, ..., 7: Sunday): ");
	scanf("%d", &weekday);
	getchar();

	/* Print day of the week to console */
	switch (weekday)
	{
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			printf("Go to work\n");
			break;
		case 6:
			printf("Go shopping\n");
			break;
		case 7:
			printf("Relax\n");
			break;
		default:
			printf("I don't know that day ...\n");
			/* No need for a break-statement here */
	}

	getchar();
	return 0;
}
