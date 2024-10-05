/*****************************************************************************************************
 * Lecture sample code.
 * Read floating point numbers from the keyboard.
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
	float distanceKm, timeHours;
	int timeMinutes, timeSeconds;

	printf("Distance covered: ");
	scanf("%f", &distanceKm);
	getchar();

	printf("Time taken (minutes): ");
	scanf("%d", &timeMinutes);
	getchar();

	printf("Time taken (seconds): ");
	scanf("%d", &timeSeconds);
	getchar();

	timeHours = (timeMinutes + timeSeconds / 60.0) / 60.0;
	printf("Average pace: %.1f km/h\n", distanceKm / timeHours);

	getchar();
	return 0;
}
