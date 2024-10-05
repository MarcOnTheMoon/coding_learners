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
extern int** createRandomMatrix(int rows, int columns, int min, int max);

/* Main function */
int main(void)
{
	int** randomMatrix;
	int rows, columns, min, max;

	// Get user input
	printf("Enter matrix size and data range (with spaces: \"rows columns min max\"): ");
	if (scanf("%d %d %d %d", &rows, &columns, &min, &max) == 4)
	{
		clearKeyboardBuffer();

		// Create and display random matrix
		randomMatrix = createRandomMatrix(rows, columns, min, max);
		if (randomMatrix != NULL)
		{
			// Print matrix values
			for (int y = 0; y < rows; y++)
			{
				for (int x = 0; x < columns; x++)
					printf("%3d ", randomMatrix[y][x]);
				putchar('\n');
			}

			// Free memory
			free(randomMatrix);
		}
		else
			printf("Could not create matrix.\n");
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