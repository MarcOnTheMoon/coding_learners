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
	char charArray[] = { 0, 0 };
	int intArray[] = { 0, 0 };

	// Determine size of char
	printf("Address of char[0]: %p\n", charArray);
	printf("Address of char[1]: %p\n", charArray + 1);
	printf("Size of char in memory: %lu bytes (8 bits each)\n", (unsigned long)(charArray + 1) - (unsigned long)charArray);

	// Determine size of unsigned int
	printf("\nAddress of int[0]: %p\n", intArray);
	printf("Address of int[1]: %p\n", intArray + 1);
	printf("Size of int in memory: %lu bytes (8 bits each)\n", (unsigned long)(intArray + 1) - (unsigned long)intArray);

	return 0;
}
