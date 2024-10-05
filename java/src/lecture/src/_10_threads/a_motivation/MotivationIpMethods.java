package _10_threads.a_motivation;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/** Image processing methods for demonstration purposes.
 * <br><br>
 * The methods are implemented for demonstration purposes.
 * They are not trimmed for performance or designed in a 
 * well and safe fashion.
 * <br><br>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MotivationIpMethods {

	/** Load image from file.
	 * 
	 * @param fileName Input file name (including path)
	 * @return Created image object
	 */
	public static BufferedImage loadImage(String fileName) {
		BufferedImage image = null;
		
		try {
			image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			System.err.println(e.toString());
		}
		return image;
	}
	
	/** Fill all image pixels with constant intensity.
	 * 
	 * @param image Image [out]
	 * @param pixValue Intensity to set for each pixel
	 */
	public static void clearImage(BufferedImage image, int pixValue) {
		Graphics g = image.getGraphics();
		g.setColor(new Color(pixValue, pixValue, pixValue));
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
	}

	/** Create a copy of an image.
	 * 
	 * @param source Source image
	 * @return Copy of source image
	 */
	public static BufferedImage cloneImage(BufferedImage source) {
		BufferedImage target = new BufferedImage(source.getWidth(), source.getHeight(), BufferedImage.TYPE_INT_RGB);
		Graphics g = target.getGraphics();
		g.drawImage(source, 0, 0, null);
		return target;
	}
	
	/** Invert all pixels in an image.
	 * 
	 * @param image	Image to invert [in/out]
	 */
	public static void invertImage(BufferedImage image) {
		int sizeX = image.getWidth();
		int sizeY = image.getHeight();
		
		for (int y = 0; y < sizeY; y++) {
			for (int x = 0; x < sizeX; x++) {
				Color sourceRGB = new Color(image.getRGB(x, y));
				int pixInt = 255 - (sourceRGB.getRed() + sourceRGB.getGreen() + sourceRGB.getBlue()) / 3;
				image.setRGB(x, y, new Color(pixInt, pixInt, pixInt).getRGB());
			}
		}
	}
	
	/** Apply linear filter to image area.
	 * <p>
	 * Filtered pixels are clipped to [0, 255]. If mask contains negative
	 * coefficients (indicated by isMaskNegative == true), the absolute value
	 * is calculated before clipping.
	 * 
	 * @param source Source image
	 * @param target Target image [out]
	 * @param mask Filter coefficients
	 * @param isMaskNegative Pass true if mask contains negative coefficients
	 * @param x0 Area to be filtered: x coordinate of upper left corner
	 * @param y0 Area to be filtered: y coordinate of upper left corner
	 * @param width Width of area to be filtered
	 * @param height Height of area to be filtered
	 * @return True if no error occurred
	 */
	public static boolean applyLinearFilter(BufferedImage source, BufferedImage target, double[][] mask, boolean isMaskNegative, int x0, int y0, int width, int height) {
		// Init
		int sizeX = source.getWidth();
		int sizeY = source.getHeight();
		int deltaX = (mask[0].length - 1) / 2;
		int deltaY = (mask.length - 1) / 2;

		// Check for errors
		if (target.getWidth() != sizeX || target.getHeight() != sizeY) {
			System.out.println("Warning: image dimensions differ");
			return false;
		}
		if (x0 < deltaX) {
			x0 = deltaX;
			System.out.println("Warning: adjusting filter area");
		}
		if ((x0 + width - 1) >= (sizeX - deltaX)) {
			width = sizeX - deltaX - x0;
			System.out.println("Warning: adjusting filter area");
		}
		if (y0 < deltaY) {
			y0 = deltaY;
			System.out.println("Warning: adjusting filter area");
		}
		if ((y0 + height - 1) >= (sizeY - deltaY)) {
			height = sizeY - deltaY - y0;
			System.out.println("Warning: adjusting filter area");
		}
		
		// Apply filter
		for (int y = y0; y < y0 + height; y++) {
			for (int x = x0; x < x0 + width; x++) {
				// Calculate filtered pixel
				double filteredValue = 0.0;
				for (int dy = -deltaY; dy <= deltaY; dy++) {
					for (int dx = -deltaX; dx <= deltaX; dx++) {
						Color pixelRGB = new Color(source.getRGB(x + dx, y + dy));
						int pixelVal = (pixelRGB.getRed() + pixelRGB.getGreen() + pixelRGB.getBlue()) / 3;
						filteredValue += mask[dy+deltaY][dx+deltaX] * pixelVal;
					}
				}
				
				// Clip and set pixel
				int newIntVal = (int) Math.round(filteredValue);									
				if (isMaskNegative) {
					newIntVal = Math.abs(newIntVal);
				}
				if ((newIntVal >= 0) && (newIntVal <= 255)) {
					target.setRGB(x, y, new Color(newIntVal, newIntVal, newIntVal).getRGB());
				} else if (newIntVal > 255) {
					target.setRGB(x, y, new Color(255, 255, 255).getRGB());
				} else {
					target.setRGB(x, y, new Color(0, 0, 0).getRGB());
				}
			}
		}
		return true;
	}
	
	/** Apply linear filter to image area.
	 * <p>
	 * Filtered pixels are clipped to [0, 255]. If mask contains negative
	 * coefficients (indicated by isMaskNegative == true), the absolute value
	 * is calculated before clipping.
	 * <p>
	 * Border handling: The border is set to pixel intensity 0.
	 * 
	 * @param image Source image, which gets overwritten with filtered image [in/out]
	 * @param mask Filter coefficients
	 * @return True if no error occurred
	 */
	public static boolean applyLinearFilter(BufferedImage image, double[][] mask) {
		// Check mask dimension
		if ((mask.length % 2 == 0) || (mask[0].length % 2 == 0)) {
			System.err.println("Warning: filter mask must have odd size in each dimension");
			return false;
		}
		
		// Test if all coefficients are positive
		boolean isMaskPositive = true;		
		for (int dy = 0; dy < mask.length; dy++) {
			double[] maskRow = mask[dy];
			for (int dx = 0; dx < mask[0].length; dx++) {
				if (maskRow[dx] < 0.0) {
					isMaskPositive = false;
					break;
				}
			}
		}
		
		// Init
		BufferedImage source = cloneImage(image);
		int sizeX = image.getWidth();
		int sizeY = image.getHeight();
		int deltaX = (mask[0].length - 1) / 2;
		int deltaY = (mask.length - 1) / 2;
		
		// Apply filter
		clearImage(image, 0);
		for (int y = deltaY; y < sizeY - deltaY; y++) {
			for (int x = deltaX; x < sizeX - deltaX; x++) {
				// Calculate filtered pixel
				double filteredValue = 0.0;
				for (int dy = -deltaY; dy <= deltaY; dy++) {
					for (int dx = -deltaX; dx <= deltaX; dx++) {
						Color pixelRGB = new Color(source.getRGB(x + dx, y + dy));
						int pixelVal = (pixelRGB.getRed() + pixelRGB.getGreen() + pixelRGB.getBlue()) / 3;
						filteredValue += mask[dy+deltaY][dx+deltaX] * pixelVal;
					}
				}
				
				// Clip and set pixel
				int newIntVal = (int) Math.round(filteredValue);									
				if (!isMaskPositive) {
					newIntVal = Math.abs(newIntVal);
				}
				if ((newIntVal >= 0) && (newIntVal <= 255)) {
					image.setRGB(x, y, new Color(newIntVal, newIntVal, newIntVal).getRGB());
				} else if (newIntVal > 255) {
					image.setRGB(x, y, new Color(255, 255, 255).getRGB());
				} else {
					image.setRGB(x, y, new Color(0, 0, 0).getRGB());
				}
			}
		}
		return true;
	}
}
