package exercises._07_gui.a_dice;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceStatisticsApp {

	/** Constructor creating and displaying frame.
	 */
	private DiceStatisticsApp() {
		// Create frame and set properties
		JFrame frame = new JFrame("Würfel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Drawing panel
		DiceImagePanel diceImagePanel = new DiceImagePanel();
		DataPlotPanel dataPlotPanel = new DataPlotPanel(diceImagePanel.getPreferredSize().width, 120, 20);

		// Buttons
		JButton rollButton = new JButton("Würfeln");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Roll dice and display result
				int diceValue = (int) Math.round(6.0 * Math.random() + 0.5);
				diceImagePanel.setDiceValueAndRepaint(diceValue);
				dataPlotPanel.add(diceValue);
			}
		});

		JButton resetButton = new JButton("Löschen");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Roll dice and display result
				dataPlotPanel.reset();
			}
		});

		// Layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.add(rollButton);
		buttonPanel.add(resetButton);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(diceImagePanel);
		contentPane.add(dataPlotPanel);
		contentPane.add(buttonPanel);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new DiceStatisticsApp();
	}
}

/** Panel to plot data (averages) over time.
 */
class DataPlotPanel extends JPanel {
	private final int width, height, border;
	private final double[] data;
	private int sum, count;
	
	/** Constructor.
	 * 
	 * @param width Panel width in pixel
	 * @param height Panel height in pixel
	 * @param border Panel border
	 */
	public DataPlotPanel(int width, int height, int border) {
		super();
		this.width = width;
		this.height = height;
		this.border = border;
		data = new double[width - 2 * border];
		setBackground(Color.white);
	}

	/** Add a sample to the data.
	 * <p>
	 * Does not add further samples when the data array is full.
	 * 
	 * @param value Sample to append to the data.
	 */
	void add(int value) {
		if (count < data.length) {
			sum += value;
			data[count] = sum / (count + 1.0);
			count++;
			repaint();
		}
	}
	
	/** Empty data array and repaint.
	 */
	void reset() {
		sum = 0;
		count = 0;
		repaint();
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(width, height);
	}
	
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		int x0 = border, x1 = width - border;
		int y0 = height - border, y1 = border;
		double scaleY = (y1 - y0) / 6.0;
		int yMean = y0 + (int)(3.5 * scaleY);
		
		// Draw theoretical mean and axes
		g.setColor(Color.red);
		g.drawLine(x0, yMean, x1, yMean);
		g.setColor(Color.black);
		g.drawLine(x0, y0, x0, y1);
		g.drawLine(x0, y0, x1, y0);
		
		// Draw sample mean
		g.setColor(Color.blue);
		for (int i = 1; i < count; i++) {
			g.drawLine(x0 + (i-1), y0 + (int)(data[i-1] * scaleY), x0 + i, y0 + (int)(data[i] * scaleY));
		}
		
		// Print last sample mean
		if (count > 0) {
			g.setColor(Color.black);
			g.drawString(String.format("Mittelwert: %.2f", data[count - 1]), 2* border, y1);
		}
	}
}
