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
#define _USE_MATH_DEFINES		// Required to use M_PI
#include <stdio.h>
#include <math.h>

/* Defines */
#define SIZE 2

/* Prototypes */
void rotateVector(double *x, double angleInDegree);

/* Main function */
int main(void)
{
	double x[SIZE] = { 2., 3. };
	double angleInDegree = 90.0;

	// Print to the console
	printf("Input vector  : (%.1f %.1f)^T\n", x[0], x[1]);
	printf("Rotate by     : %.1f degree\n", angleInDegree);
	rotateVector(x, angleInDegree);
	printf("Rotated vector: (%.1f %.1f)^T\n", x[0], x[1]);

	getchar();
	return 0;
}

/* Rotate 2D vector by a specific angle */
void rotateVector(double* x, double angleInDegree)
{
	double x0 = *x, x1 = *(x + 1);
	double angleInRad = M_PI / 180.0 * angleInDegree;
	double cosAlpha = cos(angleInRad);
	double sinAlpha = sin(angleInRad);

	*x = x0 * cosAlpha - x1 * sinAlpha;
	*(x + 1) = x0 * sinAlpha + x1 * cosAlpha;
}