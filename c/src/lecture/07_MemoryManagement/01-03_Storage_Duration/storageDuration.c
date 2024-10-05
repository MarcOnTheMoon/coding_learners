/*****************************************************************************************************
 * Lecture sample code.
 * Storage duration of file scope (max) and block scope (input) variables.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int max = 0;								// Exists in memory throughout program

int main(void)
{
	/* Enter integer numbers > 0 and store maximum value entered */
	printf("Enter positive integer numbers (q to quit):\n");
	while (1)
	{
		int input;							// Allocated in memory in each iteration, memory freed when reaching brace }
		if (scanf("%d", &input) == 1)
			max = (max > input) ? max : input;
		else
			break;
	}

	/* Clear keyboard buffer */
	while (getchar() != '\n')
		continue;

	/* Print result to the console */
	printf("Maximum number entered: %d\n", max);

	getchar();
	return 0;
}
