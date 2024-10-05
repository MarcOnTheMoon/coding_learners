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
	int sum, number, maximumNumber = 100;

	// Sum using for-loop
	sum = 0;
	for (int i = 1; i <= maximumNumber; i++)
		sum += i;
	printf("Sum using for-loop     : %d\n", sum);

	// Sum using while-loop
	sum = 0;
	number = 1;
	while (number <= maximumNumber)
		sum += number++;
	printf("Sum using while-loop   : %d\n", sum);

	// Sum using do/while-loop
	sum = 0;
	number = 1;
	do
		sum += number++;
	while (number <= maximumNumber);
	printf("Sum using do/while-loop: %d\n", sum);

	getchar();
	return 0;
}
