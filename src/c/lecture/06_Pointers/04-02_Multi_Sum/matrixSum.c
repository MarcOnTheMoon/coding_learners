/*****************************************************************************************************
 * Lecture sample code.
 * Passing 2-D array to a function.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int sum(int a[][3], int rows);

int main(void)
{
	int a[2][3] = { { 20, 37, 10 },{ 16, 2, 14 } };

	printf("Sum: %d\n", sum(a, 2));

	getchar();
	return 0;
}

int sum(int a[][3], int rows)
{
	int sum = 0;

	for (int row = 0; row < rows; row++)
	{
		for (int column = 0; column < 3; column++)
			sum += a[row][column];
	}
	return sum;
}
