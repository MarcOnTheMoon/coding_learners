/*****************************************************************************************************
 * Provided file for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.19
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#include <stdio.h>

/* Function prototypes (provided by examiner) */
void printTextProperties(properties);
int getCharacterCount(char *text, char character);
int getNumberOfWords(char *text);
int getNumberOfSentences(char *text);
int getNumberOfSyllablesInWord(char *word);
int getNumberOfSyllables(char *text);
properties getTextProperties(char *text);

/* Main function (provided by examiner) */
int main(void)
{
	// Simple test sentences
	char easy[] = "No one said; it would. be easy! AaEe IiOoUu?";

	// William Lyon Phelps: The Pleasure of Books
	char bookSpeech[] =
		"A borrowed book is like a guest in the house; it must be treated with punctiliousness, with a certain considerate formality. "
		"You must see that it sustains no damage; it must not suffer while under your roof. "
		"You cannot leave it carelessly, you cannot mark it, you cannot turn down the pages, you cannot use it familiarly. "
		"And then, some day, although this is seldom done, you really ought to return it.";

	// Determine text properties
	properties easyProperties = getTextProperties(easy);
	properties bookProperties = getTextProperties(bookSpeech);

	// Display results
	printf("\nTest string \"%s\":\n", easy);
	printTextProperties(easyProperties);

	printf("\nWilliam Lyon Phelps, The Pleasure of Books:\n");
	printTextProperties(bookProperties);

	getchar();
	return 0;
}

/* Print properties to the console (provided by examiner) */
void printTextProperties(properties textProperties)
{
	printf("Characters  : %d\n", textProperties.characters);
	printf("Words       : %d\n", textProperties.words);
	printf("Sentences   : %d\n", textProperties.sentences);
	printf("Syllables   : %d\n", textProperties.syllables);
	printf("Readability : %.1f out of 100\n", textProperties.readability);
}
