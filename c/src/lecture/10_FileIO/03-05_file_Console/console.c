/*****************************************************************************************************
 * Lecture sample code.
 * Function printing same text to either a file or the console.
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

/* Function prototypes */
void printAddress(FILE *);

/* Main function */
int main(void)
{
	FILE *file;

	/* Write address to file */
	if ((file = fopen("sampleFile.txt", "w")) != NULL)
	{
		printAddress(file);
		fclose(file);
	}

	/* Write address to the console */
	printAddress(stdout);

	getchar();
	return 0;
}

/* Print address */
void printAddress(FILE *file)
{
	fputs("HAW Hamburg\nBerliner Tor 7\n20099 Hamburg\n", file);
}

