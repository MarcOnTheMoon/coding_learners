/*****************************************************************************************************
 * Lecture sample code.
 * Protecting array data using constant pointer as parameter.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int sum(const int [], int);

int main(void)
{
	int a[] = { 20, 1, 6, 4 };
	int size = sizeof a / sizeof a[0];

	printf("Sum of all array elements: %d\n", sum(a, size));
	getchar();
	return 0;
}

int sum(const int a[], int n)
{
	int sum = 0;

	for (int i = 0; i < n; i++)
		sum += a[i];
	return sum;
}
