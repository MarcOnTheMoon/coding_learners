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
#include <stdlib.h>

/* Prototypes */
void clearKeyboardBuffer();
extern int* createRandomArray(int size, int min, int max);

/* Main function */
int main(void)
{
	int* randomArray;
	int size, min, max;

	// Get user input
	printf("Enter array size and data range (with spaces: \"size min max\"): ");
	if (scanf("%d %d %d", &size, &min, &max) == 3)
	{
		clearKeyboardBuffer();

		// Create and display random array
		randomArray = createRandomArray(size, min, max);
		if (randomArray != NULL)
		{
			// Print array values
			for (int i = 0; i < size; i++)
				printf("%d, ", randomArray[i]);
			printf("\b\b \n");

			// Free memory
			free(randomArray);
		}
		else
			printf("Could not create array.\n");
	}
	else
	{
		clearKeyboardBuffer();
		printf("Could not read size and data range.\n");
	}

	getchar();
	return 0;
}

/* Remove characters from keyboard buffer until next \n included */
void clearKeyboardBuffer()
{
	while (getchar() != '\n')
		continue;
}
