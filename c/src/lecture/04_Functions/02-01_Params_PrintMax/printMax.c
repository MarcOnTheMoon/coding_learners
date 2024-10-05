/*****************************************************************************************************
 * Lecture sample code.
 * Example for function with parameters.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

/* Prototype */
void printMax(int, int);

/* Main function */
int main(void)
{
	int x = 4, y = 7;

	printMax(4, 2.25);		// Constants
	printMax(x, y);		// Variables
	printMax(3 * x, y *= x - 2);	// Expressions
	printf("y = %d\n", y);

	getchar();
	return 0;
}

/* Function with parameters */
void printMax(int a, int b)
{
	if (a > b)
		printf("max(%d, %d) = %d\n", a, b, a);
	else
		printf("max(%d, %d) = %d\n", a, b, b);
}
