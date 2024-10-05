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
#include <stdio.h>

/* Main function */
int main(void)
{
	unsigned value = 0;
	unsigned *uintPointer = &value;
	char *charPointer = (char*)(&value);

	// Print pointers
	printf("Address (unsigned*): %p\n", uintPointer);
	printf("Address (char*)    : %p\n\n", charPointer);

	// Modify one byte after the other and print value
	for (int byte = 0; byte < sizeof(unsigned); byte++)
	{
		*(charPointer + byte) = (char)1;
		printf("Set byte %d at address %p to 1: %u\n", byte + 1, charPointer + byte, value);
		value = 0;
	}

	return 0;
}
