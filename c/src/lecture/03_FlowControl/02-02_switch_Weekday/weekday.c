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
			printf("Monday - go to work\n");
			break;
		case 2:
			printf("Tuesday - go to work\n");
			break;
		case 3:
			printf("Wednesday - go to work\n");
			break;
		case 4:
			printf("Thursday - go to work\n");
			break;
		case 5:
			printf("Friday - go to work\n");
			break;
		case 6:
			printf("Saturday - go shopping\n");
			break;
		case 7:
			printf("Sunday - relax\n");
			break;
		default:
			printf("I don't know that day ...\n");
			/* No need for a break-statement here */
	}

	getchar();
	return 0;
}
