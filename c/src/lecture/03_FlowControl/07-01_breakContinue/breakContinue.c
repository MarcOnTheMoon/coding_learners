/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate effect of break and continue in for-loops.
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
	/* Break */
	printf("Break (at i == 2):\n");
	for (int i = 0; i <= 4; i++)
	{
		if (i == 2)
			break;
		printf("i = %d\n", i);
	}

	/* Continue */
	printf("\nContinue (at i == 2):\n");
	for (int i = 0; i <= 4; i++)
	{
		if (i == 2)
			continue;
		printf("i = %d\n", i);
	}

	getchar();
	return 0;
}
