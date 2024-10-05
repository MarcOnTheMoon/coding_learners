/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate pointers in arrays of structure variables.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define NAME_CHARS 30
#define SIZE 3

int main(void)
{
	/* Declare structure */
	struct name {
		char firstName[NAME_CHARS];
		char surname[NAME_CHARS];
	};

	/* Define and initialize array of structure variables */
	struct name people[SIZE] = {
		{ "Alisa", "Erhardt" },
		{ "Sarah", "Heitmann" },
		{ "Tobias", "Neuner" }
	};
	struct name *ptr = &people[0];

	/* Print to the console */
	printf("Using pointer          : %s %s\n", ptr->firstName, ptr->surname);
	printf("people[0].firstName    : %s\n", people[0].firstName);
	printf("people[0].firstName[0] : %c\n", people[0].firstName[0]);

	getchar();
	return 0;
}
