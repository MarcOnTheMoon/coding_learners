/*****************************************************************************************************
 * Lecture sample code.
 * Open and close a text file.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.23
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>

int main(void)
{
	const char *fileName = "sampleFile.txt";
	FILE *file = fopen(fileName, "w");

	if (file != NULL)
	{
		printf("File opened: \"%s\"\n", fileName);
		fclose(file);
	}
	else
		printf("Could not open file: \"%s\"\n", fileName);

	getchar();
	return 0;
}
