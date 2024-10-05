/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate that parameters are local variables.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void printCube(int);

int main(void)
{
	int a = 3;

	printf("Main: a = %2d\n", a);
	printCube(a);
	printf("Main: a = %2d\n", a);

	getchar();
	return 0;
}

void printCube(int a)
{
	a = a * a * a;
	printf("Cube: a = %2d\n", a);
}
