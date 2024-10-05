/*****************************************************************************************************
 * Lecture sample code.
 * Function sum (accidentally) modifying the original array data.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int sum(int[], int);

int main(void)
{
	int a[] = { 20, 1, 6, 4 };
	int size = sizeof a / sizeof a[0];

	printf("Sum of all elements (1st call): %d\n", sum(a, size));
	printf("Sum of all elements (2nd call): %d\n", sum(a, size));
	getchar();
	return 0;
}

int sum(int a[], int n)
{
	for (int i = 1; i < n; i++)
		a[0] += a[i];				// Modifies a[0] of the original array
	return a[0];
}
