/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate external variables and functions.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

/* Declare external variable and function to use */
extern const double PI;
extern void toPolarCoords(double x, double y, double *r, double *phi);

int main(void)
{
	double x = 2.0, y = 3.75;		// Input: Cartesian coordinates
	double r, phi;					// Result: Polar coordinates

	toPolarCoords(x, y, &r, &phi);
	printf("Cartesian: (x, y)   = (%.2f, %.2f)\n", x, y);
	printf("Polar    : (r, phi) = (%.2f, %.2f * pi)\n", r, phi / PI);

	getchar();
	return 0;
}
