/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>

/* Function prototypes (provided by examiner) */
void clearKeyboardBuffer();
int arraySum(const int data[], int size);

/* Main function (provided by examiner) */
int main(void)
{
	int a[3];

	// Get user input
	printf("Enter three integers formatted x,y,z: ");
	while (scanf("%d,%d,%d", a, a + 1, a + 2) != 3)
	{
		clearKeyboardBuffer();
		printf("Invalid input. Retry: ");
	}
	clearKeyboardBuffer();

	// Calculate and print array sum
	printf("Sum = %d\n", arraySum(a, sizeof a / sizeof(int)));

	getchar();
	return 0;
}

/* Remove all characters from the keyboard buffer */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}

/* Calculate sum of array elements */
int arraySum(const int data[], int size)
{
	if (size > 0)
		return data[0] + arraySum(data + 1, size - 1);
	else
		return 0;
}
