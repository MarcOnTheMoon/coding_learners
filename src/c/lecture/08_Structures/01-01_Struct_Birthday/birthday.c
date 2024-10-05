/*****************************************************************************************************
 * Lecture sample code.
 * Working with structures (declaration, definition, initialization, and accessing members).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <string.h>

#define MONTH_CHARS 10		// Longest string for a month name: "September" (including '\0')

int main(void)
{
	/* Declare structure */
	struct date {
		int dayOfMonth;
		int month;
		int year;
		char monthName[MONTH_CHARS];
	};

	/* Define structure variables */
	struct date birthAlisa;
	struct date birthSarah = { 7, 9, 1992, "September" };

	/* Initialize member variables */
	birthAlisa.dayOfMonth = 16;
	birthAlisa.month = 7;
	birthAlisa.year = 1991;
	strncpy(birthAlisa.monthName, "July", MONTH_CHARS);

	/* Print structure data to the console */
	printf("Alisa's birthday is in %-9s (%02d.%02d.%04d).\n",
		birthAlisa.monthName, birthAlisa.dayOfMonth, birthAlisa.month, birthAlisa.year);
	printf("Sarah's birthday is in %-9s (%02d.%02d.%04d).\n",
		birthSarah.monthName, birthSarah.dayOfMonth, birthSarah.month, birthSarah.year);

	getchar();
	return 0;
}
