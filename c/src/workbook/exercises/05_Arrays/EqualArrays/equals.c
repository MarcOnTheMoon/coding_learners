/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Prototypes */
void printArray(int a[], int size);
int isEqualArrays(int a[], int b[], int size);

/* Main function */
int main(void)
{
	int a[] = { 6, 5, 9, 11, 20 };
	int b[] = { 6, 5, 9, 11, 20 };
	int c[] = { 6, 7, 9, 11, 20 };
	int size = sizeof(a) / sizeof(a[0]);

	// Print arrays
	printf("Arrays:\na: ");
	printArray(a, size);
	printf("\nb: ");
	printArray(b, size);
	printf("\nc: ");
	printArray(c, size);

	// Compare array values and print results
	printf("\n\nCompare arrays value by value:\n");
	printf("Is a same as b?: %s\n", isEqualArrays(a, b, size) == 1 ? "true" : "false");
	printf("Is a same as c?: %s\n", isEqualArrays(a, c, size) == 1 ? "true" : "false");
	printf("Is b same as c?: %s\n", isEqualArrays(b, c, size) == 1 ? "true" : "false");

	getchar();
	return 0;
}

/* Print array values to the console */
void printArray(int a[], int size)
{
	for (int i = 0; i < size; i++)
		printf("%d, ", a[i]);
	printf("\b\b \b");
}

/* Compare arrays for equality */
int isEqualArrays(int a[], int b[], int size)
{
	for (int i = 0; i < size; i++)
	{
		if (a[i] != b[i])
			return 0;
	}

	return 1;
}
