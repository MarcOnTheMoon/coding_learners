/*****************************************************************************************************
 * Lecture sample code.
 * Replace small by capital letter.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

char toCapital(char);

int main(void) {
	char letter;

	/* Get user input */
	do
	{
		printf("Enter small letter: ");
		scanf("%c", &letter);
		getchar();
	} while ((letter < 'a') || (letter > 'z'));

	/* Transform to capital letter */
	letter = toCapital(letter);
	printf("Capital letter : %c\n", letter);

	getchar();
	return 0;
}

char toCapital(char letter)
{
	if ((letter >= 'a') && (letter <= 'z'))
		letter += 'A' - 'a';
	return letter;
}
