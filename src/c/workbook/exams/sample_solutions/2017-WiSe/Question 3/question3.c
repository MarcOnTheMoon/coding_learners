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
#include <stdlib.h>

/* Function prototypes (provided by examiner) */
void clearKeyboardBuffer();
void sortDescending(int *a, int *b);
int greatestCommonDivisor(int, int);
int getNumberOfDivisors(int m);
int* newArrayOfDivisors(int m);

/* Main function */
int main(void)
{
	int m, n, gcd;
	int *divisors;

	/* User input: Get two positive interger numbers */
	printf("Enter two positive integer numbers (comma-separated): ");
	while ((scanf("%d,%d", &m, &n) != 2) || (m <= 0) || (n <= 0))
	{
		printf("Invalid input. Retry: ");
		clearKeyboardBuffer();
	}
	clearKeyboardBuffer();

	/* Print divisors of first user input */
	divisors = newArrayOfDivisors(m);
	printf("Divisors of %d: ", m);
	for (int i = 0; i < getNumberOfDivisors(m); i++)
		printf("%d ", divisors[i]);
	putchar('\n');
	free(divisors);

	/* Determine greatest common divisor */
	gcd = greatestCommonDivisor(m, n);
	printf("Greatest common devisor: gcd(%d, %d) = %d\n", m, n, gcd);

	getchar();
	return 0;
}

/* Clear line in keyboard buffer */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}

/* Sort two integer numbers descending */
void sortDescending(int *a, int *b)
{
	if (*b > *a)
	{
		int swap = *a;
		*a = *b;
		*b = swap;
	}
}

/* Determine the greatest common divisor using Euclid's algorithm */
int greatestCommonDivisor(int m, int n)
{
	int remainder;

	do
	{
		sortDescending(&m, &n);		/* Ensure m >= n */
		m = remainder = m % n;
	} while (remainder != 0);

	return n;
}


/* Get number of divisors */
int getNumberOfDivisors(int m)
{
	int numberDivisors = 1;		// 1 is a divisor

	for (int k = 2; k <= m / 2; k++)
	{
		if (m % k == 0)
			numberDivisors++;
	}
	return numberDivisors;
}

/* Get all divisors of an integer number */
int* newArrayOfDivisors(int m)
{
	int numberDivisors = getNumberOfDivisors(m);
	int *divisors;

	// Allocate memory for array
	divisors = (int *)malloc(numberDivisors * sizeof(int));
	if (divisors == NULL)
		exit(EXIT_FAILURE);

	// Store divisors in array
	for (int k = 1, count = 0; k <= m / 2; k++)
	{
		if (m % k == 0)
			divisors[count++] = k;
	}

	return divisors;
}
