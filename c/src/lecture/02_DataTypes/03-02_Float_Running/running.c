/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operations for and formatted printing of floating point numbers.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	float distanceKm = 4.87;
	float timeMinutes = 29.5;
	float timeHours = timeMinutes / 60.0;

	printf("Average pace: %.1f km/h\n", distanceKm / timeHours);
	getchar();
	return 0;
}
