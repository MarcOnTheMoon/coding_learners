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
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Main function */
int main(void)
{
	float fahrenheit;

	// Get user input: temperature in Fahrenheit
	printf("Please enter temperature in Fahrenheit: ");
	scanf("%f", &fahrenheit);
	getchar();

	// Calculate and print temperature in Celsius
	printf("This is equivalent to %.1f deg Celsius.\n", (fahrenheit - 32.0) * 5. / 9.);

	getchar();
	return 0;
}
