package exercises._07_gui.e_audio;

/** 1D signal in time-domain (samples) and frequency-domain (DFT coefficients).<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Signal {
	private final short[] samples;
	private final Complex[] dft;
	private final short[] logSpectrum;
	private int maxValueSpectrum;
	
	/** Instantiate object.
	 * <p>
	 * Frequency-domain data is typically visualized by the power spectrum P(u) = log_2(|S(u)| + 1).
	 * The power spectrum is scaled so that its maximum value is equal to the parameter maxValueSpectrum.
	 * 
	 * @param numberSamples Number of samples (time-domain) and coefficients (frequency-domain)
	 * @param maxValueSpectrum Maximum value of power spectrum after scaling
	 */
	public Signal(int numberSamples, int maxValueSpectrum) {
		this.maxValueSpectrum = maxValueSpectrum;
		
		// Init data arrays
		samples = new short[numberSamples];
		dft = new Complex[numberSamples];
		logSpectrum = new short[numberSamples];		

		for (int i = 0; i < numberSamples; i++)
			dft[i] = new Complex(0.0, 0.0);
	}
	
	/** Get the time-domain samples.
	 * <p>
	 * @return the samples
	 */
	public short[] getSamples() {
		return samples;
	}

	/** Get the frequency-domain power spectrum.
	 * 
	 * @return the power spectrum
	 */
	public short[] getLogSpectrum() {
		return logSpectrum;
	}

	/** Set the time-domain samples to be a sampled sin-function f(x) = a * sin(2 pi f * x).
	 * <p>
	 * The method updates the frequency-domain data to match the samples.
	 * 
	 * @param amplitude Amplitude a
	 * @param frequencyHz Frequency f in Hz
	 * @param samplingRateHz Sampling rate in Hz
	 */
	public void setSamplesSine(double amplitude, double frequencyHz, double samplingRateHz) {
		// Set time-domain samples
		double arg = 2.0 * Math.PI * frequencyHz / samplingRateHz;
		for (int n = 0; n < samples.length; n++)
			samples[n] = (short)(amplitude * Math.sin(n * arg));

		// Set corresponding frequency-domain coefficients
		updateFrequencyDomain();
	}
	
	/** Set the time-domain samples to be the sum of the samples of two other signals.
	 * <p>
	 * The method updates the frequency-domain data to match the samples.
	 * 
	 * @param a First signal who's samples to add
	 * @param b Second signal who's samples to add
	 */
	public void setSamplesSum(Signal a, Signal b) {
		if ((samples.length == a.samples.length) && (samples.length == b.samples.length)) {
			// Set time-domain samples
			for (int i = 0; i < samples.length; i++)
				samples[i] = (short)(a.samples[i] + b.samples[i]);

			// Set corresponding frequency-domain coefficients
			updateFrequencyDomain();
		}
	}

	/** Update the frequency-domain data to match the time-domain samples.
	 */
	private void updateFrequencyDomain() {
		Complex.copy(dft, Fourier.dft(samples));
		Fourier.getSpectrumLog2(logSpectrum, dft, maxValueSpectrum);
	}

	/** Make the object an copy of a given signal.
	 * 
	 * @param source Signal who's data to copy
	 */
	public void copy(Signal source) {
		if (samples.length == source.samples.length) {
			for (int i = 0; i < samples.length; i++) {
				samples[i] = source.samples[i];
				dft[i] = source.dft[i].clone();
				logSpectrum[i] = source.logSpectrum[i];
				maxValueSpectrum = source.maxValueSpectrum;
			}
		}
	}

	/** Apply band-reject filter to frequency-domain data.
	 * 
	 * @param index Index of reject band center
	 * @param radius Radius of reject band [indices]
	 */
	public void applyBandRejectFilter(int index, int radius) {
		// Apply filter (set coefficients in band to zero)
		for (int i = index - radius; i <= index + radius; i++) {
			if ((i >= 0) && (i < dft.length)) {
				dft[i].set(0.0, 0.0);
				dft[dft.length - (i + 1)].set(0.0, 0.0);
			}
		}

		// Update power spectrum
		int maxValueDFT = AudioGUI.plotPanelHeight - 25;
		Fourier.getSpectrumLog2(logSpectrum, dft, maxValueDFT);
		
		// Determine corresponding time-domain data
		Complex.copyReal(samples, Fourier.idft(dft));		
	}
}
