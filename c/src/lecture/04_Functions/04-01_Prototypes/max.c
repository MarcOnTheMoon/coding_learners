/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate "faulty" prototype with empty parameter list.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int max();			// Allowed before ANSI C, but not recommended

int main(void)
{
	printf("max(%d, %d, %d) = %d\n", 4, 2, 5, max(4, 2, 5));
	getchar();
	return 0;
}

int max(int a, int b)
{
	return (a > b) ? a : b;
}
