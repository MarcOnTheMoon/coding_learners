/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate labels and goto-statement.
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
	printf("This is printed.\n");
	goto cleanup;							// Jump to label
	printf("This is not printed.\n");

cleanup:									// Define label
	printf("I am cleaning up.\n");

	getchar();
	return 0;
}
