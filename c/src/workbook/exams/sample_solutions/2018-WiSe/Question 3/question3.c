/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>

/* Function prototypes (provided by examiner) */
void clearKeyboardBuffer();

/* Main function */
int main(void)
{
	const int MAX_N = 16;
	int n;

	printf("Calculation of 2^n with n in [0,%d]:\n", MAX_N);
	printf("Enter n: ");
	while (scanf("%d", &n) == 1)
	{
		clearKeyboardBuffer();

		if ((n >= 0) && (n <= MAX_N))
			printf("  2^%d = %d\n", n, 1 << n);
		else
			printf("  Incorrect input: Not in [0,%d]\n", MAX_N);

		printf("Enter n: ");
	}
	clearKeyboardBuffer();
	printf("Press any key to quit.\n");

	getchar();
	return 0;
}

/* Clear line in keyboard buffer */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}
