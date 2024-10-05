/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 *
 * Student name : <surname>, <first name>
 * Student ID   : <id>
 *
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE
#define _USE_MATH_DEFINES

#include <stdio.h>
#include <math.h>

/* Function prototypes (provided by examiner) */
double sine(double alpha, int k);
double principalValue(double alpha);
void getUserInputSine(double* x, int* k);
void clearKeyboardBuffer(void);

/* Main function */
int main(void)
{
	while (1) {
		double x, alpha;
		int maxK;
		char keyPressed;

		// Get user input
		getUserInputSine(&x, &maxK);
		alpha = x * M_PI;

		// Calculate and print approximations of sin(x * PI)
		printf("Approximations of sin(%.2f * pi):\n", x);
		for (int k = 1; k <= maxK; k++) {
			printf("  k = %2d: sin(x * PI) = %f\n", k, sine(alpha, k));
		}
		printf("Principal value: %.2f * pi\n", principalValue(alpha) / M_PI);

		// User input to quit or continue
		printf("Enter <q> to quit, any other key to continue.\n");
		keyPressed = getchar();
		clearKeyboardBuffer();

		if ((keyPressed == 'q') || (keyPressed == 'Q'))
			break;
	}

	return 0;
}

/*! Approximate mathematical sin(alpha) by series expansion.
*
* @param alpha Function argument alpha [rad]
* @param k Number of terms in series expansion
*
* @return approximated value sin(alpha)
*/
double sine(double alpha, int k) {
	double sinX = alpha;
	double factor = (alpha * alpha) / (M_PI * M_PI);

	for (int i = 1; i <= k; i++)
		sinX *= (1.0 - factor / ((double)i * i));

	return sinX;
}

/*! Returns the principal value in [0, 2*pi) for a given angle.
*/
double principalValue(double alpha) {
	const double PI_2 = 2 * M_PI;

	while (alpha >= PI_2) {
		alpha -= PI_2;
	}
	while (alpha < 0.0) {
		alpha += PI_2;
	}

	return alpha;
}

void getUserInputSine(double* x, int* k) {
	printf("Series expansion for sin(x * PI) with k > 0 terms.\nPlease enter <x>,<k>: ");

	while (1) {
		int count = scanf("%lf,%d", x, k);
		clearKeyboardBuffer();

		if ((count == 2) && (*k >= 1))
			return;
		else
			printf("Invalid input. Retry: ");
	}
}

/*! Remove all characters from keyboard buffer until next ENTER key ('\n') included.
*/
void clearKeyboardBuffer(void) {
	while (getchar() != '\n')
		/* NOP */;
}
