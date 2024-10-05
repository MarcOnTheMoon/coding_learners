/*****************************************************************************************************
 * Lecture sample code.
 * Relational operators.
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
	int a = 7, b = 4;
	int parentheses = (a > b) == (a <= b);

	printf("true : %d\n", 1 == 1);
	printf("false: %d\n", 1 != 1);
	printf("Parentheses: %d\n", parentheses);
	printf("Precedence : %d\n", a > b == a <= b);
	getchar();
	return 0;
}
