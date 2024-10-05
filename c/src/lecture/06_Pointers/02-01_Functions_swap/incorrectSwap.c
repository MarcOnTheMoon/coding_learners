/*****************************************************************************************************
 * Lecture sample code.
 * Incorrect function to swap values.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void swap(int, int);

int main(void)
{
	int x = 15, y = 41;

	printf("Before: x = %d, y = %d\n", x, y);
	swap(x, y);
	printf("After : x = %d, y = %d\n", x, y);

	getchar();
	return 0;
}

void swap(int a, int b)
{
	int temp = a;	// Swap parameters, but not variables in main()
	a = b;
	b = temp;
}
