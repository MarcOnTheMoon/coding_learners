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
	int n = 0;
	float sign = 1.0;
	float pi = 4. * sign / (2. * n + 1.);

	// n = 0
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 1
	n = n + 1;
	sign = -1. * sign;
	pi = pi + 4. * sign / (2. * n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 2
	sign *= -1.;
	pi += 4. * sign / (2. * ++n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 3
	sign *= -1.;
	pi += 4. * sign / (2. * ++n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 4
	sign *= -1.;
	pi += 4. * sign / (2. * ++n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 5
	sign *= -1.;
	pi += 4. * sign / (2. * ++n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	// n = 6
	sign *= -1.;
	pi += 4. * sign / (2. * ++n + 1.);
	printf("n = %d: pi = %.6f\n", n, pi);

	getchar();
	return 0;
}
