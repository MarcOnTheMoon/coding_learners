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
int max3(int, int, int);

int main(void)
{
	int a = 45, b = 35, c = 101;
	printf("max(%d, %d, %d) = %d\n", a, b, c, max3(a, b, c));
	getchar();
	return 0;
}

int max(int a, int b)
{
	return (a > b) ? a : b;
}

int max3(int a, int b, int c)
{
	return max(max(a, b), c);
}
