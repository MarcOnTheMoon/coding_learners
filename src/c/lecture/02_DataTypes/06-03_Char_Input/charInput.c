/*****************************************************************************************************
 * Lecture sample code.
 * Get numeric character from keyboard.
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
	char input;

	/* Get user input */
	printf("Please enter a character: ");
	scanf("%c", &input);
	getchar();

	/* Print input and numeric code to console */
	printf("\nEntered\t\t: '%c'\n", input);
	printf("Numeric code\t: %d\n", input);
	getchar();
	return 0;
}
