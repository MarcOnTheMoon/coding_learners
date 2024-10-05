/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

/* Defines */
#define MAX_CHARS 256

/* Prototypes */
int numberWords(const char*);

/* Main function */
int main(void)
{
	char input[MAX_CHARS];

	printf("Enter text: ");
	if (fgets(input, MAX_CHARS, stdin) != NULL)
		printf("Number of words in text: %d\n", numberWords(input));

	getchar();
	return 0;
}

/* Count number of words in a string */
int numberWords(const char* string)
{
	int words = 0;
	char current;
	char last = ' ';

	for (int i = 0; (current = string[i]) != '\0'; i++)
	{
		if ((last == ' ') && (current != ' ') && (current != '\n'))		// First character of new word
			words++;

		last = current;
	}

	return words;
}
