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
	unsigned periodSeconds, hours, minutes, seconds;

	// Get user input: time period
	printf("Please enter a time period in seconds: ");
	scanf("%u", &periodSeconds);
	getchar();

	// Calculate and print formatted time period
	seconds = periodSeconds % 60;
	minutes = (periodSeconds / 60) % 60;
	hours = periodSeconds / (60 * 60);
	printf("The period corresponds to: %u:%02u:%02u\n", hours, minutes, seconds);

	getchar();
	return 0;
}
