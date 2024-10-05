/*****************************************************************************************************
 * Lecture sample code.
 * Determine maximum of two numbers using if statement.
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
	float a, b, max;

	/* Get user input: 2 numbers */
	printf("Enter two comma-separated numbers: ");
	scanf("%f,%f", &a, &b);
	getchar();

	/* Determine and print maximum value */
	max = a;
	if (b > a)
	{
		max = b;
	}
	printf("Maximum value entered: %f", max);

	getchar();
	return 0;
}
