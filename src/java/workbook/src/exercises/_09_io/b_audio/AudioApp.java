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
public class AudioApp {
	private static final int amplitude = 0x1 << 12;	// = 2^x
	private static final double frequencyHz = 440.0;
	private static final int samplingRateHz = 44100;
	private static final double timeSec = 4.0;

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) throws IOException {
		String fileName = "output_files/AudioApp.wav";
		
		// Create samples
		AudioData tone = new AudioData(samplingRateHz, timeSec);
		tone.setSine(amplitude, frequencyHz);

		// Write audio file (*.wav)
		AudioFileWAV.writeWavFile(fileName, tone);
		System.out.println("Written to file: " + fileName);
		
		// Open audio file with standard application
		Desktop.getDesktop().open(new File(fileName));
	}
}
