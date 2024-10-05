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
	char character;

	// Get user input: year
	printf("Please enter a character: ");
	scanf("%c", &character);
	getchar();

	// Check character type and print result to the console
	if ((character >= '0') && (character <= '9'))
		printf("You have entered a digit.\n");
	else if ((character >= 'a') && (character <= 'z'))
		printf("You have entered a small letter.\n");
	else if ((character >= 'A') && (character <= 'Z'))
		printf("You have entered a capital letter.\n");
	else
		printf("You have not entered a digit or a letter.\n");

	getchar();
	return 0;
}
