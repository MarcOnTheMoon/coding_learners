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
	int nMax = 1000, sign = 1;
	double pi = 0.0;

	// Calculate and print approximations for pi
	for (int n = 0; n <= nMax; n++)
	{
		pi += 4 * sign / (double)(2 * n + 1);
		sign *= -1;

		if ((n <= 10) || ((n % 250) == 0))
			printf("n = %5d: pi = %.6f\n", n, pi);
	}

	getchar();
	return 0;
}
