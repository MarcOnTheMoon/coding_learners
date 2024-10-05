package _tello_drone;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/** Swing panel to display an image of the Tello drone
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.05.27<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ImagePanel extends JPanel {
	private static final String fileName = "resources/Tello200.png";
	private Image image;
	private int imageWidth, imageHeight;

	/**
	 * Create instance and load background image from file.
	 */
	public ImagePanel() {
		try {
			image = ImageIO.read(new File(fileName));
			imageWidth = image.getWidth(this);
			imageHeight = image.getHeight(this);
		} catch (IOException e) {
			System.out.printf("EXCEPTION Cannot read image file \"%s\": %s\n", fileName, e.getMessage());
		}

		setBackground(Color.white);
	}
		
	@Override
	public Dimension getPreferredSize() {
		if (image != null)
			return new Dimension(2 * imageWidth, 2 * imageHeight);
		else
			return new Dimension(-1, -1);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (image != null) {
			int xc = this.getWidth() / 2;		// Center coordinates
			int yc = this.getHeight() / 2;
			
			g.drawImage(image, xc - imageWidth / 2, yc - imageHeight / 2, this);
		}
	}
}
