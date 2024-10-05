/*****************************************************************************************************
 * Lecture sample code.
 * Calculate circumference and area of a circle, only if the radius is non-negative.
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
	float radius;
	const float PI = 3.141592f;

	/* Get user input: radius */
	printf("Please enter a radius: ");
	scanf("%f", &radius);
	getchar();

	/* Print area and circumference to the console */
	if (radius >= 0.0)
	{
		printf("\nRadius       : %.2f units\n", radius);
		printf("Circumference: %.2f units\n", 2.0 * PI * radius);
		printf("Area         : %.2f units^2\n", PI * radius * radius);
	}
	else
		printf("\nThere is no circle with negative radius.");

	getchar();
	return 0;
}
