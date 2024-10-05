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
	double sum = 0.0, summand = 1.0, delta = 1.0e-10;
	int nummberSummands = 0;

	// Sum up until next summand is below delta
	while (summand > delta)
	{
		sum += summand;
		summand *= 0.5;
		nummberSummands++;
	}

	// Print results to the console
	printf("Approximated value: %.11f\n", sum);
	printf("Summands added    : %d\n", nummberSummands);
	printf("Stopped at delta  : %.1e\n", delta);

	getchar();
	return 0;
}
