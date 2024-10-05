/*****************************************************************************************************
 * Lecture sample code.
 * Passing 2-D array with variable dimension to a function (random access).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void printMatrix(int *data, int rows, int columns);

int main(void)
{
	int a[2][3] = { { 20, 37, 10 },{ 16, 2, 14 } };

	printMatrix(*a, 2, 3);

	getchar();
	return 0;
}

void printMatrix(int *data, int rows, int columns)
{
	for (int y = 0; y < rows; y++)
	{
		for (int x = 0; x < columns; x++)
			printf("%2d ", data[y * columns + x]);

		putchar('\n');
	}
}
