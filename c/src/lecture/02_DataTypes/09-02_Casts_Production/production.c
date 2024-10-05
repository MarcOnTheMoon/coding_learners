/*****************************************************************************************************
 * Lecture sample code.
 * Avoid integer division by cast operator.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using scanf() (concern: buffer overflow)
#include <stdio.h>

int main(void)
{
	int goodParts, badParts;
	double badRatio;

	/* Get user input */
	printf("Enter number of good parts produced: ");
	scanf("%d", &goodParts);
	getchar();

	printf("Enter number of bad parts produced : ");
	scanf("%d", &badParts);
	getchar();

	/* Calculate and print production performance */
	badRatio = badParts / (double)(goodParts + badParts);
	printf("\nBad parts: %d out of %d (ratio %.2f)\n", badParts, goodParts + badParts, badRatio);

	getchar();
	return 0;
}
