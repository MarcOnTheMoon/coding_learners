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

/* Type definitions */
typedef enum {
	FALSE = 0,
	TRUE
} boolean;

/* Function prototypes */
void clearKeyboardBuffer();
int isEven(int);
boolean isPrimeNumber(int);

/* Main function */
int main(void)
{
	int limit;
	int primeCount = 0;

	/* User input: Get upper limit of number range to test */
	printf("Enter maximum number to test: ");
	while ((scanf("%d", &limit) != 1) || (limit <= 0))
	{
		printf("Invalid input, must be positive integer. Retry: ");
		clearKeyboardBuffer();
	}
	clearKeyboardBuffer();

	/* Print prime numbers in number range */
	printf("Prime numbers in [1, %d]:\n", limit);
	for (int i = 1; i <= limit; i++)
	{
		if (isPrimeNumber(i) == TRUE)
		{
			printf("%4d ", i);
			if ((++primeCount % 10) == 0)
				putchar('\n');
		}
	}
	printf("\nThere are %d prime numbers in [1, %d].\n", primeCount, limit);

	getchar();
	return 0;
}

/* Clear line in keyboard buffer */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}

/* Determine whether number is even */
int isEven(int a)
{
	return (a % 2) == 0;
}

/* Determine whether number is prime number */
boolean isPrimeNumber(int k)
{
	/* Number too small (< 2) => No prime number */
	if (k <= 1)
		return FALSE;

	/* Number even (except for 2) => No prime number */
	if (isEven(k) && (k >= 4))
		return FALSE;

	/* Odd numbers: Found divisor => No prime number */
	for (int i = 3; i < k / 2; i += 2)
	{
		if ((k % i) == 0)
			return FALSE;
	}
	return TRUE;
}
