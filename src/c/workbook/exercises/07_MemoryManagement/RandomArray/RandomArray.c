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
#include <stdlib.h>
#include <time.h>

/* Create array with random values in [min, max] */
int* createRandomArray(int size, int min, int max)
{
	int* a;

	// Allocate memory for array
	if ((a = malloc(size * sizeof(int))) == NULL)
		return NULL;

	// Intialize random number generator
	srand((unsigned)time(NULL));

	// Init with random numbers
	for (int i = 0; i < size; i++)
		*(a + i) = rand() % (max - min + 1) + min;

	return a;
}
