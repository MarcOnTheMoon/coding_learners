package exercises._07_gui.e_audio;

/** Discrete Fourier Transform (DFT).<br><br>
 *
 * For simplicity and educational purposes, DFT instead of the significantly faster FFT is chosen.<br><br>
 *
 * Notation: s(m) <---> S(u)<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public abstract class Fourier {
	private static double[] cosLUT, sinLUT;

	/** Initialize look-up tables for sin() and cos() functions.
	 * <p>
	 * The values are pre-calculated to reduce runtime. 
	 * 
	 * @param size Number of samples to transform
	 */
	private static void initLookupTables(int size) {
		if ((sinLUT == null) || (sinLUT.length != size)) {
			cosLUT = new double[size];
			sinLUT = new double[size];
			double w0 = 2.0 * Math.PI / size;

			for (int k = 0; k < size; k++) {
				cosLUT[k] = Math.cos(k * w0);
				sinLUT[k] = Math.sin(k * w0);
			}
		}
	}

	/** Apply DFT to time-domain samples.
	 * <p>
	 * Transformation: s(m) ---> S(u)
	 * 
	 * @param samples Samples s(m) to transform
	 * @return corresponding DFT coefficients S(u)
	 */
	public static Complex[] dft(short[] samples) {
		int size = samples.length;
		Complex[] dft = new Complex[size];
		double normFactor = 1.0 / Math.sqrt(size);

		// Preparation
		initLookupTables(size);

		// Calculate DFT of current row data
		for (int u = 0; u < size; u++) {
			double real = 0.0, imag = 0.0;

			for (int m = 0; m < size; m++) {
				int k = (u * m) % size;
				real += samples[m] * cosLUT[k];
				imag += -samples[m] * sinLUT[k];
			}
			dft[u] = new Complex(normFactor * real, normFactor * imag);
		}

		return dft;
	}

	/** Apply inverse DFT to frequency-domain coefficients.
	 * <p>
	 * Transformation: S(u) ---> s(m)
	 * 
	 * @param dft Frequency-domain coefficients S(u) to transform
	 * @return corresponding complex time-domain signal s(m)
	 */
	public static Complex[] idft(Complex[] dft) {
		int size = dft.length;
		Complex[] idft = new Complex[size];
		double normFactor = 1.0 / Math.sqrt(size);

		// Preparation
		initLookupTables(size);

		// Calculate DFT of current row data
		for (int m = 0; m < size; m++) {
			double real = 0.0, imag = 0.0;

			for (int u = 0; u < size; u++) {
				int k = (m * u) % size;
				real += dft[u].getReal() * cosLUT[k] - dft[u].getImag() * sinLUT[k];
				imag += dft[u].getReal() * sinLUT[k] + dft[u].getImag() * cosLUT[k];
			}
			idft[m] = new Complex(normFactor * real, normFactor * imag);
		}

		return idft;
	}

	/** Get log power spectrum of frequency-domain signal S(u).
	 * <p>
	 * For display reasons the power spectrum P(u) for frequency-domain values S(u)
	 * is calculated as follows (using "+ 1" to prevent undefined value log_2(0)):
	 * <p>
	 * P(u) = log_2(|S(u)| + 1)
	 * 
	 * @param powerReordered [out] Power spectrum P(u) reordered to have f = 0 in center
	 * @param dft [in] Frequency-domain signal S(u)
	 * @param scaledMax Maximum value to scale P(u) to
	 */
	public static void getSpectrumLog2(short[] powerReordered, Complex[] dft, int scaledMax) {
		int size = dft.length;
		double[] power = new double[size];
		final double LOG10_2 = Math.log10(2.0);
		double maxAbsolute = 0.0;

		// Calculate power spectrum (first and last index being low frequencies)
		for (int u = 0; u < size; u++) {
			power[u] = Math.log10(dft[u].getAbsolute() + 1.0) / LOG10_2;
			
			if (power[u] > maxAbsolute)
				maxAbsolute = power[u];
		}

		// Reorder spectrum (f = 0 in center) and scale to [0, scaledMax]
		double scaleFactor = (double)scaledMax / maxAbsolute;
		for (int x = 0; x < size; x++) {
			powerReordered[(size/2 + x) % size] = (short)(scaleFactor * power[x]);
		}
	}
}
