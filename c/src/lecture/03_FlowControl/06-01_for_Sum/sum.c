/*****************************************************************************************************
 * Lecture sample code.
 * Sum up all number from 1 to 100 using a for-loop.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>

int main(void)
{
	int sum = 0;

	/* Sum up numbers */
	for (int i = 1; i <= 100; i++)
		sum += i;

	/* Print result to the console */
	printf("Sum of 1 to 100: %d\n", sum);

	getchar();
	return 0;
}
