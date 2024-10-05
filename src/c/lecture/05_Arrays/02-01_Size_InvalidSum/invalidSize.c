/*****************************************************************************************************
 * Lecture sample code.
 * Sum up more values than exist for array.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	int a[] = { 1, 6, 3, 1, 5, 8, 2, 3 };	// 8 elements a[0] to a[7]
	int sum = 0;

	for (int i = 0; i < 9; i++)				// Mistake: 9 elements a[0] to a[8]
		sum += a[i];

	printf("Sum: %d\n", sum);

	getchar();
	return 0;
}
