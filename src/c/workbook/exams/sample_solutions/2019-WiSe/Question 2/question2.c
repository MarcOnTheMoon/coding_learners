/*****************************************************************************************************
 * Sample solution for lab exam.
 *****************************************************************************************************
 * Author: Marc Hensel, http://www.haw-hamburg.de/marc-hensel
 * Project: https://github.com/MarcOnTheMoon/coding_learners_c/
 * Copyright: 2023, Marc Hensel
 * Version: 2023.09.20
 * License: CC BY-NC-SA 4.0, see https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 *****************************************************************************************************/

/* Include files */
#define _CRT_SECURE_NO_DEPRECATE	// Else MSVC++ prevents using functions with potential buffer overflow
#include <stdio.h>
#include <stdlib.h>		// malloc(), free()
#include <string.h>

/* Type definitions */
typedef struct
{
	int characters;
	int words;
	int sentences;
	int syllables;
	double readability;		// Score in [0, 100]
} properties;

/* Function prototypes (provided by examiner) */
void printTextProperties(properties);
int getCharacterCount(const char *text, char character);
int getNumberOfWords(const char *text);
int getNumberOfSentences(const char *text);
int getNumberOfSyllablesInWord(const char *word);
int getNumberOfSyllables(const char *text);
properties getTextProperties(const char *text);

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

/* Count occurances of a specific character in a string */
int getCharacterCount(const char *text, char character)
{
	int count = 0;
	int index = 0;

	while (text[index] != '\0')
		count += (text[index++] == character);

	return count;
}

/* Determine the number of words in a string */
int getNumberOfWords(const char *text)
{
	return getCharacterCount(text, ' ') + 1;
}

/* Determine the number of sentences in a string */
int getNumberOfSentences(const char *text)
{
	return getCharacterCount(text, '.') + getCharacterCount(text, ';') + getCharacterCount(text, '!') + getCharacterCount(text, '?');
}

/* Estimate the number of syllables in a word */
int getNumberOfSyllablesInWord(const char *word)
{
	int length = (int)strlen(word);

	// Short word: 1 syllable
	if (length <= 3)
		return 1;

	// Count vowels (not excluding double vowels)
	return getCharacterCount(word, 'a') + getCharacterCount(word, 'A')
		+ getCharacterCount(word, 'e') + getCharacterCount(word, 'E')
		+ getCharacterCount(word, 'i') + getCharacterCount(word, 'I')
		+ getCharacterCount(word, 'o') + getCharacterCount(word, 'O')
		+ getCharacterCount(word, 'u') + getCharacterCount(word, 'U');
}

/* Estimate the number of syllables in a string */
int getNumberOfSyllables(const char *text)
{
	int count = 0;
	int length = (int)strlen(text);
	char *copy, *word;

	// Create copy of text (as strtok will modify string)
	copy = (char*)malloc((length + 1) * sizeof(char));
	if (copy == NULL)
		exit(EXIT_FAILURE);
	strcpy(copy, text);

	// Split string into words and count syllables
	word = strtok(copy, " ");
	while (word != NULL)
	{
		count += getNumberOfSyllablesInWord(word);
		word = strtok(NULL, " ");
	}

	// Clean up
	free(copy);

	return count;
}

/* Determine properties of a text */
properties getTextProperties(const char * text)
{
	properties result;

	result.characters = (int)strlen(text);
	result.words = getNumberOfWords(text);
	result.sentences = getNumberOfSentences(text);
	result.syllables = getNumberOfSyllables(text);
	result.readability = 206.835 - 1.015 * result.words / (double)result.sentences - 84.6 * result.syllables / (double)result.words;

	return result;
}
