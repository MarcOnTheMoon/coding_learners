/*****************************************************************************************************
 * Lecture sample code.
 * Function returning the length of a string.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int stringLength(const char *);

int main(void)
{
	char city[64] = "Hamburg";

	printf("Array size    : %d\n", sizeof city / sizeof city[0]);
	printf("String        : %s\n", city);
	printf("String length : %d (excluding '\\0')\n", stringLength(city));

	getchar();
	return 0;
}

int stringLength(const char *string)
{
	int i = 0;

	while (string[i] != '\0')
		i++;
	return i;
}
