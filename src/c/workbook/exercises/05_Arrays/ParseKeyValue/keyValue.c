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
#define BUFFER_SIZE 256

/* Main function */
int main(void)
{
	char input[BUFFER_SIZE];
	char key[BUFFER_SIZE] = { '\0' };			// Empty string
	char value[BUFFER_SIZE] = { '\0' };
	int id = 0, equalsID = -1, endID = -1;

	// Get user input and identify separator '='
	printf("Enter key and value (formatted \"key=value\"): ");
	while ((input[id] = getchar()) != '\n')
	{
		// Found separator (first '=')
		if ((equalsID == -1) && (input[id] == '='))
			equalsID = id;

		id++;
	}
	input[id] = '\0';
	endID = id;

	// Extract key and value
	for (int i = 0; i < equalsID; i++)
		key[i] = input[i];
	key[equalsID] = '\0';

	for (int i = equalsID + 1; i <= endID; i++)
		value[i - (equalsID + 1)] = input[i];

	// Print key and value to the console
	printf("Key   : %s\n", key);
	printf("Value : %s\n", value);

	getchar();
	return 0;
}
