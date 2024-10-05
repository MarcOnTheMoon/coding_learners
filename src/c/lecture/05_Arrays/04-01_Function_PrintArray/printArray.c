/*****************************************************************************************************
 * Lecture sample code.
 * 1-D array as function parameter.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#define SIZE 6

/* Prototypes */
void printArray(int [], int);

/* Main function */
int main(void)
{
	int a[SIZE] = { 20, 37, 10, 16, 2, 14 };

	printf("Print 1-D array to the console:\n");
	printArray(a, SIZE);

	getchar();
	return 0;
}

/* Print 1-D array to the console */
void printArray(int a[], int size)
{
	for (int i = 0; i < size; i++)
		printf("%d ", a[i]);

	putchar('\n');
}
