/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operations for integer numbers.
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
	int secPerDay, secPerWeek;
	int weeksPerYear, remainingDays;

	secPerDay = 24 * 60 * 60;
	secPerWeek = 7 * secPerDay;
	weeksPerYear = 365 / 7;
	remainingDays = 365 % 7;
	printf("A day has %d seconds, while a week has %d seconds.\n", secPerDay, secPerWeek);
	printf("A year has %d full weeks with %d day(s) remaining.\n", weeksPerYear, remainingDays);
	getchar();
	return 0;
}
