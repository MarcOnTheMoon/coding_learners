package exercises._07_gui.e_audio;

/** Mathematical complex number z = x + i * y.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Complex {
	private double real, imag;

	/** Instantiate object.
	 * 
	 * @param real Real part x
	 * @param imag Imaginary part y
	 */
	public Complex(double real, double imag) {
		super();
		this.real = real;
		this.imag = imag;
	}

	/** Get the real part x.
	 * 
	 * @return real part x
	 */
	public double getReal() {
		return real;
	}

	/** Get the imaginary part y.
	 * 
	 * @return imaginary part y
	 */
	public double getImag() {
		return imag;
	}

	/** Get absolute |z|.
	 * 
	 * @return absolute value |z| = sqrt(x^2 + y^2)
	 */
	public double getAbsolute() {
		return Math.sqrt(real * real + imag * imag);
	}
	
	/** Set the real and imaginary part.
	 * 
	 * @param real Real part x
	 * @param imag Imaginary part y
	 */
	public void set(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	/** Copy the contents of an array into another one.
	 * 
	 * @param copy [out] Destination array
	 * @param source [in] Source array
	 */
	public static void copy(Complex[] copy, Complex[] source) {
		if (copy.length == source.length) {
			for (int i = 0; i < copy.length; i++) {
				copy[i].real = source[i].real;
				copy[i].imag = source[i].imag;
			}
		}
	}

	/** Copy the real parts in an array of complex numbers into another array.
	 *  
	 * @param realParts [out] Destination array for the real parts
	 * @param source [in] Source array
	 */
	public static void copyReal(short[] realParts, Complex[] source) {
		if (realParts.length == source.length) {
			for (int i = 0; i < realParts.length; i++) {
				realParts[i] = (short)source[i].real;
			}
		}
	}
	
	@Override
	public Complex clone() {
		return new Complex(real, imag);
	}
}
