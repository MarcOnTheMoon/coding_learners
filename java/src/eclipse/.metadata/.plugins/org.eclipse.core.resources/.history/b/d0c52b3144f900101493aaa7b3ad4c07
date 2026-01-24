package exercises._09_io.b_audio;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ChordApp {
	private final static int amplitude = 0x1 << 12;	// = 2^x
	private final static int samplingRateHz = 44100;
	private final static double timeSec = 4.0;

	private static final double[] frequenciesHz = {
			MusicNotes.tone2FrequencyHz('A', 4),
			MusicNotes.tone2FrequencyHz('E', 4),
			MusicNotes.tone2FrequencyHz('A', 5),
			MusicNotes.tone2FrequencyHz('C', 5)};

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) throws IOException {
		String fileName = ChordApp.class.getPackage().getName() + "/ChordApp.wav";
		
		// Create samples
		AudioData chord = new AudioData(samplingRateHz, timeSec);
		AudioData tone = new AudioData(samplingRateHz, timeSec);
		
		for (double frequency : frequenciesHz) {
			tone.setSine(amplitude, frequency);
			chord.add(tone);
		}

		// Write audio file (*.wav)
		AudioFileWAV.writeWavFile(fileName, chord);
		System.out.println("Written to file: " + fileName);
		
		// Open audio file with standard application
		Desktop.getDesktop().open(new File(fileName));
	}
}
