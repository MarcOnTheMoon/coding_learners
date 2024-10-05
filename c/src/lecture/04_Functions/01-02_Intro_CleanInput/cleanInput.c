/*****************************************************************************************************
 * Lecture sample code.
 * Function cleaning keyboard input from unnecessary space characters.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

void cleanInput(void);

int main(void)
{
	printf("Enter sentence (cleans spaces): ");
	cleanInput();

	getchar();
	return 0;
}

void cleanInput(void)
{
	char current;
	char last = '\n';

	while ((current = getchar()) != '\n')
	{
		int isDoubleSpace = (last == ' ') && (current == ' ');
		int isLeadingSpace = (last == '\n') && (current == ' ');

		/* Print keyboard input (or clear space key) */
		if ((last == ' ') && (current == '.'))			// Remove space before period
			printf("\b.");
		else if (!isDoubleSpace && !isLeadingSpace)		// Ignore double and leading spaces
			putchar(current);

		/* Remember last character */
		last = current;
	}
}
