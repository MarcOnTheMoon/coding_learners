/*****************************************************************************************************
 * Lecture sample code.
 * Variables with different block scope.
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
	int sum = 0;							// Can use variable sum until closing brace } of main() function

	{
		const int limit = 100;				// Can use variable limit until closing brace } of nested block

		for (int i = 1; i < limit; i++)		// Can use variable i within for-loop, only (from ISO C99 on no braces required to make loop's statement a block)
			sum += i;
											// End of variable i
		printf("Sum 1 to %d: ", limit);
	}										// End of variable limit
	printf("%d\n", sum);

	getchar();
	return 0;
}											// End of variable sum
