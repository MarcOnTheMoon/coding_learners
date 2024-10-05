/*****************************************************************************************************
 * Lecture sample code.
 * Implement mathematical factorial using recursion.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

unsigned long long factorial(unsigned long long);

int main(void)
{
	printf("Factorials:\n\n");
	for (int n = 0; n <= 10; n++)
		printf("%2d! = %7llu\n", n, factorial(n));

	getchar();
	return 0;
}

unsigned long long factorial(unsigned long long n)
{
	if (n >= 2)
		return n * factorial(n - 1);
	else
		return 1;
}
