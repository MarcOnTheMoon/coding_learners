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

#include <math.h>

/* External variable: Math constant pi */
const double PI = 3.14159265358979323846;

/* External function: Transform 2-D Cartesian to polar coordinates */
void toPolarCoords(double x, double y, double *r, double *phi)
{
	*r = sqrt(x * x + y * y);
	*phi = atan2(y, x);
}
