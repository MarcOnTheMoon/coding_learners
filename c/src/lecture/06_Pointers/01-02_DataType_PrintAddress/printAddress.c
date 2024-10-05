/*****************************************************************************************************
 * Lecture sample code.
 * Variables with same name in different functions have different addresses (i.e., are at not the same).
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

void printAddress(int);

int main(void)
{
	int a = 42;

	printf("main()\t\t: %p\n", &a);
	printAddress(a);

	getchar();
	return 0;
}

void printAddress(int a)
{
	printf("printAddress()\t: %p\n", &a);
}
