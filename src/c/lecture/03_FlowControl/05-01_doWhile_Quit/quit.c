/*****************************************************************************************************
 * Lecture sample code.
 * Exit loop by pressing 'q' or 'Q'.
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
	char userInput;

	/* Wait for user to press 'q' or 'Q' */
	printf("Press 'q' or 'Q' to quit.\n");
	do
	{
		scanf("%c", &userInput);
	} while ((userInput != 'q') && (userInput != 'Q'));

	getchar();
	return 0;
}
