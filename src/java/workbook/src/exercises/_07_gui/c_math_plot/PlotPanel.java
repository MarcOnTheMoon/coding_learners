package exercises._07_gui.c_math_plot;

import exercises._06_abstract.a_zero_crossing.Parabola;
import exercises._06_abstract.a_zero_crossing.ZeroCrossing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;


/** Plot panel for mathematical functions.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class PlotPanel extends JPanel {
	private double xMin = -1.5, xMax = 1.5;
	private double yMin = -1.5, yMax = 1.5;
	private final Dimension size;
	private Parabola function;
	private final int[] yPixels;
	private final Point startPoint = new Point();
	private Point zeroCrossing;

	/** Init panel object.
	 * 
	 * @param dimension Size of panel in width x height pixel
	 * @param function Mathematical function to plot
	 */
	public PlotPanel(Dimension dimension, Parabola function) {
		super();
		this.size = dimension;
		this.function = function;

		// Pre-calculate values
		yPixels = new int[dimension.width];
		updateAndRedraw();

		// Set appearance
		this.setBackground(Color.white);
	}

	/** Set range of x axis.
	 * 
	 * @param xMin Minimum x value
	 * @param xMax Maximum x value
	 */
	public void setAxisX(double xMin, double xMax) {
		if (xMin < xMax) {
			this.xMin = xMin;
			this.xMax = xMax;
			updateAndRedraw();
		}
	}

	/** Set range of y axis.
	 * 
	 * @param yMin Minimum y value
	 * @param yMax Maximum y value
	 */
	public void setAxisY(double yMin, double yMax) {
		if (yMin < yMax) {
			this.yMin = yMin;
			this.yMax = yMax;
			updateAndRedraw();
		}
	}

	/** Set the function to plot.
	 * 
	 * @param function Mathematical function to plot
	 */
	public void setFunction(Parabola function) {
		this.function = function;
		updateAndRedraw();
	}

	/** Approximate zero-crossing using Newton's method starting at pixel location x0.
	 * 
	 * @param x0 Horizontal pixel position used as starting point for Newton's method
	 */
	public void approximateZeroCrossing(int x0) {
		double xValue = pixel2ValueX(x0);
		double yValue = function.f(xValue);
		Double xZeroValue = ZeroCrossing.newton(function, xValue, 1.0e-6, 10000);
		
		if (xZeroValue != null) {
			startPoint.x = x0;
			startPoint.y = value2PixelY(yValue);
			zeroCrossing = new Point(value2PixelX(xZeroValue), value2PixelY(function.f(xZeroValue)));
		}
		repaint();
	}

	/** Update y coordinates in pixel corresponding to x values and redraw panel.
	 */
	private void updateAndRedraw() {
		// Disable visualization of zero-crossing
		zeroCrossing = null;

		// Pre-calculate pixel values for f(x)
		for (int x = 0; x < size.width; x++) {
			double fx = function.f(pixel2ValueX(x));
			yPixels[x] = value2PixelY(fx);
		}

		// Update display
		repaint();
	}

	/** Get mathematical x value corresponding to horizontal pixel position.
	 * 
	 * @param x Horizontal pixel position x
	 * @return corresponding mathematical x value
	 */
	private double pixel2ValueX(int x) {
		return xMin + (x / (double)(size.width - 1)) * (xMax - xMin);
	}

	/** Get horizontal pixel position corresponding to mathematical x value.
	 * 
	 * @param x Mathematical x value
	 * @return corresponding horizontal pixel position
	 */
	private int value2PixelX(double x) {
		return (int)((x - xMin) / (xMax - xMin) * (double)size.width);
	}

	/** Get vertical pixel position corresponding to mathematical y value.
	 * 
	 * @param y Mathematical y value
	 * @return corresponding vertical pixel position
	 */
	private int value2PixelY(double y) {
		return size.height - (int)((y - yMin) / (yMax - yMin) * (double)size.height);
	}

	/** Draw coordinate system with labels and ticks.
	 * 
	 * @param g Graphics context to draw on
	 */
	private void drawAxes(Graphics g) {
		int arrayLength = 10, arrowWidth = 5;
		Point origin = new Point(value2PixelX(0.0), value2PixelY(0.0));

		// Set color
		g.setColor(Color.darkGray);

		// x-axis
		g.drawLine(0, origin.y, size.width - 1, origin.y);
		g.drawString("x", size.width - 10, origin.y + 20);
		g.fillPolygon(
				new int[] {size.width - arrayLength, size.width - 1, size.width - arrayLength},
				new int[] {origin.y - arrowWidth, origin.y, origin.y + arrowWidth}, 3);

		// y-axis
		g.drawLine(origin.x, 0, origin.x, size.height - 1);
		g.drawString(function.toString(), origin.x + 10, 10);
		g.fillPolygon(
				new int[] {origin.x - arrowWidth, origin.x, origin.x + arrowWidth},
				new int[] {arrayLength, 0, arrayLength}, 3);

		// Ticks on x-axis
		for (int x = (int)Math.ceil(xMin); x <= (int)xMax; x++) {
			if (x != 0) {
				int xPixel = value2PixelX(x);
				g.drawLine(xPixel, origin.y - 5, xPixel, origin.y + 5);
				g.drawString(Integer.toString(x), xPixel - 3, origin.y + 20);
			}
		}

		// Ticks on y-axis
		for (int y = (int)Math.ceil(yMin); y <= (int)yMax; y++) {
			if (y != 0) {
				int yPixel = value2PixelY((double)y);
				g.drawLine(origin.x - 5, yPixel, origin.x + 5, yPixel);
				g.drawString(Integer.toString(y), origin.x + 10, yPixel + 5);
			}
		}
	}

	@Override
	public Dimension getPreferredSize() {
		return size;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Coordinate system
		drawAxes(g);

		// Function
		g.setColor(Color.blue);
		for (int x = 0; x < size.width - 1; x++)
			g.drawLine(x, yPixels[x], x + 1, yPixels[x + 1]);
		
		// Selected point
		int radius = 5;
		if (zeroCrossing != null) {
			g.setColor(Color.red);
			g.fillOval(startPoint.x - radius, startPoint.y - radius, 2 * radius, 2 * radius);
			g.fillOval(zeroCrossing.x - radius, zeroCrossing.y - radius, 2 * radius, 2 * radius);
			g.drawString(
					String.format("xs = %.1f", pixel2ValueX(startPoint.x)),
					startPoint.x + 2 * radius,
					startPoint.y + radius);
			g.drawString(
					String.format("x0 = %.1f", pixel2ValueX(zeroCrossing.x)),
					zeroCrossing.x + 2 * radius,
					zeroCrossing.y - 2 * radius);
		}
	}
}
