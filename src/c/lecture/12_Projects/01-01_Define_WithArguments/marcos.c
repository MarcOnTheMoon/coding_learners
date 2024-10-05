/*****************************************************************************************************
 * Lecture sample code.
 * Using macros (define directives) with arguments.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

#define SQUARE(X) ((X) * (X))
#define MEAN(X,Y) (((X) + (Y)) / 2)

int main(void)
{
	int a = 6;

	printf("Square:\n");
	printf("6^2       = %d\n", SQUARE(a));
	printf("(7 - 1)^2 = %d\n", SQUARE(7 - 1));
	putchar('\n');

	printf("Mean value:\n");
	printf("mean(%d, %d)       = %d\n", a, a + 3, MEAN(a, a + 3));
	printf("4.0 / mean(%d, %d) = %.1f\n", 1, 3, 4.0 / MEAN(1, 3));

	getchar();
	return 0;
}
