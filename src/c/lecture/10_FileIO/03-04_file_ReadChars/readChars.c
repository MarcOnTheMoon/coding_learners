/*****************************************************************************************************
 * Lecture sample code.
 * Read and print a text file using single characters.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>

#define FILE_NAME "sampleFile.txt"

int main(void)
{
	FILE *file;
	char character;

	/* Write text file */
	if ((file = fopen(FILE_NAME, "w")) == NULL)
		exit(EXIT_FAILURE);

	fputs("HAW Hamburg\nBerliner Tor 7\n20099 Hamburg\n", file);
	fclose(file);

	/* Read and print text file */
	if ((file = fopen(FILE_NAME, "r")) == NULL)
		exit(EXIT_FAILURE);

	while ((character = getc(file)) != EOF)
		putchar(character);
	fclose(file);

	getchar();
	return 0;
}
