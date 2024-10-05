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
#include <stdlib.h>
#include <time.h>

/* Defines */
#define NUMBER_VALUES 100

/* Prototypes */
void binomialFilterPlain(const unsigned char* data, unsigned char* filtered, int size);
void binomialFilterBitOps(const unsigned char* data, unsigned char* filtered, int size);
int isArraysEqual(const unsigned char* a, const unsigned char* b, int size);

/* Main function */
int main(void)
{
	unsigned char data[NUMBER_VALUES];
	unsigned char binomialPlain[NUMBER_VALUES];
	unsigned char binomialBitOps[NUMBER_VALUES];

	// Intialize random number generator
	srand((unsigned)time(NULL));

	// Generate random values in [0, 255]
	printf("Generating %d random numbers in [0,255] ...\n", NUMBER_VALUES);
	for (int i = 0; i < NUMBER_VALUES; i++)
		data[i] = rand() % 256;

	// Apply binomial 1x3 filters
	printf("Applying binomial filter (w/o bit ops) ...\n");
	binomialFilterPlain(data, binomialPlain, NUMBER_VALUES);

	printf("Applying binomial filter (with bit ops) ...\n");
	binomialFilterBitOps(data, binomialBitOps, NUMBER_VALUES);

	// Compare filtered data for equality
	if (isArraysEqual(binomialPlain, binomialBitOps, NUMBER_VALUES))
		printf("Filtered data is identical => okay\n");
	else
		printf("Filtered data differs => not okay\n");

	getchar();
	return 0;
}

/* Apply 1x3 binomial filter.
* 
* The implementation does not use bit shifting.
* 
* @param data Data series to filter
* @param filtered [out] Resulting filtered data
* @param size Number of data elements
*/
void binomialFilterPlain(const unsigned char* data, unsigned char* filtered, int size)
{
	filtered[0] = data[0];
	filtered[size - 1] = data[size - 1];

	for (int i = 1; i < size - 1; i++)
		filtered[i] = (data[i - 1] + 2 * data[i] + data[i + 1]) / 4;
}

/* Apply 1x3 binomial filter.
*
* The implementation uses bit shifting.
*
* @param data Data series to filter
* @param filtered [out] Resulting filtered data
* @param size Number of data elements
*/
void binomialFilterBitOps(const unsigned char* data, unsigned char* filtered, int size)
{
	filtered[0] = data[0];
	filtered[size - 1] = data[size - 1];

	for (int i = 1; i < size - 1; i++)
		filtered[i] = (data[i - 1] + (data[i] << 1) + data[i + 1]) >> 2;
}

/* Compare arrays for equal values.
* 
* @param a First array
* @param b Second array
* @return 1 (true), if all corresponding elements in a and b have the same value, 0 (false) else
*/
int isArraysEqual(const unsigned char* a, const unsigned char* b, int size)
{
	for (int i = 0; i < size; i++)
	{
		if (a[i] != b[i])
			return 0;
	}
	return 1;
}