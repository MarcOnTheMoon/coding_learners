/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate pointers to structure variables.
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
	/* Declare structure */
	struct name {
		char firstName[NAME_CHARS];
		char surname[NAME_CHARS];
	};

	/* Define and initialize structure variables */
	struct name alisa = { "Alisa", "Erhardt" };
	struct name *ptr = &alisa;

	/* Print to the console */
	printf("ptr->firstName   : %s\n", ptr->firstName);
	printf("(*ptr).firstName : %s\n", (*ptr).firstName);

	getchar();
	return 0;
}
