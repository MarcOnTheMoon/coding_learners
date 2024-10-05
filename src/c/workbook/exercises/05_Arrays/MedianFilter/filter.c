/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Prototypes */
int median3(int, int, int);

/* Main function */
int main(void)
{
	// Define arrays
	int raw[15] = { 95, 91, 211, 97, 89, 96, 94, 3, 91, 94, 92, 96, 93, 97, 94 };
	int median[15];
	int size = sizeof raw / sizeof raw[0];

	// Apply filter to original data
	median[0] = raw[0];
	median[size - 1] = raw[size - 1];
	for (int i = 1; i <= size - 2; i++)
		median[i] = median3(raw[i - 1], raw[i], raw[i + 1]);

	// Print arrays to the console
	printf("Original: %3d", raw[0]);
	for (int i = 1; i < size; i++)
		printf(", %3d", raw[i]);
	printf("\n");

	printf("Median:   %3d", median[0]);
	for (int i = 1; i < size; i++)
		printf(", %3d", median[i]);
	printf("\n");

	getchar();
	return 0;
}

/* Get median of three value */
int median3(int a, int b, int c)
{
	int sorted[3] = { a, b, c };

	// Sort parameters
	for (int i = 1; i < 3; i++)
	{
		if (sorted[i] < sorted[i - 1])
		{
			int swap = sorted[i];
			sorted[i] = sorted[i - 1];
			sorted[i - 1] = swap;
			i = 0;
		}
	}

	return sorted[1];
}
