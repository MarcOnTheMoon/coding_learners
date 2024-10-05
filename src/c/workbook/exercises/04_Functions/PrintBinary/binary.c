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
void printBinary(unsigned decimal);

/* Main function */
int main(void)
{
	unsigned decimal;

	// Get user input
	printf("Please enter a non-negative integer: ");
	scanf("%u", &decimal);
	getchar();

	// Print bit pattern
	printBinary(decimal);

	getchar();
	return 0;
}

/* Print binray pattern of a non-negative number to the console.
*
* @param decimal Number to print binary pattern for
*/
void printBinary(unsigned decimal)
{
	// Initialize with 16 bit 00...0
	printf("Binary: %016d ", 0);

	// Move left bit by bit
	while (decimal > 0) {
		int digit = decimal % 2;
		decimal /= 2;
		printf("\b\b%d", digit);
	}
	printf("\n");
}
