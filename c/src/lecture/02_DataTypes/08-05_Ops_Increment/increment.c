/*****************************************************************************************************
 * Lecture sample code.
 * Increment and decrement operations.
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
	int a = 1;
	float b = 1.25;

	/* Integer */
	printf("a   : %d\n", a);
	printf("++a : %d\n", ++a);
	printf("a++ : %d\n", a++);
	printf("--a : %d\n", --a);
	printf("a-- : %d\n", a--);

	/* Floating point */
	printf("\nb   : %.2f\n", b);
	printf("++b : %.2f\n", ++b);

	getchar();
	return 0;
}
