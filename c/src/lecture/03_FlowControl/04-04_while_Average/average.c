/*****************************************************************************************************
 * Lecture sample code.
 * Calculate the average value of numbers entered by users.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	double number;
	double sum = 0.0;
	int count = 0, inputOK = 1;

	/* Get user input: Numbers */
	printf("Enter numbers (any character to stop):\n");
	inputOK = scanf("%lf", &number);
	while (inputOK)
	{
		sum += number;
		count++;
		inputOK = scanf("%lf", &number);
	}
	getchar();		// Last scanf() could not read character
	getchar();		// Get enter key of last input

	/* Calculate and print mean value */
	if (count > 0)
		printf("\nNumbers: %d\nAverage: %.1f\n", count, sum / (double) count);

	getchar();
	return 0;
}
