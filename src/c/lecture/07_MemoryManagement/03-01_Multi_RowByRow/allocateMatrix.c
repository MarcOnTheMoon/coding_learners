/*****************************************************************************************************
 * Lecture sample code.
 * Allocate and free memory for 2-D array row by row.
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
	int **a;
	int rows = 3, columns = 4;

	/* Allocate memory for row pointers */
	if ((a = (int **)malloc(rows * sizeof(int *))) == NULL)
		exit(EXIT_FAILURE);

	/* Allocate memory for rows */
	for (int y = 0; y < rows; y++)
	{
		if ((a[y] = (int *)malloc(columns * sizeof(int))) == NULL)
			exit(EXIT_FAILURE);
	}

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
	for (int y = 0; y < rows; y++)
		free(a[y]);
	free(a);

	getchar();
	return 0;
}
