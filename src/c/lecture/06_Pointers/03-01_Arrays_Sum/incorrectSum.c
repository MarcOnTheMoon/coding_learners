/*****************************************************************************************************
 * Lecture sample code.
 * Mistake by not passing an array's size to a function.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int sum(int *);

int main(void)
{
	int a[] = { 20, 1, 6, 4 };

	printf("Sum of all array elements: %d\n", sum(a));
	getchar();
	return 0;
}

int sum(int *a)
{
	int sum = 0;
	int size = sizeof a / sizeof(int);		// Mistake: Size of the pointer, not the array

	printf("Array size in sum()      : %d\n", size);
	for (int i = 0; i < size; i++)
		sum += a[i];
	return sum;
}
