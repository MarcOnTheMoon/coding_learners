package exercises._04_library.d_imaging;

import java.io.IOException;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class InvertImage {
	static final String SOURCE_FILE = "resources/DocksGray.jpg";
	static final String TARGET_FILE = "output_files/InvertImage.png";

	public static void main(String[] args) throws IOException {
		Imaging imaging = new Imaging(SOURCE_FILE);

		// Dynamic range of input image
		System.out.println("File opened : " + SOURCE_FILE);
		System.out.printf("Input image : [%d, %d]\n", imaging.getMinPixelValue(), imaging.getMaxPixelValue());

		// Process image (invert)
		imaging.invert();
		System.out.printf("Inverted    : [%d, %d]\n", imaging.getMinPixelValue(), imaging.getMaxPixelValue());
		
		// Write processed image to file
		imaging.writeFilePNG(TARGET_FILE);
		System.out.println("File written: " + TARGET_FILE);
	}
}
