/*****************************************************************************************************
 * Lecture sample code.
 * Initialization of 2-D arrays with too few elements in 1-D and 2-D braces.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define SIZE_X 3
#define SIZE_Y 2

int main(void)
{
	/* Define arrays */
	int a[SIZE_Y][SIZE_X] = { { 20, 37 },{ 16 } };	// Using braces for second dimension
	int b[SIZE_Y][SIZE_X] = { 20, 37, 16 };			// Not using braces for second dimension

													/* Print array a to the console */
	for (int y = 0; y < SIZE_Y; y++)
	{
		for (int x = 0; x < SIZE_X; x++)
			printf("%2d  ", a[y][x]);
		printf("\n");
	}
	printf("\n");

	/* Print array b to the console */
	for (int y = 0; y < SIZE_Y; y++)
	{
		for (int x = 0; x < SIZE_X; x++)
			printf("%2d  ", b[y][x]);
		printf("\n");
	}

	getchar();
	return 0;
}
