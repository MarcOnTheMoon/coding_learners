/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate typedef, enum, and struct.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

/* Define constants and types */
typedef enum {
	JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER
} month;

typedef struct {
	const char *name;
	int dayOfMonth;
	month month;
	int year;
} birthday;

/* Function prototypes */
const char *getMonthName(month);
void printBirthday(birthday);

/* Main function */
int main(void)
{
	birthday birthAlisa = { "Alisa", 16, JULY, 1991 };
	printBirthday(birthAlisa);

	getchar();
	return 0;
}

/* Get string representation of month constant */
const char *getMonthName(month month)
{
	if ((month >= JANUARY) && (month <= DECEMBER))
	{
		const char *monthNames[12] = {
			"January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" };
		return monthNames[month - JANUARY];		// Works as long a months are ordered correctly
	}
	else
		return NULL;
}

/* Print birthday to the console */
void printBirthday(birthday day)
{
	printf("%s was born on %s %d, %d.\n", day.name, getMonthName(day.month), day.dayOfMonth, day.year);
}
