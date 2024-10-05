/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Inlcude files */
#include <stdio.h>
#include <math.h>

/* Manifest constants */
#define DIM 2

/* Function prototypes */
void printVector2D(const double a[DIM]);
double vectorLength(const double a[DIM]);
void scaleVector2D(double a[DIM], double factor);
double vectorProduct2D(const double a1[DIM], const double a2[DIM]);

/* Main function */
int main(void)
{
	double a1[DIM] = { 3., 4. };
	double a2[DIM] = { -2., 6. };

	/* Print vectors to the console */
	printf("Vectors:\na1 = ");
	printVector2D(a1);
	printf("\na2 = ");
	printVector2D(a2);
	printf("\n\n");

	/* Vector length */
	printf("Vector length:\n||a1|| = %.1f\n\n", vectorLength(a1));

	/* Scale vector */
	scaleVector2D(a2, 0.5);
	printf("Scale a2 with 0.5:\na2 = ");
	printVector2D(a2);
	printf("\n\n");

	/* Vector product */
	printf("Vector product:\n<a1, a2> = %.1f\n\n", vectorProduct2D(a1, a2));

	getchar();
	return 0;
}

/* Print vector to the console */
void printVector2D(const double a[DIM])
{
	printf("(%.1f, %.1f)", a[0], a[1]);
}

/* Length of vector */
double vectorLength(const double a[DIM])
{
	return sqrt(a[0] * a[0] + a[1] * a[1]);
}

/* Scale vector by factor */
void scaleVector2D(double a[DIM], double factor)
{
	a[0] *= factor;
	a[1] *= factor;
}

/* Multiply two vectors */
double vectorProduct2D(const double a1[DIM], const double a2[DIM])
{
	return a1[0] * a2[0] + a1[1] * a2[1];
}
