/*****************************************************************************************************
 * Lecture sample code.
 * Change sign of integer values represented in two's complement.
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
	signed char x = 45;
	signed char y = ~x + 1;

	/* Change sign twice (two's complement) */
	printf("Change sign twice (two's complement):\n");
	printf("% hhd -> % hhd\n", x, y);
	printf("% hhd -> % hhd\n", y, ~y + 1);

	getchar();
	return 0;
}
