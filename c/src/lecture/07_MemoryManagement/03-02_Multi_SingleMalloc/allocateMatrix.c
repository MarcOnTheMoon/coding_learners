/*****************************************************************************************************
 * Lecture sample code.
 * Allocate and free memory for 2-D array invoking malloc() only once.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int rows = 3, columns = 4;
	int **a;						// Pointer to matrix (i.e., to row pointers)
	int *data;						// Pointer to data in matrix
	int pointerBytes, rowBytes;		// Required memory in bytes

	/* Allocate memory for matrix */
	pointerBytes = rows * sizeof(int *);
	rowBytes = columns * sizeof(int);
	if ((a = (int **)malloc(pointerBytes + rows * rowBytes)) == NULL)
		exit(EXIT_FAILURE);

	/* Initialize pointers to rows */
	data = (int *)(a + rows);
	for (int y = 0; y < rows; y++)
		a[y] = data + y * columns;

	/* Fill matrix with some data */
	for (int y = 0; y < rows; y++)
	{
		for (int x = 0; x < columns; x++)
			a[y][x] = 10 * (y + 1) + (x + 1);
	}

	/* Print matrix to the console */
	for (int y = 0; y < rows; y++)
	{
		for (int x = 0; x < columns; x++)
			printf("%2d ", a[y][x]);
		putchar('\n');
	}

	/* Free matrix memory */
	free(a);

	getchar();
	return 0;
}
