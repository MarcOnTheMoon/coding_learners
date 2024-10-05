/*****************************************************************************************************
 * Lecture sample code.
 * Find a substring within a string.
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
	char word[256];
	char quote[] = "Life is what happens while you are busy making other plans.";
	int size = sizeof quote / sizeof(char);
	int subID = -1;		// Index of substring in string

	/* Get user input */
	printf("\"%s\"\n ", quote);
	for (int i = 0; i < size - 1; i++)
		printf("%d", i % 10);

	printf("\n\nEnter word to search for: ");
	scanf("%s", word);
	while (getchar() != '\n')
		continue;

	/* Search for substring */
	for (int i = 0; i < size; i++)
	{
		// Found first character of substring
		if ((subID < 0) && (quote[i] == word[0]))
			subID = i;

		// Compare character of substring to string
		if (subID >= 0)
		{
			// End of word reached => Substring found
			if (word[i - subID] == '\0')
				break;

			// Different characters
			else if (quote[i] != word[i - subID])
			{
				i = subID;
				subID = -1;
			}
		}
	}

	/* Print result to the console */
	if (subID >= 0)
		printf("The string contains \"%s\" at index %d.\n", word, subID);
	else
		printf("The string does not contain the substring \"%s\" (case-sensitive comparison).\n", word);

	getchar();
	return 0;
}
