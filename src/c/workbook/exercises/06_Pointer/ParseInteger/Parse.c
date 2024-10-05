/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

/* Defines */
#define SIZE 64

/* Prototypes */
int toInteger(const char*);

/* Main function */
int main(void)
{
	char input[SIZE];

	// Get keyboard input and convert to int
	printf("Enter a non-negative integer x: ");
	if (scanf("%s", input) == 1)
		printf("x + 1 = %d", toInteger(input) + 1);

	// Empty keyboard buffer
	while (getchar() != '\n')
		continue;

	getchar();
	return 0;
}

/* Parse string for integer */
int toInteger(const char* string)
{
	int value = 0, i = 0;

	while ((string[i] >= '0') && (string[i] <= '9'))
		value = 10 * value + (int)(string[i++] - '0');

	return value;
}
