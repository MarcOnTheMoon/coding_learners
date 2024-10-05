/*****************************************************************************************************
 * Lecture sample code.
 * Read integer numbers from the keyboard.
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
	int yearOfBirth, thisYear;

	printf("In which year were you born?: ");
	scanf("%d", &yearOfBirth);
	getchar();

	printf("What year is today?: ");
	scanf("%d", &thisYear);
	getchar();

	printf("\nBy end of %d you will be %d years old.\n", thisYear, thisYear - yearOfBirth);
	getchar();
	return 0;
}
