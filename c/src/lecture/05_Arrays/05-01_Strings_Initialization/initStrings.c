/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate ways to initialize strings and corresponding array sizes.
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
	char hamburg[] = "Hamburg";				// '\0' implicitly appended
	char haw[] = { 'H', 'A', 'W', '\0' };	// '\0' explicitly required
	char abc[42];							// Note: Array is larger than required for {a, b, c, ..., z, \0}

	for (int i = 0; i < 26; i++)
		abc[i] = (char)('a' + i);
	abc[26] = '\0';							// '\0' explicitly required

	/* Print array sizes to the console */
	printf("Array sizes:\n\n");
	printf("hamburg: %2d\n", sizeof hamburg / sizeof(char));
	printf("haw    : %2d\n", sizeof haw / sizeof(char));
	printf("abc    : %2d\n", sizeof abc / sizeof(char));

	getchar();
	return 0;
}
