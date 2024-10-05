package exercises._04_library.d_imaging;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PixelValues {
	static final String SOURCE_FILE = "resources/CologneGray.jpg";

	public static void main(String[] args) throws IOException {
		byte pixelValue = 0;
		
		// Read image from file
		BufferedImage image = ImageIO.read(new File(SOURCE_FILE));
		System.out.println("File read   : " + SOURCE_FILE);

		// Set all pixels to same value and write image to file
		if ((image != null) && (image.getType() == BufferedImage.TYPE_BYTE_GRAY)) {
			// Get pixel data (1D array of signed bytes [-128, 127])
			byte[] imageBytes = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			
			// Set pixel values
			Arrays.fill(imageBytes, pixelValue);
			
			// Write image file
			String fileName = String.format("output_files/Pixels_%d.png", pixelValue);
			ImageIO.write(image, "png", new File(fileName));
			System.out.println("File written: " + fileName);
		}
	}
}
