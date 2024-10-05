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

/* Defines */
#define SIZE 4

/* Prototypes */
void printMatrix(int* a, int rows, int columns);
void transposeNxN(int* a, int size);

/* Main function */
int main(void)
{
	int a[SIZE][SIZE] = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 } };

	// Print original matrix
	printf("Matrix A:\n");
	printMatrix(*a, SIZE, SIZE);

	// Transpose and print matrix
	transposeNxN(*a, SIZE);
	printf("\nMatrix A^T:\n");
	printMatrix(*a, SIZE, SIZE);

	getchar();
	return 0;
}

/* Print matrix to the console */
void printMatrix(int* a, int rows, int columns)
{
	for (int y = 0; y < rows; y++)
	{
		for (int x = 0; x < columns; x++)
			printf("%3d ", a[y * columns + x]);
		putchar('\n');
	}
}

/* Transpose matrix A to become A^T */
void transposeNxN(int* a, int size)
{
	for (int y = 0; y < size; y++)
	{
		for (int x = 0; x < y; x++)
		{
			int swap = a[y * size + x];
			a[y * size + x] = a[x * size + y];
			a[x * size + y] = swap;
		}
	}
}
