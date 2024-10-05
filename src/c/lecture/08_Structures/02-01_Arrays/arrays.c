/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate arrays of structures.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
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

	/* Print structure data to the console */
	for (int i = 0; i < SIZE; i++)
		printf("%s %s\n", people[i].firstName, people[i].surname);

	getchar();
	return 0;
}
