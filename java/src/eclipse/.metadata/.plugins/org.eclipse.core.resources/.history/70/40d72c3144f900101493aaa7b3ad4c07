package exercises._09_io.b_audio;

/** Class related to notes used in music.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MusicNotes {
	
	/** Get frequency of a note.
	 * 
	 * @param tone Tone in {C, D, E, F, G, H, A, B} (case-insensitive) 
	 * @param octave Octave in {0, 1, ...}
	 * @return note's frequency in Hz
	 */
	static double tone2FrequencyHz(char tone, int octave) {
		double frequency = switch (tone) {
			case 'c', 'C' -> 16.3516;
			case 'd', 'D' -> 18.3540;
			case 'e', 'E' -> 20.6017;
			case 'f', 'F' -> 21.8268;
			case 'g', 'G' -> 24.4997;
			case 'a', 'A' -> 27.5;
			case 'b', 'B', 'h', 'H' -> 30.8677;
			default -> 0.0;

			// Tonic (octave 0)
		};

		// Octave
		for (int i = 0; i < octave; i++)
			frequency *= 2.0;

		return frequency;
	}
}
