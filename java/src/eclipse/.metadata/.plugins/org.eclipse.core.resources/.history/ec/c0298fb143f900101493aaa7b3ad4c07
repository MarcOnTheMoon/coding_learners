package exercises._07_gui.e_audio;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AudioModel {
	final int NUMBER_SAMPLES = 500;
	final int SAMPLING_RATE_HZ = 8000;
	int signalAmplitude = 50;
	int signalFrequencyHz = 125;
	int noiseAmplitude = 20;
	int noiseFrequencyHz = 800;
	int noisePeakIndex = 45;
	int noisePeakRadius = 10;
	Signal signal, noise, signalAndNoise, denoised;
	
	/** Initialize audio data.
	 */
	public AudioModel() {
		// Create data objects
		int maxValueDFT = AudioGUI.plotPanelHeight - 25;
		signal = new Signal(NUMBER_SAMPLES, maxValueDFT);
		noise = new Signal(NUMBER_SAMPLES, maxValueDFT);
		signalAndNoise = new Signal(NUMBER_SAMPLES, maxValueDFT);
		denoised = new Signal(NUMBER_SAMPLES, maxValueDFT);
		
		// Init data (time-domain samples and frequency-domain coefficients)
		update();		
	}
	
	public void update() {
		// Set time-domain samples (will also update frequency-domain coefficients)
		signal.setSamplesSine(signalAmplitude, signalFrequencyHz, SAMPLING_RATE_HZ);
		noise.setSamplesSine(noiseAmplitude, noiseFrequencyHz, SAMPLING_RATE_HZ);
		signalAndNoise.setSamplesSum(signal, noise);

		// Denoise by removing noise peak in frequency domain
		denoised.copy(signalAndNoise);
		denoised.applyBandRejectFilter(noisePeakIndex, noisePeakRadius);
	}
}
