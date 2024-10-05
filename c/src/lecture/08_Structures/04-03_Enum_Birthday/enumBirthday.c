/*****************************************************************************************************
 * Lecture sample code.
 * Using an enumeration to define calender month values.
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
	enum month {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
	};

	// Array expects months to be coded in 0 to 11
	const char *monthNames[12] = {
		"January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December" };

	// Unambiguous representation of month using enumeration type
	struct date {
		int dayOfMonth;
		enum month month;
		int year;
	} birthAlisa = { 16, JULY, 1991 };

	// Print month to the console
	printf("Alisa's birthday is in %s.\n", monthNames[birthAlisa.month]);

	getchar();
	return 0;
}
