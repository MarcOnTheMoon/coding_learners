package exercises._07_gui.c_math_plot;

import exercises._06_abstract.a_zero_crossing.Parabola;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PlotApp {
	private static final int PLOT_WIDTH = 600;
	private static final int PLOT_HEIGHT = 500;
	private static final double PLOT_X_MIN = -2.5;
	private static final double PLOT_X_MAX = 2.5;
	private static final double PLOT_Y_MIN = -0.5;
	private static final double PLOT_Y_MAX = 4.5;
	private static final double PARABOLA_A2 = 1.0;
	private static final double PARABOLA_A1 = 0.0;
	private static final double PARABOLA_A0 = 0.0;
	private final JTextField textMinX, textMaxX, textMinY, textMaxY;
	private final JTextField textA2, textA1, textA0;

	/** Constructor creating and displaying frame.
	 * 
	 * @param function Mathematical function to display
	 * @param xMin Minimum value of x-axis in drawing area
	 * @param xMax Maximum value of x-axis in drawing area
	 * @param yMin Minimum value of y-axis in drawing area
	 * @param yMax Maximum value of y-axis in drawing area
	 */
	private PlotApp(Parabola function, double xMin, double xMax, double yMin, double yMax) {
		// Create frame and set properties
		JFrame frame = new JFrame("Mathematische Funktionen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Create drawing area
		PlotPanel plotPanel = new PlotPanel(new Dimension(PLOT_WIDTH, PLOT_HEIGHT), function);
		plotPanel.setAxisX(xMin, xMax);
		plotPanel.setAxisY(yMin, yMax);
		addMouseListener(plotPanel);
		
		// Create control elements for axes
		textMinX = new JTextField(Double.toString(xMin));
		textMaxX = new JTextField(Double.toString(xMax));
		textMinY = new JTextField(Double.toString(yMin));
		textMaxY = new JTextField(Double.toString(yMax));		
		addAxesActionListener(plotPanel);

		// Create control elements for function
		textA2 = new JTextField(Double.toString(PARABOLA_A2));
		textA1 = new JTextField(Double.toString(PARABOLA_A1));
		textA0 = new JTextField(Double.toString(PARABOLA_A0));	
		addFunctionActionListener(plotPanel);
		
		// Layout control panels
		JPanel axesPanel = new JPanel();
		axesPanel.setLayout(new GridLayout(2, 4));
		axesPanel.add(new JLabel("x-Achse", SwingConstants.CENTER));
		axesPanel.add(textMinX);
		axesPanel.add(textMaxX);
		axesPanel.add(new JLabel("Mit [Eingabe]", SwingConstants.CENTER));
		axesPanel.add(new JLabel("y-Achse", SwingConstants.CENTER));
		axesPanel.add(textMinY);
		axesPanel.add(textMaxY);
		axesPanel.add(new JLabel("übernehmen", SwingConstants.CENTER));

		JPanel functionPanel = new JPanel();
		functionPanel.setLayout(new GridLayout(1, 4));
		functionPanel.add(new JLabel("f(x)", SwingConstants.CENTER));
		functionPanel.add(textA2);
		functionPanel.add(textA1);
		functionPanel.add(textA0);

		// Layout content pane
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(plotPanel);
		contentPane.add(axesPanel);
		contentPane.add(functionPanel);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);		
	}
	
	/** Add mouse listener to the plot panel.
	 * 
	 * @param plotPanel Panel to add listener to
	 */
	private void addMouseListener(PlotPanel plotPanel) {
		plotPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				plotPanel.approximateZeroCrossing(e.getX());
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}			
		});
	}
	
	/** Add action listener for text fields related to the axes.
	 * <p>
	 * The action event is triggered when leaving a text field by
	 * pressing [Enter].
	 * 
	 * @param plotPanel Plot panel to update
	 */
	private void addAxesActionListener(PlotPanel plotPanel) {
		// Create action listener
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				double xMin, xMax, yMin, yMax;

				// Get input from text fields
				try {
					xMin = Double.parseDouble(textMinX.getText());
					xMax = Double.parseDouble(textMaxX.getText());
					yMin = Double.parseDouble(textMinY.getText());
					yMax = Double.parseDouble(textMaxY.getText());
				} catch (Exception exception) {
					return;
				}
				
				// Set axes min and max values
				plotPanel.setAxisX(xMin, xMax);
				plotPanel.setAxisY(yMin, yMax);
			}
		};
		
		// Add listener to text fields
		textMinX.addActionListener(listener);
		textMaxX.addActionListener(listener);
		textMinY.addActionListener(listener);
		textMaxY.addActionListener(listener);
	}
	
	/** Add action listener for text fields related to the mathematical function.
	 * <p>
	 * The action event is triggered when leaving a text field by
	 * pressing [Enter].
	 * 
	 * @param plotPanel Plot panel to update
	 */
	private void addFunctionActionListener(PlotPanel plotPanel) {
		// Create action listener
		ActionListener listener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				double a2, a1, a0;

				// Get input from text fields
				try {
					a2 = Double.parseDouble(textA2.getText());
					a1 = Double.parseDouble(textA1.getText());
					a0 = Double.parseDouble(textA0.getText());
				} catch (Exception exception) {
					return;
				}
				
				// Set function coefficients
				plotPanel.setFunction(new Parabola(a2, a1, a0));
			}
		};
		
		// Add listener to text fields
		textA2.addActionListener(listener);
		textA1.addActionListener(listener);
		textA0.addActionListener(listener);
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		Parabola function = new Parabola(PARABOLA_A2, PARABOLA_A1, PARABOLA_A0);
		new PlotApp(function, PLOT_X_MIN, PLOT_X_MAX, PLOT_Y_MIN, PLOT_Y_MAX);
	}
}
