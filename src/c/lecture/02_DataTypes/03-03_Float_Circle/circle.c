/*****************************************************************************************************
 * Lecture sample code.
 * Arithmetic operations for and formatted printing of floating point numbers.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	float radius = 1.5, pi = 3.141592;

	printf("Radius       : %.2f units\n", radius);
	printf("Circumference: %.2f units\n", 2.0 * pi * radius);
	printf("Area         : %.2f units^2\n", pi * radius * radius);
	getchar();
	return 0;
}
