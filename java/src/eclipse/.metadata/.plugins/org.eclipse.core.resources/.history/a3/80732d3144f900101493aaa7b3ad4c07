package exercises._09_io.b_audio;

/** Sampled sine function f(x) = a * sin(2 pi f * x).<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AudioData {
	private final short[] samples;
	private final int samplingRateHz;

	/** Initialize samples.
	 * 
	 * @param samplingRateHz Sampling rate in Hz
	 * @param timeSec Audio length in seconds
	 */
	public AudioData(int samplingRateHz, double timeSec) {
		this.samplingRateHz = samplingRateHz;
		samples = new short[(int)(samplingRateHz * timeSec)];
	}

	/** Get samples data.
	 * 
	 * @return audio samples
	 */
	public short[] getSamples() {
		return samples;
	}

	/** Get the number of samples.
	 * 
	 * @return the number of samples
	 */
	public int getNumberSamples() {
		return samples.length;
	}

	/** Get sampling rate.
	 * 
	 * @return sampling rate in Hz
	 */
	public int getSamplingRateHz() {
		return samplingRateHz;
	}

	/** Set data to be a sampled sin-function f(x) = a * sin(2 pi f * x).
	 * 
	 * @param amplitude Amplitude a
	 * @param frequencyHz Frequency f in Hz
	 */
	public void setSine(int amplitude, double frequencyHz) {
		double arg = 2.0 * Math.PI * frequencyHz / samplingRateHz;

		for (int i = 0; i < samples.length; i++)
			samples[i] = (short)(amplitude * Math.sin(i * arg));
	}

	/** Add values of another audio data signal.
	 * 
	 * @param audioData Signal with values to add
	 * @throws AudioDataException
	 */
	public void add(AudioData audioData) {
		// Verify signal parameters match
		if (samples.length != audioData.samples.length)
			throw new AudioDataException(String.format("Number of samples differ: %d != %d", samples.length, audioData.samples.length));
		if (samplingRateHz != audioData.samplingRateHz)
			throw new AudioDataException(String.format("Sampling rates differ: %d != %d", samplingRateHz, audioData.samplingRateHz));
		
		// Add sample values
		for (int i = 0; i < samples.length; i++)
			samples[i] += audioData.samples[i];
	}
}
