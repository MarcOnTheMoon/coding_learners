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
public class Sobel {
	static final String SOURCE_COLOGNE = "resources/CologneGray.jpg";
	static final String SOURCE_DOCKS = "resources/DocksGray.jpg";
	static final String TARGET_COLOGNE = "output_files/CologneSobel.png";
	static final String TARGET_DOCKS = "output_files/DocksSobel.png";

	public static void main(String[] args) throws IOException {
		// Open source images
		Imaging cologneImage = new Imaging(SOURCE_COLOGNE);
		Imaging docksImage = new Imaging(SOURCE_DOCKS);
		System.out.println("File opened : " + SOURCE_COLOGNE);
		System.out.println("File opened : " + SOURCE_DOCKS);

		// Process images
		cologneImage.sobel();
		docksImage.sobel();
		
		// Write processed images to files
		cologneImage.writeFilePNG(TARGET_COLOGNE);
		System.out.println("File written: " + TARGET_COLOGNE);

		docksImage.writeFilePNG(TARGET_DOCKS);
		System.out.println("File written: " + TARGET_DOCKS);
	}
}
