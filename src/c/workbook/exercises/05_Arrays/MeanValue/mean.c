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
double mean(double a[], int size);

/* Main function */
int main(void)
{
	double data[] = { 1., 2., 3., 4., 5., 6.5, 7. };
	int size = sizeof(data) / sizeof(data[0]);

	// Print input array
	printf("Data:");
	for (int i = 0; i < size; i++)
		printf(" %.1f", data[i]);

	// Calculate and print statistical mean
	printf("\nStatistical mean = %.1f\n", mean(data, size));

	getchar();
	return 0;
}

/* Statistical mean */
double mean(double a[], int size)
{
	double sum = 0.0;

	for (int i = 0; i < size; i++)
		sum += a[i];

	return sum / size;
}
