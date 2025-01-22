/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2025.01.22
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

/* Prototypes */
int throwDice();

/* Main function */
int main(void)
{
	const int NUMBER_THROWS = 100;
	int sum = 0;

	// Init random number generator
	srand(time(NULL));

	// Throw dice NUMBER_THROWS times
	printf("Throws:\n");
	for (int i = 0; i < NUMBER_THROWS; i++)
	{
		// Random value
		int number = throwDice();
		sum += number;
		printf("%d ", number);

		// Line break every 50 values
		if (i % 25 == 24)
			putchar('\n');
	}

	// Print mean dice value to the console
	printf("Average: %.1f\n", sum / (double)NUMBER_THROWS);

	getchar();
	return 0;
}

/* Get random number in 1 .. 6 (dice).
*
* The random number generator must be initialized by srand(time(NULL));
* before calling this function.
*
* @return random number in 1 to 6
*/
int throwDice()
{
	return rand() % 6 + 1;
}
