package exercises._03_classes.c_static;

import java.util.Locale;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MusicNotesApp {
	public static void main(String[] args) {
		// Print frequency table for notes
		System.out.println("Frequencies of musical notes in Hz:\n");
		System.out.println("   |     0    |     1    |     2    |     3    |     4    |     5");
		System.out.println("---+----------+----------+----------+----------+----------+----------");

		for (int i = 0; i < 7; i++)
		{
			char tone = (char)('A' + (i + 'C' - 'A') % 7);			// Order: C, D, E, F, G, A, B

			System.out.printf(" %c", tone);
			for (int octave = 0; octave <= 5; octave++) {
				double frequencyHz = MusicNotes.tone2FrequencyHz(tone, octave);
				System.out.printf(Locale.US, " | %8.4f", frequencyHz);
			}
			System.out.println();
		}
	}
}
