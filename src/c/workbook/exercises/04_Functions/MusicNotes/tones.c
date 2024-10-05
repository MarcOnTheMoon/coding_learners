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
double tone2FrequencyHz(char tone, int octave);

/* Main function */
int main(void)
{
	// Print frequency table for notes
	printf("Frequencies of musical notes in Hz:\n\n");
	printf("   |     0    |     1    |     2    |     3    |     4    |     5\n");
	printf("---+----------+----------+----------+----------+----------+----------\n");

	for (int i = 0; i < 7; i++)
	{
		char tone = 'A' + (i + 'C' - 'A') % 7;			// Order: C, D, E, F, G, A, B

		printf(" %c", tone);
		for (int octave = 0; octave <= 5; octave++)
			printf(" | %8.4f", tone2FrequencyHz(tone, octave));
		putchar('\n');
	}

	getchar();
	return 0;
}

/* Get frequency for a specific tone (like a music note).
*
* @param tone Tone in A, B (or H), C, ..., G (case-insensitive)
* @param octave Octave in 0, 1, 2, ...
* @return frequency in Herz
*/
double tone2FrequencyHz(char tone, int octave)
{
	double frequency;

	// Tonic (octave 0)
	switch (tone)
	{
	case 'c':
	case 'C':
		frequency = 16.3516;
		break;
	case 'd':
	case 'D':
		frequency = 18.3540;
		break;
	case 'e':
	case 'E':
		frequency = 20.6017;
		break;
	case 'f':
	case 'F':
		frequency = 21.8268;
		break;
	case 'g':
	case 'G':
		frequency = 24.4997;
		break;
	case 'a':
	case 'A':
		frequency = 27.5;
		break;
	case 'b':
	case 'B':
	case 'h':
	case 'H':
		frequency = 30.8677;
		break;
	}

	// Octave
	for (int i = 0; i < octave; i++)
		frequency *= 2.0;

	return frequency;
}
