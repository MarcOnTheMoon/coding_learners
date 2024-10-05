/*****************************************************************************************************
 * Lecture sample code.
 * Determine min and max value in an array (direct approach).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void minMax(const int a[], int n, int *min, int *max);

int main(void)
{
	int a[] = { 20, 1, 6, 4, 22, 1, 25, 10, 16 };
	int min, max;

	minMax(a, sizeof a / sizeof a[0], &min, &max);
	printf("Minimum: %d\n", min);
	printf("Maximum: %d\n", max);

	getchar();
	return 0;
}

void minMax(const int a[], int n, int *min, int *max)
{
	// Initialize with 1st element
	*min = *max = a[0];

	// Run through 2nd to last element
	for (int i = 1; i < n; i++)
	{
		// Element cannot be new min AND new max at same time
		if (a[i] < *min)
			*min = a[i];
		else if (a[i] > *max)
			*max = a[i];
	}
}
