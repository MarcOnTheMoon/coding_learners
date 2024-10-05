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
#include <math.h>

/* Defines */
#define ITERATIONS 6

/* Prototypes */
double f(double x);
double df(double x);
double* newton(double x0, int steps);

/* Main function */
int main(void)
{
	double x0 = 4.0;
	double* xVector;

	// Determine zero-crossing by Newton's method
	printf("Zero-crossing for f(x) = x^2 - 2x - 1 by Newton's method:\n");
	xVector = newton(x0, ITERATIONS);

	// Print results to console
	if (xVector != NULL)
	{
		// Print iterations for x_k to the console
		for (int i = 0; i < ITERATIONS; i++)
			printf("x_%d = %.10f\n", i + 1, xVector[i]);

		// Free memory
		free(xVector);
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

/* Derivative f'(x) = 2x - 2 of the mathematical function f(x) = x^2 - 2x - 1.
*
* @param x Value x to calculate f'(x) for
* @return value f'(x)
*/
double df(double x)
{
	return 2 * x - 2;
}

/* Approximate zero-crossing by iterative Newton method.
*
* Iteration: x_{n + 1} = x_n - f(x_n) / f'(x_n)
*
* @param x0 Starting position x_0
* @param steps Iteration steps N to do before stopping
* @return array of iterated values x_1, x_2, ..., x_N
*/
double* newton(double x0, int steps)
{
	double x1 = x0;
	double* xVector = (double*)malloc(steps * sizeof(double));

	if (xVector != NULL)
	{
		for (int i = 0; i < steps; i++)
		{
			x0 = x1;
			x1 = x0 - f(x0) / df(x0);
			xVector[i] = x1;
		}
	}

	return xVector;
}