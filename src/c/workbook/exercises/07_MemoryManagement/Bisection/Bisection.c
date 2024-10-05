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
#include <stdlib.h>

/* Prototypes */
double f(double x);
double** bisection(double xl, double xr, double delta, int *numberSteps);

/* Main function */
int main(void)
{
	double xl = 0.0, xr = 4.0;
	double delta = 1.0e-2;
	double **xLimits;
	int numberSteps;

	// Determine zero-crossing by bisection method
	printf("Zero-crossing for f(x) = x^2 - 2x - 1 by bisection method:\n");
	xLimits = bisection(xl, xr, delta, &numberSteps);

	if (xLimits != NULL)
	{
		// Print results to console
		for (int i = 0; i < numberSteps; i++)
			printf("Step %d: x0 in [%.4f , %.4f]\n", i, xLimits[i][0], xLimits[i][1]);
		printf("Stopped at interval size: %f\n", delta);

		// Free
		free(xLimits);
	}

	getchar();
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
* @param numberSteps [out] Number N of bisection steps
* @return Nx2 matrix of approximated limits x_l and x_r
*/
double** bisection(double xl, double xr, double delta, int* numberSteps)
{
	double fl, fr;				// Function values f(xl) and f(xr)
	double intervalSize;
	double **xLimits;
	int columns = 2, pointerBytes, rowBytes;

	// Determine number of steps
	intervalSize = xr - xl;
	*numberSteps = 0;
	while (intervalSize > delta)
	{
		intervalSize *= 0.5;
		(*numberSteps)++;
	}

	// Allocate matrix memory
	pointerBytes = *numberSteps * sizeof(double*);
	rowBytes = *numberSteps * columns * sizeof(double);
	xLimits = (double**)malloc(pointerBytes + rowBytes);
	if (xLimits == NULL)
		return NULL;

	// Init row pointers
	for (int i = 0; i < *numberSteps; i++)
		xLimits[i] = (double*)(xLimits + *numberSteps) + i * columns;

	// Initial function values
	fl = f(xl);
	fr = f(xr);

	// Bisection
	for (int step = 0; step < *numberSteps; step++)
	{
		// Adapt interval
		double xm = 0.5 * (xl + xr);
		double fm = f(xm);

		if (fm * fl > 0)
		{
			xl = xm;
			fl = fm;
		}
		else
		{
			xr = xm;
			fr = fm;
		}

		// Store results
		xLimits[step][0] = xl;
		xLimits[step][1] = xr;
	}

	return xLimits;
}