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
#define SIZE 100

/* Main function */
int main(void)
{
	int loop[SIZE];
	int list[SIZE] = { 0 };		// Initializes missing values with zero

	// Init array using a loop
	for (int i = 0; i < SIZE; i++)
		loop[i] = 0;

	// Print arrays
	printf("Initialized by loop:\n");
	for (int i = 0; i < SIZE; i++)
	{
		printf("%d ", loop[i]);
		if ((i % 25) == 24)
			putchar('\n');
	}

	printf("\n\nInitialized by list:\n");
	for (int i = 0; i < SIZE; i++)
	{
		printf("%d ", list[i]);
		if ((i % 25) == 24)
			putchar('\n');
	}

	getchar();
	return 0;
}
