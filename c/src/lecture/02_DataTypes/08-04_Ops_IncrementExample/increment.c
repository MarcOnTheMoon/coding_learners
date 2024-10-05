/*****************************************************************************************************
 * Lecture sample code.
 * Prefix and postfix notation for increment operations.
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
	int a = 4;

	/* Prefix operator */
	printf("a = %d\n", a);
	printf("Prefix (value)  : %d\n", ++a);
	printf("Prefix (asigned): %d\n\n", a);

	/* Postfix operator */
	a = 4;
	printf("a = %d\n", a);
	printf("Postfix (value)  : %d\n", a++);
	printf("Postfix (asigned): %d\n", a);

	getchar();
	return 0;
}
