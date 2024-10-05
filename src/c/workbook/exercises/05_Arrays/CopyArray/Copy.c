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

/* Defines */
#define SIZE 6

/* Main function */
int main(void)
{
	int source[SIZE] = { 1, 2, 5, 9, 11, 20 };
	int copy[SIZE];

	// Copy array values
	for (int i = 0; i < SIZE; i++)
		copy[i] = source[i];

	// Print arrays
	printf("Source:");
	for (int i = 0; i < SIZE; i++)
		printf(" %d", source[i]);

	printf("\nCopy  :");
	for (int i = 0; i < SIZE; i++)
		printf(" %d", copy[i]);

	getchar();
	return 0;
}
