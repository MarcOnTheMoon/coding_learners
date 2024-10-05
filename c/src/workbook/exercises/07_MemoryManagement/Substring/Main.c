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
#include <stdlib.h>

/* Prototypes */
void clearKeyboardBuffer();
extern char* substring(const char* string, int first, int last);

/* Main function */
int main(void)
{
	const char* globe = "The Globe Sessions";
	char* extracted;
	int first, last;

	// Get user input: substring indices
	printf("Original string: \"%s\"\n", globe);
	printf("Enter indices of substring (formatted \"first:last\"): ");
	if (scanf("%d:%d", &first, &last) == 2)
	{
		clearKeyboardBuffer();

		// Substring: create, print, and free
		extracted = substring(globe, first, last);
		if (extracted != NULL)
		{
			printf("Substring: \"%s\"\n", extracted);
			free(extracted);
		}
		else
			printf("Could not create substring.\n");
	}
	else
	{
		clearKeyboardBuffer();
		printf("Could not read indices.\n");
	}

	getchar();
	return 0;
}

/* Remove characters from keyboard buffer until next \n included */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}
