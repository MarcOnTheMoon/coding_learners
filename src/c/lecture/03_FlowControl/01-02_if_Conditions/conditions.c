/*****************************************************************************************************
 * Lecture sample code.
 * Apply logical negation to condition in if-statement.
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
	float a;
	int isNegative;

	/* Get user input: number */
	printf("Please enter a number: ");
	scanf("%f", &a);
	getchar();

	/* Console output for non-negative number, only */
	isNegative = a < 0;
	if (!isNegative)
		printf("You have entered a non-negative number.");

	getchar();
	return 0;
}
