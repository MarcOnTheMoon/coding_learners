/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Function prototypes (provided by examiner) */
char *invertString(const char*);
int countChar(const char*, char);

/* Main function */
int main(void)
{
	char *input = "Welcome to IE-SO1!";
	char *inverted;
	char letter = 'e';

	/* Create inverted string (new allocated memory) */
	inverted = invertString(input);
	printf("Original : %s\nInverted : %s\n", input, inverted);

	/* Count letter */
	printf("Count \'%c\': %d\n", letter, countChar(input, letter));

	/* Free memory */
	free(inverted);

	getchar();
	return 0;
}

/* Create an inverted copy of a string */
char *invertString(const char *input)
{
	/* Allocate memory for inverted string */
	int length = (int)strlen(input);
	char *inverted = (char*)malloc((length + 1) * sizeof(char));		// +1 for '\0'
	if (inverted == NULL)
	{
		printf("ERROR: Out of memory\n");
		exit(EXIT_FAILURE);
	}

	/* Invert string */
	for (int i = 0; i < length; i++)
		inverted[i] = input[length - 1 - i];
	inverted[length] = '\0';

	return inverted;
}

/* Count the occurances of a specific character in a string */
int countChar(const char *input, char character)
{
	int count = 0;
	int i = 0;

	while (input[i] != '\0')
	{
		if (input[i] == character)
			count++;
		i++;
	}

	return count;
}