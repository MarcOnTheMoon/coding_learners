/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate definition of characters by character and numerical code.
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
	char capitalH = 'H', newLine = '\n';	// Characters in single quotes
	char smallM = 109;						// ASCII code for letter 'm'

	printf("%cAW %ca%cburg%c", capitalH, capitalH, smallM, newLine);
	getchar();
	return 0;
}
