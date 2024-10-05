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
#include <stdlib.h>
#include <time.h>

/* Create matrix with random values in [min, max] */
int** createRandomMatrix(int rows, int columns, int min, int max)
{
	int** a;						// Pointer to matrix (i.e., to row pointers)
	int* data;						// Pointer to data in matrix
	int pointerBytes, rowBytes;		// Required memory in bytes

	// Allocate memory for matrix
	pointerBytes = rows * sizeof(int*);
	rowBytes = columns * sizeof(int);
	if ((a = (int**)malloc(pointerBytes + rows * rowBytes)) == NULL)
		return NULL;

	// Initialize pointers to rows
	data = (int*)(a + rows);
	for (int y = 0; y < rows; y++)
		a[y] = data + y * columns;

	// Init with random numbers
	srand((unsigned)time(NULL));
	for (int y = 0; y < rows; y++)
	{
		for (int x = 0; x < columns; x++)
			a[y][x] = rand() % (max - min + 1) + min;
	}
	return a;
}
