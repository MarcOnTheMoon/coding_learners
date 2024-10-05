/*****************************************************************************************************
 * Lecture sample code.
 * Print strings and char arrays (not including '\0') to the console.
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
	char hamburg[] = "Hamburg";			// '\0' implicitly appended
	char haw[] = { 'H', 'A', 'W' };		// '\0' NOT implicitly appended
	char abc[30];						// Note: Array is larger than required for {a, b, c, ..., z, \0}

	for (int i = 0; i < 26; i++)
		abc[i] = (char)('a' + i);		// '\0' NOT implicitly appended

	/* Print strings and char arrays to the console */
	printf("hamburg: %s\n", hamburg);
	printf("haw    : %s\n", haw);
	printf("abc    : %s\n", abc);

	getchar();
	return 0;
}
