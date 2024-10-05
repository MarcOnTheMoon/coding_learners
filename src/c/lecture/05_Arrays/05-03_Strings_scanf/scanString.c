/*****************************************************************************************************
 * Lecture sample code.
 * Read string from keyboard using scanf().
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
	char name[256];
	char keystroke;

	/* Get user input */
	printf("Please enter your name: ");
	scanf("%s", name);

	/* Print string and keyboard buffer to the console */
	printf("Name  : %s\n", name);
	printf("Buffer: ");
	while ((keystroke = getchar()) != '\n')
		putchar(keystroke);
	putchar('\n');

	getchar();
	return 0;
}
