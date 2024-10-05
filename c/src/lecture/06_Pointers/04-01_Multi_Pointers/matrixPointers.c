/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate pointer operations in 2-D arrays (matrices).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	int a[2][3] = { { 20, 37, 10 }, { 16, 2, 14 } };

	printf("*a == a[0]       : %d\n", *a == a[0]);
	printf("*(a + 1) == a[1] : %d\n\n", *(a + 1) == a[1]);

	printf("**a       : %d\n", **a);
	printf("**(a + 1) : %d\n", **(a + 1));
	printf("*(*a + 2) : %d\n", *(*a + 2));

	getchar();
	return 0;
}
