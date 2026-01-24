package exercises._07_gui.e_audio;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/** Sample solution.
 *
 * @author (<a href="http://www.haw-hamburg.de/marc-hensel">Marc Hensel</a>)
 */
public class PlotPanel extends JPanel {
	private final short[] data;
	private final String labelX, labelY;
	private final Dimension dimension;
	private final Point originOffset;

	/** Instantiate panel.
	 * 
	 * @param data Data to plot
	 * @param labelX Label to print at x-axis
	 * @param labelY Label to print at y-axis
	 * @param dimension Panel dimension in width x height pixel
	 * @param originOffset Offset of origin in pixel
	 */
	public PlotPanel(short[] data, String labelX, String labelY, Dimension dimension, Point originOffset) {
		super();
		this.data = data;
		this.labelX = labelX;		
		this.labelY = labelY;		
		this.dimension = (Dimension)dimension.clone();
		this.originOffset = (Point)originOffset.clone();
		
		this.setBackground(Color.white);
	}
	
	@Override
	public Dimension getPreferredSize() {
		return dimension;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Draw axes
		int width = dimension.width;
		int height = dimension.height;
		int yc = (height - 1) - originOffset.y;
		
		g.setColor(Color.darkGray);
		g.drawLine(0, yc, width - 1, yc);
		g.drawLine(originOffset.x, 0, originOffset.x, height - 1);
		g.drawString(labelX, width - 15, yc - 5);
		g.drawString(labelY, originOffset.x + 5, 15);
		
		// Draw data
		g.setColor(Color.blue);
		for (int x = 0; x < data.length - 1; x++)
			g.drawLine(x, yc - data[x], x + 1, yc - data[x + 1]);
	}
}
