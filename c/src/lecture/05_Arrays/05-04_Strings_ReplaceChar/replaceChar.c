/*****************************************************************************************************
 * Lecture sample code.
 * Replace all occurrances of a character by another character.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	char text[] = "Laaking aut af the windaw.";
	int size = sizeof text / sizeof(char);

	/* Print original string to the console */
	printf("Original: %s\n", text);

	/* Replace 'a' by 'o' */
	for (int i = 0; i < size; i++)
	{
		if (text[i] == 'a')
			text[i] = 'o';
	}

	/* Print modified string to the console */
	printf("Replaced: %s\n", text);

	getchar();
	return 0;
}
