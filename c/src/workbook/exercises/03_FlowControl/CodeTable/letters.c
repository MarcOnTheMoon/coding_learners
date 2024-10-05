/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Main function */
int main(void)
{
	// Print table header
	printf("Letter | Small | Capital\n-------+-------+--------\n");

	// Print numeric codes for letters
	for (char small = 'a', capital = 'A'; small <= 'z'; small++, capital++)
		printf("   %c   |  %3d  |  %3d\n", capital, small, capital);

	getchar();
	return 0;
}
