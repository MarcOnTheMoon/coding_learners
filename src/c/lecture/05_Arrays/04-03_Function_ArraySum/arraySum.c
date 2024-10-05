/*****************************************************************************************************
 * Lecture sample code.
 * Determine sum of all elements in an 1-D array.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#define SIZE 6

/* Prototypes */
int arraySum(int[], int);

/* Main function */
int main(void)
{
	int a[SIZE] = { 20, 37, 10, 16, 2, 14 };

	printf("Sum of elements: %d\n", arraySum(a, SIZE));

	getchar();
	return 0;
}

/* Determine sum of elements in array */
int arraySum(int a[], int size)
{
	int sum = 0;

	for (int i = 0; i < size; i++)
		sum += a[i];

	return sum;
}
