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
	int r1 = 150, r2 = 220, r;

	// Calculate and print resistance
	r = r1 + r2;
	printf("R1 = %d Ohm and R2 = %d Ohm in series\nare equivalent to R = %d Ohm.\n", r1, r2, r);

	getchar();
	return 0;
}
