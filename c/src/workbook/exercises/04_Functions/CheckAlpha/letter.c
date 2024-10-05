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

/* Prototypes */
int isLetter(char character);

/* Main function */
int main(void)
{
	char input;

	// Get user input: single character
	printf("Please enter a single character: ");
	scanf("%c", &input);
	getchar();

	// Determine and print whether the character is a letter or not
	if (isLetter(input))
		printf("Character '%c' is a letter.\n", input);
	else
		printf("Character '%c' is not a letter.\n", input);

	getchar();
	return 0;
}

/* Determine whether character is a letter (ignoring case).
*
* @param character Character to check
* @return 1 (true) if character is a letter, else 0 (false)
*/
int isLetter(char character)
{
	return ((character >= 'a') && (character <= 'z')) || ((character >= 'A') && (character <= 'Z'));
}
