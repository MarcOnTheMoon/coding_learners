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

#ifndef MY_MATH_H_
#define MY_MATH_H_

const static char letterA = 'A';

/* Constants */
#define MATH_PI 3.14159265358979323846
extern const double MATH_E;

/* Function prototypes */
extern double degreeToRad(double degree);
extern double radToDegree(double rad);

#endif
