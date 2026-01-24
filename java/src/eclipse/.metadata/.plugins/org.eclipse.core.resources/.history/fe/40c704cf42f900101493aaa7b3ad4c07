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
public class Gradients {
	static final String SOURCE_FILE = "resources/DocksGray.jpg";
	static final String TARGET_FILE_X = "output_files/DocksGradientX.png";
	static final String TARGET_FILE_Y = "output_files/DocksGradientY.png";
	static final String TARGET_FILE_XY = "output_files/DocksGradient.png";

	public static void main(String[] args) throws IOException {
		// Open source image
		Imaging imagingX = new Imaging(SOURCE_FILE);
		Imaging imagingY = new Imaging(SOURCE_FILE);
		Imaging imagingXY = new Imaging(SOURCE_FILE);
		System.out.println("File opened : " + SOURCE_FILE);

		// Process images
		imagingX.gradientX();
		imagingY.gradientY();
		imagingXY.gradient();
		
		// Write processed images to files
		imagingX.writeFilePNG(TARGET_FILE_X);
		System.out.println("File written: " + TARGET_FILE_X);

		imagingY.writeFilePNG(TARGET_FILE_Y);
		System.out.println("File written: " + TARGET_FILE_Y);

		imagingXY.writeFilePNG(TARGET_FILE_XY);
		System.out.println("File written: " + TARGET_FILE_XY);
	}
}
