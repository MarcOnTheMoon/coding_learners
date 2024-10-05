/*****************************************************************************************************
 * Lecture sample code.
 * Demonstrate dynamic memory allocation using malloc(), calloc(), and free().
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int *a = (int *)malloc(2 * sizeof(int));
	int *b = (int *)calloc(2, sizeof(int));

	/* Verify memory has successfully been allocated */
	if ((a == NULL) || (b == NULL))
		exit(EXIT_FAILURE);

	/* Modify and/or print allocated data */
	a[0] = 9;
	printf("a = (%d, %d)\n", *a, *(a + 1));
	printf("b = (%d, %d)\n", b[0], b[1]);

	/* Free allocated memory */
	free(a);
	free(b);

	getchar();
	return 0;
}
