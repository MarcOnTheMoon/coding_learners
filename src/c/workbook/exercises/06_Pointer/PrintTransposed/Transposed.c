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
void printTransposedMatrix(int* a, int rows, int columns);

/* Main function */
int main(void)
{
	int a[][3] = { { 20, 37, 10 }, { 16, 2, 14 } };
	int rows = sizeof a / sizeof a[0];
	int columns = sizeof a[0] / sizeof a[0][0];

	printTransposedMatrix(*a, rows, columns);

	getchar();
	return 0;
}

/* Print transposed matrix A^T for a matrix A */
void printTransposedMatrix(int* a, int rows, int columns)
{
	for (int x = 0; x < columns; x++)
	{
		for (int y = 0; y < rows; y++)
			printf("%2d ", a[y * columns + x]);

		putchar('\n');
	}
}
