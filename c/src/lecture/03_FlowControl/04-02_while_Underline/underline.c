/*****************************************************************************************************
 * Lecture sample code.
 * Underline text using a while-loop.
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
	int numberChars = printf("Please give me a floor to stand upon.\n");

	while (numberChars > 1)		/* Do not underline '\n' */
	{
		printf("-");
		numberChars--;
	}

	getchar();
	return 0;
}
