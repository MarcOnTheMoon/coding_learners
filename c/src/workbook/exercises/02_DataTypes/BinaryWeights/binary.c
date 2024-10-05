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
	int n = 0, weight = 1;

	// Calculate and print binary weights
	printf("2^%d = %3d\n", n, weight);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);
	printf("2^%d = %3d\n", ++n, weight *= 2);

	getchar();
	return 0;
}
