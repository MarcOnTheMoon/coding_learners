package exercises._04_library.d_imaging;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ReadWriteImage {
	static final String SOURCE_FILE = "resources/DocksGray.jpg";
	static final String TARGET_FILE = "output_files/Target.png";

	public static void main(String[] args) throws IOException {
		// Read image from file
		File sourceFile = new File(SOURCE_FILE);
		BufferedImage image = ImageIO.read(sourceFile);
		System.out.println("File read   : " + SOURCE_FILE);
		
		// Write image to file
		File destFile = new File(TARGET_FILE);
		ImageIO.write(image, "png", destFile);
		System.out.println("File written: " + TARGET_FILE);
	}
}
