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
#include <stdio.h>

/* Prototypes */
void stringAnalysis(const char* text, int* vocalCount, int* consonantCount, int* digitCount);

/* Main function */
int main(void)
{
	char text[] = "1, 2 oder 3 - du musst dich entscheiden, drei Felder sind frei!";
	int vocalCount, consonantCount, digitCount;

	// Analyse string
	stringAnalysis(text, &vocalCount, &consonantCount, &digitCount);

	// Print results
	printf("String     : \"%s\"\n", text);
	printf("Vocals     : %d\n", vocalCount);
	printf("Consonants : %d\n", consonantCount);
	printf("Digits     : %d\n", digitCount);

	return 0;
}

/* Analyse string for vocals, consonants, and digits.
* 
* @param text [in] String to analyse
* @param vocalCount [out] Number of vocals in text
* @param consonantCount [out] Number of consonants in text
* @param digitCount [out] Number of digits in text
*/
void stringAnalysis(const char* text, int* vocalCount, int* consonantCount, int* digitCount)
{
	// Initialize counters
	*vocalCount = *consonantCount = *digitCount = 0;

	// Run through string
	while (*text != '\0')
	{
		// Analyse character
		char character = *text;
		int isSmallLetter = (character >= 'a') && (character <= 'z');
		int isCapitalLetter = (character >= 'A') && (character <= 'Z');

		if (isSmallLetter || isCapitalLetter)
		{
			// Capital to small letter
			if (isCapitalLetter)
				character += 'a' - 'A';

			// Vocal or consonant
			if ((character == 'a') || (character == 'e') || (character == 'i') || (character == 'o') || (character == 'u'))
				(*vocalCount)++;
			else
				(*consonantCount)++;
		}
		else if ((character >= '0') && (character <= '9'))
			(*digitCount)++;

		// Next character
		text++;
	}
}
