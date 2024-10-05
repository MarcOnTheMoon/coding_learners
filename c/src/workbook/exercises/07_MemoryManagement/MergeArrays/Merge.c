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
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>
#include <stdlib.h>

/* Prototypes */
void printArray(const int* a, int size);
int* mergeArraysSorted(const int* a1, int size1, const int* a2, int size2);

/* Main function */
int main(void)
{
	const int data1[] = { 2, 3, 3, 5, 7, 8 };
	const int data2[] = { 1, 2, 4, 7, 9 };
	int size1 = sizeof data1 / sizeof(int);
	int size2 = sizeof data2 / sizeof(int);
	int* merged;

	// Print original arrays to the console
	printf("Array 1: ");
	printArray(data1, size1);
	printf("Array 2: ");
	printArray(data2, size2);

	// Merge arrays and print to console
	merged = mergeArraysSorted(data1, size1, data2, size2);
	printf("Merged : ");
	printArray(merged, size1 + size2);

	// Free memory
	free(merged);

	getchar();
	return 0;
}

/* Print array values to the console */
void printArray(const int* a, int size)
{
	for (int i = 0; i < size; i++)
		printf("%d, ", a[i]);
	printf("\b\b \n");
}

/* Merge two arrays (sorted ascending) */
int* mergeArraysSorted(const int* a1, int size1, const int* a2, int size2)
{
	int* merged = (int*)malloc((size1 + size2) * sizeof(int));
	int index1 = 0, index2 = 0;

	for (int i = 0; i < (size1 + size2); i++)
	{
		if ((index1 < size1) && (index2 < size2))
		{
			if (a1[index1] < a2[index2])
				merged[i] = a1[index1++];
			else
				merged[i] = a2[index2++];
		}
		else if (index1 < size1)
			merged[i] = a1[index1++];
		else
			merged[i] = a2[index2++];
	}

	return merged;
}