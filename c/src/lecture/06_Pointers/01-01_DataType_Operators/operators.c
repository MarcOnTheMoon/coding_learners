/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate effect of address and dereferencing operators.
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
	int a = 3;
	int *ptr = &a;
	int b = *ptr;

	/* Initial data in a and b */
	printf("a  : %d\n", a);
	printf("*&a: %d\n", *&a);
	printf("b  : %d\n\n", b);

	/* Modify variable a using the pointer */
	printf("Please enter an integer: ");
	scanf("%d", ptr);
	getchar();

	printf("a   : %d\n", a);
	printf("*ptr: %d\n", *ptr);
	printf("b   : %d\n", b);

	getchar();
	return 0;
}
