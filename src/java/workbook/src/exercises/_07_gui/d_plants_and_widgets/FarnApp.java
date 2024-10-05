package exercises._07_gui.d_plants_and_widgets;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

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
public class FarnApp {
	private final int plotWidth = 400;
	private final int plotHeight = 400;
	private final ArrayList<Point2D.Double> points = new ArrayList<Point2D.Double>();
	
	/** Add a point according to Barnsley's fern.
	 * <p>
	 * <a href="https://en.wikipedia.org/wiki/Barnsley_fern">https://en.wikipedia.org/wiki/Barnsley_fern</a>
	 */
	private void addFernPoint() {		
		if (points.size() > 1) {
			int selector = (int)(100 * Math.random()) + 1;
			Point2D.Double last = points.get(points.size() - 1);
			Point2D.Double next = new Point2D.Double();

			if (selector <= 1) {
				next.x = 0;
				next.y = 0.16 * last.y;
			} else if (selector <= 86) {
				next.x = 0.85 * last.x + 0.04 * last.y;
				next.y = -0.04 * last.x + 0.85 * last.y + 1.6;
			} else if (selector <= 93) {
				next.x = 0.2 * last.x + -0.26 * last.y;
				next.y = 0.23 * last.x + 0.22 * last.y + 1.6;
			} else {
				next.x = -0.15 * last.x + 0.28 * last.y;
				next.y = 0.26 * last.x + 0.24 * last.y + 0.44;
			}
			points.add(next);
		} else {
			points.add(new Point2D.Double(0.0, 0.0));
		}
	}
	
	/** Constructor creating and displaying frame.
	 */
	public FarnApp() {
		// Create frame and set properties
		JFrame frame = new JFrame("Barnsley's fern");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationByPlatform(true);
		
		// Create plot panel
		JPanel plotPanel = new JPanel() {
			@Override
			public void paintComponent(Graphics g) {
				double scale = 39.0;
				
				for (Point2D.Double point : points)
					g.drawRect(getWidth()/2 + (int)(scale * point.x), getHeight() - (int)(scale * point.y), 1, 1);
			}
		};
		plotPanel.setPreferredSize(new Dimension(plotWidth, plotHeight));
		
		// Create and layout buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 5));
		JButton clearButton = new JButton("Clear");
		JButton[] buttons = { new JButton("10"), new JButton("100"), new JButton("500"), new JButton("1000") };
		
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				points.clear();
				frame.repaint();		
			}
		});
		
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				JButton button = (JButton)event.getSource(); 
				int numberPoints = Integer.parseInt(button.getText());
				
				for (int i = 0; i < numberPoints; i++)
					addFernPoint();
				frame.repaint();		
			}
		};

		buttonPanel.add(clearButton);
		for (JButton button : buttons) {
			buttonPanel.add(button);
			button.addActionListener(listener);
		}
				
		// Layout content pane
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(plotPanel);
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
		new FarnApp();
	}
}
