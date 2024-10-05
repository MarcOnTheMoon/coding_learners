/*****************************************************************************************************
 * Lecture sample code.
 * Example for function returning a value.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int max(int, int);

int main(void)
{
	int x = 301, y = 126, z;
	int maxValue = max(x, y);							// Return value in assignment

	printf("max(%d, %d) = %d\n", x, y, maxValue);
	printf("max(%d, %d) = %d\n", y, x/2, max(y, x/2));	// Return value as function argument
	
	z = (max(x, y) > 255) ? 255 : max(x, y);			// Return value in expressions
	printf("z = %d\n", z);

	getchar();
	return 0;
}

int max(int a, int b)
{
	if (a > b)
		return a;
	else
		return b;
}
