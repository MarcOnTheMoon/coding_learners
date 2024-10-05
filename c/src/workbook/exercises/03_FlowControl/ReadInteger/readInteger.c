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
#define _CRT_SECURE_NO_DEPRECATE
#include <stdio.h>

/* Main function */
int main(void)
{
	int number = 0;

	// Promt user to enter integer
	printf("Please enter an integer number: ");

	// Read number character by character
	while (1)
	{
		// Read character
		char input;
		scanf("%c", &input);

		// Prozess valid input or end loop
		if ((input >= '0') && (input <= '9'))
			number = 10 * number + (input - '0');
		else
			break;
	}

	// Print decimal result:
	printf("Number scanned   : %d\n", number);
	printf("Twice that number: %d\n", 2 * number);

	getchar();
	return 0;
}
