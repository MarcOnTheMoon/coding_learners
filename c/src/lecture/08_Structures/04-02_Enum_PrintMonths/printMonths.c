/*****************************************************************************************************
 * Lecture sample code.
 * Print enumeration values.
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
	// Define integer constants
	enum {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	};

	// Array expects months to be coded in 0 to 11
	const char *monthNames[12] = {
		"January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December" };

	// Print month name and constant value to the console
	for (int month = JANUARY; month <= DECEMBER; month++)
		printf("%-10s: %d\n", monthNames[month], month);

	getchar();
	return 0;
}
