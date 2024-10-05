/*****************************************************************************************************
 * Lecture sample code.
 * Function "returning" two values using references to variables.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.12.205
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _USE_MATH_DEFINES			// Enable math constants like pi in math.h
#include <stdio.h>
#include <math.h>

void toPolarCoords(double x, double y, double *r, double *phi);

int main(void)
{
	double x = 2.0, y = 3.75;		// Input: Cartesian coordinates
	double r, phi;					// Result: Polar coordinates

	toPolarCoords(x, y, &r, &phi);
	printf("Cartesian: (x, y)   = (%.2f, %.2f)\n", x, y);
	printf("Polar    : (r, phi) = (%.2f, %.2f * pi)\n", r, phi / M_PI);

	getchar();
	return 0;
}

// Transform 2-D Cartesian to polar coordinates
void toPolarCoords(double x, double y, double *r, double *phi)
{
	*r = sqrt(x * x + y * y);
	*phi = atan2(y, x);
}
