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

/* Defines */
#define NUMBER_THROWS 1000000

/* Prototypes */
int throwDice();

/* Main function */
int main(void)
{
	int diceCount[6] = { 0 };
	int count = 0;

	// Init random number generator
	srand(time(NULL));

	// Throw dice NUMBER_THROWS times and count results
	for (int i = 0; i < NUMBER_THROWS; i++)
	{
		diceCount[throwDice() - 1]++;
		count++;
	}

	// Print results to the console
	printf("Number dice throws: %.1e\n", (double)NUMBER_THROWS);

	printf("Relative frequencies:\n");
	for (int i = 0; i < 6; i++)
		printf("Result = %d: %5.2f %%\n", i + 1, 100.0 * diceCount[i] / (double)count);

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
