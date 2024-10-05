package _07_gui.a_layout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/** Creates window with panel.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E06_PaintPanel {
	public E06_PaintPanel() {
		JFrame frame = new JFrame("Panel example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);

		frame.add(new MyPaintPanel());
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new E06_PaintPanel();
	}
}

/** Panel doing some drawings.
 */
class MyPaintPanel extends JPanel {

	/** Define panel size.
	 */
	public Dimension getPreferredSize() {
		return new Dimension(300, 200);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw UML diagram
		g.setColor(Color.BLACK);
		g.drawRect(25, 50, 100, 30);			// Super class
		g.drawString("JPanel", 55, 70);
		g.drawRect(25, 120, 100, 30);			// Sub class
		g.drawString("MyPaintPanel", 40, 140);
		g.drawLine(75, 80, 75, 120);			// Arrow
		g.fillPolygon(new int[]{70, 75, 80}, new int[]{90, 80, 90}, 3);
		
		// Exclamation mark
		g.setColor(Color.RED);
		g.fillRect(202, 70, 12, 42);
		g.fillOval(200, 120, 16, 16);
	}
}

