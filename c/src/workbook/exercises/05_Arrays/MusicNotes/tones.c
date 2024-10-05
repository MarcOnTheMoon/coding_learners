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
	double frequenciesHz[] = { 27.5, 30.8677, 16.3516, 18.3540, 20.6017, 21.8268, 24.4997 };	// Tones: A0, B0, C0, ..., G0
	double frequency;

	// Adapt tone to small letter in 'a' to 'g'
	if ((tone >= 'A') && (tone <= 'H'))
		tone += 'a' - 'A';
	if (tone == 'h')
		tone = 'b';

	// Tonic (octave 0)
	frequency = frequenciesHz[tone - 'a'];

	// Octave
	for (int i = 0; i < octave; i++)
		frequency *= 2.0;

	return frequency;
}
