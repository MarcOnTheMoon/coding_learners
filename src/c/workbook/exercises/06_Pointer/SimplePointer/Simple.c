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
	int value = 0;
	int *address = &value;

	// Increment and print value not using pointer
	printf("value   : %d\n", value);
	printf("value++ : %d\n", ++value);

	// Increment and print value using pointer
	printf("\nPointer access, only:\n");
	printf("Access value : %d\n", *address);
	*address += 1;
	printf("Add value 1  : %d\n", *address);
	printf("Increment    : %d\n", ++(*address));

	return 0;
}
