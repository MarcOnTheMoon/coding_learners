package histogram;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * GUI application demonstrating sigma cut method for 1D Gaussian distribution.
 * @author Marc Hensel
 * @version 2010-12-27
 */
public class SigmaCutGUI implements ActionListener {
	private JFrame frame;
	private HistogramPanel histogramPanelA, histogramPanelB;

	/**
	 * Create and show application window.
	 */
	public SigmaCutGUI() {
		// Create frame
		frame = new JFrame("Sigma Cut");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);
		
		// Create and layout histogram panels
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		histogramPanelA = new HistogramPanel(new Histogram(256, new int[0]));
		histogramPanelB = new HistogramPanel(new Histogram(256, new int[0]));
		histogramPanelA.setBorder(BorderFactory.createLineBorder(Color.black));
		histogramPanelB.setBorder(BorderFactory.createLineBorder(Color.black));
		contentPane.add(histogramPanelA);
		contentPane.add(histogramPanelB);
		
		// Create button and set event handling
		JButton newDataButton = new JButton("Neue Zufallsdaten");
		newDataButton.setActionCommand("ButtonReset");
		newDataButton.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		buttonPanel.add(newDataButton);
		contentPane.add(buttonPanel);

		// Set initial random data
		setRandomData();

		// Show frame
		frame.pack();
		frame.setVisible(true);		
	}
	
	/**
	 * Application starting point.
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new SigmaCutGUI();
	}

	/**
	 * Create an array with Gaussian-distributed random numbers.
	 * @param numberSamples Number of values to create (array length)
	 * @param mean Mean of Gaussian random distribution
	 * @param sigma Standard deviation of Gaussian random distribution
	 * @return Gaussian random data with given statistics
	 */
	private int[] createRandomArray(int numberSamples, double mean, double sigma) {
		int[] randomArray = new int[numberSamples];
		Random random = new Random();
		
		for (int i = 0; i < numberSamples; i++) {
			randomArray[i] = (int)(sigma * random.nextGaussian() + mean);
		}
		return randomArray;
	}
	
	/**
	 * Concatenate two arrays.
	 * @param a First array to concatenate
	 * @param b Second array to concatenate
	 * @return concatenation {a, b}
	 */
	private int[] concatArrays(int[] a, int[] b) {
		int[] array = new int[a.length + b.length];
		
		for (int i = 0; i < a.length; i++) {
			array[i] = a[i];
		}
		for (int i = 0; i < b.length; i++) {
			array[a.length + i] = b[i];
		}
		return array;
	}
	
	/**
	 * Create and set new random data for the histogram panels.
	 */
	private void setRandomData() {
		int[] randomData;
		double mean = 128.0;
		double dMean = 85.0;
		
		// Create Gaussian with upper and lower disturbances
		randomData = createRandomArray(10000, mean, 20.0);
		randomData = concatArrays(randomData, createRandomArray(250, mean - dMean, 4.0));
		randomData = concatArrays(randomData, createRandomArray(250, mean + dMean, 4.0));

		// Set data in upper histogram panel
		histogramPanelA.setHistogram(new Histogram(256, randomData));
		
		// Do sigma cut and set data in lower histogram panel
		Histogram histogram = new Histogram(256, randomData);
		HistogramUtils.applySigmaCut(histogram);
		histogramPanelB.setHistogram(histogram);
	}
	
	/**
	 * Button event handling.
	 * @param event Triggering event
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("ButtonReset")) {
			setRandomData();
		}
		frame.repaint();
	}

}

/**
 * Panel displaying a histogram containing 265 bins.
 * @author Marc Hensel
 * @version 2010-12-27
 */
class HistogramPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Histogram histogram;
	
	/**
	 * Create instance.
	 * @param histogram Histogram data to display
	 */
	public HistogramPanel(Histogram histogram) {
		this.histogram = histogram;
	}
	
	/**
	 * Set other histogram data to display.
	 * @param histogram Histogram data to display
	 */
	public void setHistogram(Histogram histogram) {
		this.histogram = histogram;
	}

	/**
	 * Set preferred size for display.
	 * @return preferred size for display
	 */
	public Dimension getPreferredSize() {
		return new Dimension(300,200);
	}

	/**
	 * Do drawing.
	 * @param g Graphics context
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x0 = 15;
		int y0 = 175;
		double scaleFactor = 125.0 / histogram.getMaxValue();
		
		// Histogram values
		g.setColor(Color.red);
		for (int i = 0; i < 256; i++) {
			int dy = (int)(scaleFactor * histogram.getValueAt(i));
			g.drawLine(x0 + 1 + i, y0, x0 + 1 + i, y0 - dy);
		}
		
		// Coordinate system
		g.setColor(Color.black);
		g.drawLine(x0, y0, x0 + 270, y0);
		g.drawLine(x0, y0, x0, y0 - 150);
		
		// Statistics strings
		g.drawString(String.format("mean  = %.1f", histogram.mean()), 25, 15);
		g.drawString(String.format("sigma = %.1f", histogram.standardDeviation()), 25, 30);
	}
}