/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Inlcude files */
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/* Type definitions */

/* Function prototypes (provided by examiner) */
void clearKeyboardBuffer();
double eulerSeries(int);

/* Main function (provided by examiner) */
int main(void)
{
	int n = 0;

	/* User input: Get maximum number of terms to use in series */
	printf("Maximum n to use: ");
	while ((scanf("%d", &n) != 1) || (n < 0))
	{
		printf("Input must be a non-negative integer. Retry: ");
		clearKeyboardBuffer();
	}
	clearKeyboardBuffer();

	/* Calculate and print approximations of Euler's number */
	printf("Approx. of Euler's number:\n");
	for (int i = 0; i <= n; i++)
		printf("n = %2d: %8.6f\n", i, eulerSeries(i));

	getchar();
	return 0;
}

/* Clear line in keyboard buffer */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}

/* Approximate Euler's number by series e = sum_{n=0}^{infinity} 1/n! */
double eulerSeries(int n)
{
	double e = 0.0;

	for (int i = 0; i <= n; i++) {
		double term = 1.0;

		for (int j = 1; j <= i; j++)
			term /= (double)j;
		e += term;
	}

	return e;
}
