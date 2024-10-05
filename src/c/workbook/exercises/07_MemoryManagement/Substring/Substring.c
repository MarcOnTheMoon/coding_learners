/*****************************************************************************************************
 * Sample solution
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.08.10
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdlib.h>

/* Get string length including terminating character '\0' */
int stringLength(const char* string)
{
	int length = 0;

	while (string[length++] != '\0')
		continue;

	return length;
}

/* Get substring from first index to last indices, included */
char* substring(const char* string, int first, int last)
{
	char* substring;
	int length = stringLength(string);
	int subLength = last - first + 2;							// Include '\0' at substring end

	// Verify parameters
	if ((first > last) || (first < 0) || (last >= length - 1))	// Exclude '\0' of original string
		return NULL;

	// Allocate memory for clone
	substring = (char*)malloc(subLength * sizeof(char));

	// Copy substring contents
	if (substring != NULL)
	{
		for (int i = first; i <= last; i++)
			substring[i - first] = string[i];
		substring[subLength - 1] = '\0';
	}

	return substring;
}
