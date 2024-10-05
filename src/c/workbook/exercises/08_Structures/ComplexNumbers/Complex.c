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
#define _USE_MATH_DEFINES		// Enable mathematical constant M_PI in math.h
#include <stdio.h>
#include <math.h>

/* Structures */
struct complexNumber {
	double real;
	double imaginary;
};

/* Prototypes */
double getComplexAbsolute(struct complexNumber z);
double getComplexPhase(struct complexNumber z);
struct complexNumber addComplex(struct complexNumber a, struct complexNumber b);

/* Main function */
int main(void)
{
	struct complexNumber z1 = { 2.0, -2.0 };
	struct complexNumber z2 = { -0.5, 0.7 };
	struct complexNumber sum = addComplex(z1, z2);

	// Print complex numbers
	printf("z1 = % .1f %+.1f j\n", z1.real, z1.imaginary);
	printf("z2 = % .1f %+.1f j\n", z2.real, z2.imaginary);

	// Print absolute, phase, and sum
	printf("\nAbsolute: |z1|    = %f\n", getComplexAbsolute(z1));
	printf("Phase   : arg(z1) = %f * PI\n", getComplexPhase(z1) / M_PI);
	printf("Sum     : z1 + z2 = %.1f %+.1f j\n", sum.real, sum.imaginary);

	getchar();
	return 0;
}

/* Get absolute value of a complex number */
double getComplexAbsolute(struct complexNumber z)
{
	return sqrt(z.real * z.real + z.imaginary * z.imaginary);
}

/* Get phase in [0, 2 * pi] of a complex number */
double getComplexPhase(struct complexNumber z)
{
	double phase = ((z.real != 0.0) || (z.imaginary != 0.0)) ? atan2(z.imaginary, z.real) : 0.0;

	return (phase >= 0.0) ? phase : phase + 2.0 * M_PI;
}

/* Get the sum of two complex numbers */
struct complexNumber addComplex(struct complexNumber a, struct complexNumber b)
{
	struct complexNumber z = { a.real + b.real, a.imaginary + b.imaginary };

	return z;
}