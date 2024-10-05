/*****************************************************************************************************
 * Lecture sample code.
 * Enter pin code in do/while-loop.
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
	const int PIN_CODE = 20099;
	int pinEntered;

	do
	{
		printf("Enter 5-digit pin code: ");
		scanf("%d", &pinEntered);
	} while (pinEntered != PIN_CODE);
	getchar();
	printf("\nPin correct. Here are happiness and wealth!\n");

	getchar();
	return 0;
}
