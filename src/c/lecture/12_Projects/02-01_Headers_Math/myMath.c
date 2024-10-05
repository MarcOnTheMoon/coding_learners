/*****************************************************************************************************
 * Lecture sample code.
 * Mathematical constants and functions.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include "myMath.h"

/* Constants */
const double MATH_E = 2.718281828459045;

/* Transform degrees to radians */
double degreeToRad(double degree)
{
	return degree * MATH_PI / 180.0;
}

/* Transform radians to degrees */
double radToDegree(double rad)
{
	return rad * 180.0 / MATH_PI;
}
