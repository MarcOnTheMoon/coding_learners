/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate bubble sort, single-pass sorting approach, and quicksort for integer arrays.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

/* Manifest constants */
#define COUNT 10000							// Number of random values to sort
#define MAX_VAL 100							// Maximum random value
#define IS_DISPLAY_DATA (COUNT <= 100)		// Display sorted data, only if not too many

/* Function prototypes */
void printArray(const int a[], int size);
extern void bubbleSort(int a[], int size);
extern void singlePassSort(int a[], int size);
extern void quicksort(int a[], int size);

/* Main function */
int main(void)
{
	int bubble[COUNT], single[COUNT], quick[COUNT];
	clock_t start;
	unsigned timeInMs;

	/* Initialize random values */
	printf("Initializing %d random values in [0, %d] ...\n", COUNT, MAX_VAL);
	srand((unsigned)time(NULL));
	for (int i = 0; i < COUNT; i++)
		bubble[i] = single[i] = quick[i] = rand() % MAX_VAL + 1;

	/* Sort using bubble sort */
	printf("Applying sorting functions to the same values ...\n\n");
	start = clock();
	bubbleSort(bubble, COUNT);
	timeInMs = (unsigned)(((clock() - start) * 1000) / CLOCKS_PER_SEC);
	printf("Time taken (bubble sort): %3u ms\n", timeInMs);

	/* Sort using a single-pass approach */
	start = clock();
	singlePassSort(single, COUNT);
	timeInMs = (unsigned)(((clock() - start) * 1000) / CLOCKS_PER_SEC);
	printf("Time taken (single-pass): %3u ms\n", timeInMs);

	/* Sort using quicksort */
	start = clock();
	quicksort(quick, COUNT);
	timeInMs = (unsigned)(((clock() - start) * 1000) / CLOCKS_PER_SEC);
	printf("Time taken (quicksort)  : %3u ms\n\n", timeInMs);

	/* Print data to the console */
	if (IS_DISPLAY_DATA)
	{
		printf("Sorted using bubble sort:\n");
		printArray(bubble, COUNT);
		printf("Sorted using single-pass approach:\n");
		printArray(single, COUNT);
		printf("Sorted using quicksort:\n");
		printArray(quick, COUNT);
	}

	getchar();
	return 0;
}

/* Print values in array to the console */
void printArray(const int a[], int size)
{
	for (int i = 0; i < size; i++)
		printf("%3d ", a[i]);
	printf("\n\n");
}
