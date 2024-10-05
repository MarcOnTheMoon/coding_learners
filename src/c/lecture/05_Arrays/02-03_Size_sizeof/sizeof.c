/*****************************************************************************************************
 * Lecture sample code.
 * Determine array size using sizeof operator.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	int a[] = { 1, 6, 3, 1, 5, 8, 2, 3 };
	int size = sizeof a / sizeof a[0];
	int sum = 0;

	printf("Number of elements: %d\n", size);
	for (int i = 0; i < size; i++)
		sum += a[i];

	printf("Sum: %d\n", sum);

	getchar();
	return 0;
}
