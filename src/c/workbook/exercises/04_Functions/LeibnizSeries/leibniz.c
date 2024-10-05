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

/* Prototypes */
double leibnizSeries(int nMax);

/* Main function */
int main(void)
{
	// Calculate and print approximations for pi
	for (int i = 0; i <= 1000; i += 50)
		printf("N = %4d: pi = %.6f\n", i, leibnizSeries(i));

	getchar();
	return 0;
}

/* Approximate math pi by the Leibniz series.
*
* @param nMax Number of summands to use in series
* @return approximation of pi
*/
double leibnizSeries(int nMax)
{
	double pi = 0.0;
	int sign = 1;

	for (int n = 0; n <= nMax; n++)
	{
		pi += 4 * sign / (double)(2 * n + 1);
		sign *= -1;
	}

	return pi;
}