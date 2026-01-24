package exercises._04_library.d_imaging;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
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
public class Imaging {
	BufferedImage image;
	int width, height;
	short[][] pixels;			// TYPE_BYTE_GRAY: unsigned bytes
	
	/** Constructor reading 8-bit grayscale image from file.
	 * 
	 * @param imagePath Full path of grayscale image file to read
	 * @throws IOException
	 */
	Imaging(String imagePath) throws IOException {
		// Read image from file
		File file = new File(imagePath);
		image = ImageIO.read(file);

		// Initialize dimensions and pixel matrix
		if ((image != null) && (image.getType() == BufferedImage.TYPE_BYTE_GRAY)) {
			// Assign image dimensions
			height = image.getHeight();
			width = image.getWidth();

			// Get pixel data (1D array of unsigned bytes [0, 255] stored in signed bytes [-128, 127])
			byte[] imageBytes = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			
			// Create 2D pixel matrix in [0, 255]
			// Note: "byte & 0xff" => [-128, 127] -> [0, 255]
			pixels = new short[height][width];
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					pixels[y][x] = (short)(imageBytes[y * width + x] & 0xff);
				}
			}
		}
	}
	
	/** Write image to a *.png file.
	 * 
	 * @param filePath Full path of destination file
	 * @throws IOException
	 */
	void writeFilePNG(String filePath) throws IOException {
		if (image != null) {
			// Set potentially modified pixel values
			byte[] imageBytes = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
			for (int y = 0, i = 0; y < height; y++) {
				for (int x = 0; x < width; x++, i++) {
					imageBytes[i] = (byte)pixels[y][x];
				}
			}

			// Write image to file
			File file = new File(filePath);
			ImageIO.write(image, "png", file);
		}
	}
	
	/** Get the minimum pixel value.
	 * 
	 * @return the lowest pixel value in the image
	 */
	int getMinPixelValue() {
		int minValue = pixels[0][0];

		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (pixels[y][x] < minValue)
					minValue = pixels[y][x];
			}
		}
		return minValue;
	}
	
	/** Get the maximum pixel value.
	 * 
	 * @return the largest pixel value in the image
	 */
	int getMaxPixelValue() {
		int maxValue = pixels[0][0];
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (pixels[y][x] > maxValue)
					maxValue = pixels[y][x];
			}
		}
		return maxValue;
	}
	
	/** Set all pixels to a specific gray value.
	 * 
	 * @param pixelValue Gray value to set [0, 255]
	 */
	void setPixels(int pixelValue) {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[y][x] = (short)pixelValue;
			}
		}
	}

	/** Invert image.
	 * <p>
	 * Inverted images are also known as "negatives" from analog images.
	 * That means, black becomes white and vice versa.
	 */
	void invert() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[y][x] = (short)(255 - pixels[y][x]);
			}
		}
	}

	/** Apply horizontal gradient-based edge detection.
	 */
	void gradientX() {
		short[][] gradientX = new short[height][width];
		
		// Calculate the edge image
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				gradientX[y][x] = (short)((int)Math.abs(pixels[y][x+1] - pixels[y][x-1]) / 2);
			}
		}

		// Assign edge image to image pixels
		pixels = gradientX;
	}

	/** Apply vertical gradient-based edge detection.
	 */
	void gradientY() {
		short[][] gradientY = new short[height][width];
		
		// Calculate the edge image
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				gradientY[y][x] = (short)((int)Math.abs(pixels[y+1][x] - pixels[y-1][x]) / 2);
			}
		}

		// Assign edge image to image pixels
		pixels = gradientY;
	}

	/** Apply gradient-based edge detection.
	 * <p>
	 * Edge values are scaled linear to min{255, value}, if these exceed 255. 
	 */
	void gradient() {
		short[][] gradient = new short[height][width];
		
		// Calculate the edge image
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				int gradientX = (pixels[y][x+1] - pixels[y][x-1]) / 2;
				int gradientY = (pixels[y+1][x] - pixels[y-1][x]) / 2;
				
				gradient[y][x] = (short)(Math.sqrt(gradientX * gradientX + gradientY * gradientY));
			}
		}

		// Assign edge image to image pixels
		pixels = gradient;
	}

	/** Apply Sobel edge detection.
	 */
	void sobel() {
		short[][] sobel = new short[height][width];
		
		// Calculate the edge image
		for (int y = 1; y < height - 1; y++) {
			for (int x = 1; x < width - 1; x++) {
				int sobelX = pixels[y-1][x+1] + 2 * pixels[y][x+1] + pixels[y+1][x+1] - (pixels[y-1][x-1] + 2 * pixels[y][x-1] + pixels[y+1][x-1]);
				int sobelY = pixels[y+1][x-1] + 2 * pixels[y+1][x] + pixels[y+1][x+1] - (pixels[y-1][x-1] + 2 * pixels[y-1][x] + pixels[y-1][x+1]);

				sobel[y][x] = (short)((int)Math.sqrt(sobelX * sobelX + sobelY * sobelY) / 8);
			}
		}

		// Assign edge image to image pixels
		pixels = sobel;
	}
}
