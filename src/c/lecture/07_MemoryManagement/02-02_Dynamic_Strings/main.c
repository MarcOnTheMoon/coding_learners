/*****************************************************************************************************
 * Lecture sample code.
 * Allocate and return memory for own string functions.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>

extern char *newStringClone(const char *);
extern char *newStringConcat(const char *, const char *);

int main(void)
{
	const char *dolly = "Dolly";
	const char *sheep = " the sheep";
	char *concat = newStringConcat(dolly, sheep);
	char *clone = newStringClone(concat);

	printf("1st string  : %s\n", dolly);
	printf("2nd string  : %s\n", sheep);

	if (concat != NULL)
	{
		printf("Concatenated: %s\n", concat);
		free(concat);
	}

	if (clone != NULL)
	{
		printf("Cloned      : %s\n", clone);
		free(clone);
	}

	getchar();
	return 0;
}
