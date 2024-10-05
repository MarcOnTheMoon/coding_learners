/*****************************************************************************************************
 * Lecture sample code.
 * Passing a pointer to a structure variable to a function.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define NAME_CHARS 30

/* Structures */
struct name {
	char firstName[NAME_CHARS];
	char surname[NAME_CHARS];
};

/* Prototypes */
void printAndModifyName(struct name *person);

/* Functions */
int main(void)
{
	/* Define and initialize structure variables */
	struct name alisa = { "Alisa", "Erhardt" };

	/* Print to the console */
	printAndModifyName(&alisa);
	printf("%s %s\n", alisa.firstName, alisa.surname);

	getchar();
	return 0;
}

void printAndModifyName(struct name *person)
{
	printf("%s %s\n", person->firstName, person->surname);
	person->firstName[0] = 'E';
}
