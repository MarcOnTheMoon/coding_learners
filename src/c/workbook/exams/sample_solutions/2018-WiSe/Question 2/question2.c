/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>
#include <stdlib.h>

/* Function prototypes (provided by examiner) */
void printArray(const int a[], int size);
int* cloneArray(const int a[], int size);
void swap(int *a, int *b);
void invertArray(int a[], int size);

/* Main function */
int main(void)
{
	int input[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	int *output;
	int size = sizeof input / sizeof input[0];

	/* Print input array to the console */
	printf("Input   : ");
	printArray(input, size);

	/* Create clone array and print to the console */
	output = cloneArray(input, size);
	printf("Clone   : ");
	printArray(output, size);

	/* Invert array and print to the console */
	invertArray(output, size);
	printf("Inverted: ");
	printArray(output, size);

	/* Free allocated memory */
	free(output);

	getchar();
	return 0;
}

/* Print array to the console */
void printArray(const int a[], int size)
{
	printf("[%d", a[0]);
	for (int i = 1; i < size; i++)
		printf(", %d", a[i]);
	printf("]\n");
}

/* Clone an array (allocates new memory) */
int* cloneArray(const int a[], int size)
{
	int *clone;
	
	/* Allocate memory */
	clone = (int*)malloc(size * sizeof(int));
	if (clone == NULL)
		exit(EXIT_FAILURE);

	/* Fill with clone data */
	for (int i = 0; i < size; i++)
		clone[i] = a[i];

	return clone;
}

/* Swaps (exchanges) the values of two variables */
void swap(int *a, int *b)
{
	int temp = *a;
	*a = *b;
	*b = temp;
}

/* Inverts the order of all elements of an array */
void invertArray(int a[], int size)
{
	for (int i = 0; i < size / 2; i++)
		swap(&a[i], &a[size - (i + 1)]);
}
