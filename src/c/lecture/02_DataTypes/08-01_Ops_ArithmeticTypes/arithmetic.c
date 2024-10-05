/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operators with mixed integer and floating point operands.
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
	int units = 4, maxUnits = 10;
	float price = 0.55;

	printf("float + int: %.2f\n", units * price);
	printf("int / int  : %d\n", units / maxUnits);
	printf("int / int  : %.1f\n", units / maxUnits);
	printf("float / int: %.1f\n", units / 10.0);
	getchar();
	return 0;
}
