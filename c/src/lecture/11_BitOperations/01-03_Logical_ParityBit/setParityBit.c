/*****************************************************************************************************
 * Lecture sample code.
 * Set high-order bit (MSB) as parity bit in 8-bit byte.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>

/* Function prototypes */
unsigned char addParityMSB(unsigned char);
void printLowByteBinary(int a);

/* Main function */
int main(void)
{
	unsigned char input, parity;

	printf("Enter number (q to quit): ");
	while (scanf("%hhu", &input) == 1)
	{
		// Print number as binary
		printf("Lowest byte: ");
		printLowByteBinary(input);

		// Add parity bit (MSB) and print as binary
		parity = addParityMSB(input);
		printf("\nWith parity: ");
		printLowByteBinary(parity);
		printf("\nNext number (q to quit): ");

		// Clear keyboard buffer
		while (getchar() != '\n')
			continue;
	}

	getchar();
	return 0;
}

/* Set MSB as parity bit (making number of 1's in bit pattern even) */
unsigned char addParityMSB(unsigned char a)
{
	int count = 0;
	unsigned char mask = 1;
	unsigned char maskMSB = 128;

	/* Count number of 1's in lowest 7 bits of bit pattern */
	for (int i = 0; i < 7; i++, mask *= 2)
		count += ((a & mask) == mask);

	/* Set MSB to either 1 (count odd) or 0 (count even) */
	if ((count % 2) == 0)
		a &= ~maskMSB;		// Clear MSB to 0
	else
		a |= maskMSB;		// Set MSB to 1

	return a;
}

/* Print lowest byte as binary number to the console */
void printLowByteBinary(int a)
{
	char string[9];
	unsigned char mask = 1;

	/* Create string with binary representation */
	for (int i = 7; i >= 0; i--, mask *= 2)
		string[i] = ((a & mask) == mask) ? '1' : '0';
	string[8] = '\0';

	/* Print to the console*/
	printf("%s", string);
}
