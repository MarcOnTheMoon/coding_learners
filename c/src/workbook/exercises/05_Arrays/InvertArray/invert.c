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

/* Main function */
int main(void)
{
	int a[] = { 1, 2, 5, 9, 11, 20, 26 };
	int size = sizeof(a) / sizeof(int);

	// Print array
	printf("Source  :");
	for (int i = 0; i < size; i++)
		printf(" %2d", a[i]);

	// Invert order of array values
	for (int i = 0; i < size / 2; i++)
	{
		int swap = a[i];
		a[i] = a[size - (i + 1)];
		a[size - (i + 1)] = swap;
	}

	// Print array
	printf("\nInverted:");
	for (int i = 0; i < size; i++)
		printf(" %2d", a[i]);
	putchar('\n');

	getchar();
	return 0;
}
