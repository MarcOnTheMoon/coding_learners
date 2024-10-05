/*****************************************************************************************************
 * Lecture sample code.
 * Working with structures and nested structures.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define NAME_CHARS 30

int main(void)
{
	/* Declare structures */
	struct name {
		char firstName[NAME_CHARS];
		char surname[NAME_CHARS];
	};

	struct birthday {
		struct name name;
		int dayOfMonth;
		int month;
		int year;
	};

	/* Define and initialize structure variable */
	struct birthday birthAlisa = { { "Alisa", "Erhardt" }, 16, 7, 1991 };
	
	/* Print structure data to the console */
	printf("%s %s\'s birthday is on ", birthAlisa.name.firstName, birthAlisa.name.surname);
	printf("%02d.%02d.%04d.\n", birthAlisa.dayOfMonth, birthAlisa.month, birthAlisa.year);

	getchar();
	return 0;
}
