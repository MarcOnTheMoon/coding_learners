/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate while-loop and condition.
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
	int a = 20;

	while (a > 0)
	{
		printf("a = %2d\n", a);
		a /= 2;
	}

	getchar();
	return 0;
}
