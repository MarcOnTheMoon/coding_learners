/*****************************************************************************************************
 * Lecture sample code.
 * Loop until users enter 'q' or 'Q'.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	char userInput = 0;

	while ((userInput != 'q') && (userInput != 'Q'))
	{
		printf("Oh no, you're in a loop ('q' or 'Q' to quit): ");
		scanf("%c", &userInput);
		getchar();
	}

	printf("\nOkay, you've found your way out of the loop.\n");

	getchar();
	return 0;
}
