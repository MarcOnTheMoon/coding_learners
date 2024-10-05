/*****************************************************************************************************
 * Lecture sample code.
 * Combined assignments.
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

	a += 2;
	printf("a = %d\n", a);					// a = a + 2 = 3
	printf("a = %d\n", a *= 3);				// a = a * 3 = 9

	a %= a - 2;								// a = a % (9 - 2) = a % 7 = 2
	printf("a = %d\n", a);
	printf("a = %d\n", a /= 3 * a - 4);		// a = a / (6 - 4) = a / 2 = 1

	getchar();
	return 0;
}
