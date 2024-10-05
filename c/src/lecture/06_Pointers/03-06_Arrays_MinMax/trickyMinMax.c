/*****************************************************************************************************
 * Lecture sample code.
 * Determine min and max value in an array (tricky approach).
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
	// Initialize with first element
	*min = *max = a[0];

	// Run through elements in pairs
	for (int i = (n % 2); i < n - 1; i += 2)
	{
		// Note: Only 3 if-statements for 2 values => 25% less compared to direct approach
		if (a[i] < a[i + 1])
		{
			if (a[i] < *min)
				*min = a[i];
			if (a[i + 1] > *max)
				*max = a[i + 1];
		}
		else
		{
			if (a[i] > *max)
				*max = a[i];
			if (a[i + 1] < *min)
				*min = a[i + 1];
		}
	}
}
