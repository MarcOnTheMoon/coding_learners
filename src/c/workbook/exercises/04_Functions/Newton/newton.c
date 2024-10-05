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
#include <math.h>

/* Prototypes */
double f(double x);
double df(double x);
double newton(double x0, double delta, int maxSteps);

/* Main function */
int main(void)
{
	double x0 = 4.0;
	double delta = 1.0e-6;
	int maxSteps = 1000;

	// Approximate zero-crossing by Newton's method
	printf("Zero-crossing for f(x) = x^2 - 2x - 1 by Newton's method:\n");
	x0 = newton(x0, delta, maxSteps);

	// Print results to console
	printf("Approximated x0   : %.9f\n", x0);
	printf("Approximated f(x0): %.9f\n", f(x0));

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
* @param delta Method stops when the step |x_{n + 1} - x_n| is smaller than delta
* @param maxSteps Maximum iteration steps to do before stopping. Must be > 0.
* @return approximated zero-crossing
*/
double newton(double x0, double delta, int maxSteps)
{
	double x1 = x0;

	do
	{
		x0 = x1;
		x1 = x0 - f(x0) / df(x0);
	} while ((fabs(x1 - x0) > delta) && (--maxSteps > 0));

	return x1;
}