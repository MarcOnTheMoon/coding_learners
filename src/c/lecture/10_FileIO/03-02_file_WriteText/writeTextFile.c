/*****************************************************************************************************
 * Lecture sample code.
 * Write to a text file.
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

int main(void)
{
	const char *fileName = "sampleFile.txt";
	FILE *file = fopen(fileName, "w");

	if (file != NULL)
	{
		printf("Writing data to file \"%s\" ...\n", fileName);

		// Write data to the file
		fputc('W', file);
		fprintf(file, "eather forecast: %.1f C and sunny.\n", 21.233);
		fputs("Go out and have some fresh air.\n", file);

		// Close file
		printf("Closing file ...\n");
		fclose(file);
	}
	else
		printf("Could not open file: \"%s\"\n", fileName);

	getchar();
	return 0;
}
