/*****************************************************************************************************
 * Lecture sample code.
 * Passing 2-D array with variable dimension to a function (linear access).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int sum(int *data, int rows, int columns);

int main(void)
{
	int a[2][3] = { { 20, 37, 10 },{ 16, 2, 14 } };

	printf("Sum: %d\n", sum(*a, 2, 3));		// *a == a[0] (address of first int element)

	getchar();
	return 0;
}

int sum(int *data, int rows, int columns)
{
	int sum = 0;

	for (int i = 0; i < rows * columns; i++)
		sum += data[i];

	return sum;
}
