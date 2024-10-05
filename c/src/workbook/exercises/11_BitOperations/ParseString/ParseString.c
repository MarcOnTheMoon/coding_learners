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
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>

/* Defines */
#define MAX_BITS 32

/* Prototypes */
unsigned parseStringUnsigned(const char* bitPattern);

/* Main function */
int main(void)
{
	char input[MAX_BITS + 1];

	printf("Enter bit pattern (q to quit): ");
	while ((fgets(input, MAX_BITS + 1, stdin) != NULL) && (input[0] != 'q') && (input[0] != 'Q'))
	{
		printf("Numeric value: %u\n", parseStringUnsigned(input));
		printf("Enter bit pattern (q to quit): ");
	}
	printf("Bye!\n");

	getchar();
	return 0;
}

/* Parse string representing bit pattern for corresponding unsigned integer */
unsigned parseStringUnsigned(const char* bitPattern)
{
	unsigned numeric = 0;

	for (int i = 0; i < MAX_BITS; i++)
	{
		if (bitPattern[i] == '0')
			numeric <<= 1;
		else if (bitPattern[i] == '1')
			numeric = (numeric << 1) + 1;
		else
			break;
	}

	return numeric;
}
