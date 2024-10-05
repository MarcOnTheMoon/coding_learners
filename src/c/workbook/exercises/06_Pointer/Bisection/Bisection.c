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
double f(double x);
double bisection(double *xl, double *xr, double delta);

/* Main function */
int main(void)
{
	double xl = 0.0, xr = 4.0, x0;
	double delta = 1.0e-6;

	// Determine zero-crossing by bisection method
	printf("Zero-crossing for f(x) = x^2 - 2x - 1 by bisection method:\n");
	x0 = bisection(&xl, &xr, delta);

	// Print results to console
	printf("Stop interval size : %.9f\n", delta);
	printf("True interval size : %.9f\n", xr - xl);
	printf("Lower limit  x0    : %.9f\n", xl);
	printf("Approximated x0    : %.9f\n", x0);
	printf("Upper limit  x0    : %.9f\n", xr);
	printf("Approximated f(x0) : %.9f\n", f(x0));

	return 0;
}

/* Mathematical function f(x) = x^2 - 2x - 1.
*
* @param x Value x to calculate function for
* @return value f(x)
*/
double f(double x)
{
	return x * x - 2 * x - 1;
}

/* Approximate zero-crossing by iterative bisection method.
*
* @param xl Left border of start interval
* @param xr Right border of start interval (must be > xl)
* @param delta Method stops when interval size xr - xl is smaller than delta
* @return approximated zero-crossing x0 being the center (xl + xr) / 2 of last interval
*/
double bisection(double *xl, double *xr, double delta)
{
	// Initial function values
	double fl = f(*xl);
	double fr = f(*xr);

	// Bisection
	while (*xr - *xl > delta)
	{
		// Adapt interval
		double xm = 0.5 * (*xl + *xr);
		double fm = f(xm);

		if (fm * fl > 0)
		{
			*xl = xm;
			fl = fm;
		}
		else
		{
			*xr = xm;
			fr = fm;
		}
	}

	return 0.5 * (*xl + *xr);
}