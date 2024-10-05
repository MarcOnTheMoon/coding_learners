/*****************************************************************************************************
 * Lecture sample code.
 * Ambiguous integer values.
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
	// Array expects months to be coded in 0 to 11
	const char *monthNames[12] = {
		"January", "February", "March", "April", "May", "June",
		"July", "August", "September", "October", "November", "December" };

	// Ambiguous representation of month in structure
	struct date {
		int dayOfMonth;
		int month;						// Coded 0 to 11 or coded 1 to 12?
		int year;
	} birthAlisa = { 16, 7, 1991 };

	// Print month to the console
	printf("Alisa's birthday is in %s.\n", monthNames[birthAlisa.month]);

	getchar();
	return 0;
}
