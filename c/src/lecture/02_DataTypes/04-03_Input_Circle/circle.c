/*****************************************************************************************************
 * Lecture sample code.
 * Read floating point numbers from the keyboard.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	float radius, pi = 3.141592;

	printf("Please enter a radius: ");
	scanf("%f", &radius);
	getchar();

	printf("\nRadius       : %.2f units\n", radius);
	printf("Circumference: %.2f units\n", 2.0 * pi * radius);
	printf("Area         : %.2f units^2\n", pi * radius * radius);
	getchar();
	return 0;
}
