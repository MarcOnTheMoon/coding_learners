/*****************************************************************************************************
 * Lecture sample code.
 * Typical error: Assignment instead of relational operator as condition.
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
	int a = 3;

	printf("a = %d\n", a);

	if (a = 1)			/* Mistake: Assignment = instead of == */
		printf("a is equal to 1.\n");
	else
		printf("a is not equal to 1.\n");

	getchar();
	return 0;
}
