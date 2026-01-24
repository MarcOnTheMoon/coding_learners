package _10_threads.a_motivation;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.swing.*;

/** Demonstrate single- vs. multi-threading using image processing.
 * <br><br>
 * 1. The horizontal and vertical edge images are calculated and
 *    shown line by line using a single thread.
 * 2. Both edge images are calculated in two threads (upper and lower
 *    half), each. That is, the task is distributed to four threads.
 * <br><br>
 * The processing is slowed down artificially and display is updated
 * regularly for demonstration purposes.
 * <br><br>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class MotivationGUI {

	public MotivationGUI() {
		// Create frame to display processed images
		MyImageFrame imageFrame = new MyImageFrame("resources/DocksSmall.jpg");

		// Create control frame and set properties
		JFrame frame = new JFrame("Process");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		frame.setLayout(new GridLayout(2,1));

		// Add buttons
		Container contentPane = frame.getContentPane();
		JButton buttonSingle = new JButton("Process using 1 thread");
		JButton buttonMulti = new JButton("Process using 4 threads");		

		contentPane.add(buttonSingle);
		contentPane.add(buttonMulti);
		
		buttonSingle.setActionCommand("SingleThreaded");
		buttonSingle.addActionListener(imageFrame);
		buttonMulti.setActionCommand("MultiThreaded");
		buttonMulti.addActionListener(imageFrame);

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new MotivationGUI();
	}
}


/** Frame for image display.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners/">link</a>)<br>
 * Copyright: 2023, Marc Hensel<br>
 * Version: 2023.12.08<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
class MyImageFrame extends JFrame implements ActionListener {
	private final BufferedImage image;
	private boolean doProcessingSingle = false;
	private boolean doProcessingMulti = false;
	private static final int Y_SHIFT = 30;

	/** Create and show frame.
	 * 
	 * @param fileName File to load image from
	 */
	public MyImageFrame (String fileName) {
		super("Image filter: single- vs multi-threaded (Observe processor load in Task Manager)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(50, 50);
		
		image = MotivationIpMethods.loadImage(fileName);
		this.setPreferredSize(new Dimension(3 * image.getWidth(), image.getHeight() + Y_SHIFT + 7));
		
		pack();
		setVisible(true);
	}
	
	/** Event handling: Filter image single- or multi-threaded.
	 * 
	 * @param event Event triggering this method
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equalsIgnoreCase("SingleThreaded")) {
			doProcessingSingle = true;
			repaint();
		} else if (event.getActionCommand().equalsIgnoreCase("MultiThreaded")) {
			doProcessingMulti = true;
			repaint();
		}
	}

	/** Painting (includes image processing).
	 * 
	 * @param graphics Device context
	 */
	public void paint(Graphics graphics) {
		int sizeX = image.getWidth(this);
		double[][] edgeMaskX = new double[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
		double[][] edgeMaskY = new double[][]{{-1, -2, -1}, {0, 0, 0}, {1, 2, 1}};

		// Display original image
		graphics.drawImage(image, 0, Y_SHIFT, this);
		graphics.drawImage(image, sizeX, Y_SHIFT, this);
		graphics.drawImage(image, 2 * sizeX, Y_SHIFT, this);

		// Single thread
		if (doProcessingSingle) {
			// Single thread: filter in x
			BufferedImage edgeImageX = MotivationIpMethods.cloneImage(image);
			for (int y = 1; y < image.getHeight() - 1; y++) {
				MotivationRunnable.activelyDelay();
				MotivationIpMethods.applyLinearFilter(image, edgeImageX, edgeMaskX, false, 1, y, image.getWidth() - 2, 1);
				graphics.drawImage(edgeImageX, sizeX, Y_SHIFT, this);
			}

			// Single thread: filter in y
			BufferedImage edgeImageY = MotivationIpMethods.cloneImage(image);
			for (int y = 1; y < image.getHeight() - 1; y++) {
				MotivationRunnable.activelyDelay();
				MotivationIpMethods.applyLinearFilter(image, edgeImageY, edgeMaskY, false, 1, y, image.getWidth() - 2, 1);
				graphics.drawImage(edgeImageY, 2 * sizeX, Y_SHIFT, this);
			}

			doProcessingSingle = false;
		}
		
		// Multi-threaded
		if (doProcessingMulti) {
			BufferedImage edgeImageX = MotivationIpMethods.cloneImage(image);
			BufferedImage edgeImageY = MotivationIpMethods.cloneImage(image);
			int halfHeight = image.getHeight()/2 - 1;
			Thread threadX1 = new Thread(new MotivationRunnable(image, edgeImageX, edgeMaskX, false, 1, halfHeight));
			Thread threadX2 = new Thread(new MotivationRunnable(image, edgeImageX, edgeMaskX, false, halfHeight, image.getHeight() - 2));
			Thread threadY1 = new Thread(new MotivationRunnable(image, edgeImageY, edgeMaskY, false, 1, halfHeight));
			Thread threadY2 = new Thread(new MotivationRunnable(image, edgeImageY, edgeMaskY, false, halfHeight, image.getHeight() - 2));
			threadX1.start();
			threadX2.start();
			threadY1.start();
			threadY2.start();
			
			while (threadX1.isAlive() || threadX2.isAlive() || threadY1.isAlive() || threadY2.isAlive()) {
				graphics.drawImage(edgeImageX, sizeX, Y_SHIFT, this);
				graphics.drawImage(edgeImageY, 2 * sizeX, Y_SHIFT, this);
			}
			
			doProcessingMulti = false;
		}
	}
}
