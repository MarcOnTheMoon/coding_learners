/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate using own include file.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <math.h>
#include "myMath.h"

int main(void)
{	
	printf("pi  = %.12f\n", MATH_PI);
	printf("e^2 = %.12f\n", MATH_E * MATH_E);
	printf("cos(45%c) = %.3f\n", 248, cos(degreeToRad(45.0)));

	getchar();
	return 0;
}
