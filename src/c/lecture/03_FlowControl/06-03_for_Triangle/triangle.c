/*****************************************************************************************************
 * Lecture sample code.
 * Print triangle using nested for-loops.
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
	/* Run through rows */
	for (int i = 1; i < 7; i++)
	{
		/* Run through characters within each row */
		for (int j = i; j > 0; j--)
		{
			printf("o");
		}
		printf("\n");
	}

	getchar();
	return 0;
}
