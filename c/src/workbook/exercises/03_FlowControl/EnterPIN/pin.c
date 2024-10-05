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
	const int pin = 1234;
	int enteredPin, numberTries = 0, maxTries = 3;

	// Promt at most maxTries for pin
	printf("Please enter pin: ");
	do
	{
		// Get user input
		if (numberTries > 0)
			printf("Incorrect. Retry: ");

		scanf("%d", &enteredPin);
		getchar();

		// Count number of tries
		numberTries++;
	} while ((enteredPin != pin) && (numberTries < maxTries));

	// User feedback
	if (enteredPin == pin)
		printf("Pin correct\n");
	else
		printf("Whose account are you trying to hack, fellow?!\n");

	getchar();
	return 0;
}
