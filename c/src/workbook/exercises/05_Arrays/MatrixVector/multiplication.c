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
#define SIZE 3

/* Main function */
int main(void)
{
	int a[SIZE][SIZE] = {
		{ 1, 2, 0 },
		{ 0, 2, 1 },
		{ 3, 0, 1 }
	};
	int x[SIZE] = { 2, 3, 1 };
	int y[SIZE] = { 0, 0, 0 };

	// Calculate product
	for (int row = 0; row < SIZE; row++)
	{
		for (int column = 0; column < SIZE; column++)
			y[row] += a[row][column] * x[column];
	}

	// Print result
	printf("         |%d %d %d|   |%d|   |%d|\n", a[0][0], a[0][1], a[0][2], x[0], y[0]);
	printf("y = Ax = |%d %d %d| * |%d| = |%d|\n", a[1][0], a[1][1], a[1][2], x[1], y[1]);
	printf("         |%d %d %d|   |%d|   |%d|\n", a[2][0], a[2][1], a[2][2], x[2], y[2]);

	getchar();
	return 0;
}
