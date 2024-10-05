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
int scanBinaryInteger(void);

/* Main function */
int main(void)
{
	// Get and convert user input
	int decimal = scanBinaryInteger();

	// Print result to console
	if (decimal >= 0)
		printf("Decimal: %d\n", decimal);
	else
		printf("Invalid input: Use '0' and '1', only.\n");

	getchar();
	return 0;
}

/* Read bit pattern of integer from keyboard.
*
* @return integer value represented by entered bit pattern (or -1)
*/
int scanBinaryInteger(void)
{
	char bit;
	int decimal = 0;

	printf("Enter binary pattern: ");
	while ((bit = getchar()) != '\n')
	{
		if (bit == '1')
			decimal = 2 * decimal + 1;
		else if (bit == '0')
			decimal *= 2;
		else
		{
			// Clear input buffer and return error code -1
			while (getchar() != '\n')
				continue;
			return -1;
		}
	}
	return decimal;
}
