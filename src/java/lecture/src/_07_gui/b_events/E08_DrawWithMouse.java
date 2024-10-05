package _07_gui.b_events;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;


/** Simple drawing application.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E08_DrawWithMouse extends MouseAdapter {
	private static MyDrawPanel panel;

	public E08_DrawWithMouse() {
		// Create frame and set properties
		JFrame frame = new JFrame("Mouse input example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);
		
		panel = new MyDrawPanel();
		panel.addMouseListener(this);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Event handling.
	 * 
	 * @param event Event object (created by runtime)
	 */
	public void mousePressed(MouseEvent event) {
		if (event.getButton() == 1) {
			System.out.printf("(x,y) = (%d, %d)\n", event.getX(), event.getY());
			panel.addPoint(event.getX(), event.getY());
		} else if (event.getButton() == 3) {
			System.out.println("Clear panel");
			panel.clear();
		}
	}

	public static void main(String[] args) {
		new E08_DrawWithMouse();
	}
}


/**
 * Panel to draw on.
 * 
 * @author Marc Hensel
 * @version 2016-05-12
 */
class MyDrawPanel extends JPanel {
	// Arrays holding the coordinates of the polygon's points
	private ArrayList<Integer> listCoordsX = new ArrayList<Integer>();
	private ArrayList<Integer> listCoordsY = new ArrayList<Integer>();
	
	/** Create instance.
	 * <br>
	 * Marks the panel border with a black line.
	 */
	public MyDrawPanel() {
		setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	/** Set panel size.
	 */
	public Dimension getPreferredSize() {
		return new Dimension(400,400);
	}
	
	/** Add point to polygon and repaint.
	 * 
	 * @param x x coordinate of point to add 
	 * @param y y coordinate of point to add
	 */
	public void addPoint(int x, int y) {
		listCoordsX.add(x);
		listCoordsY.add(y);
		repaint();
	}
	
	/** Clear list and repaint.
	 */
	public void clear() {
		listCoordsX.clear();
		listCoordsY.clear();
		repaint();
	}
	
	/** Repaint: Draw polygon in panel.
	 * 
	 * @param g Graphics to paint on
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.drawString("Left mouse button to set new point", 10, 20);
		g.drawString("Right mouse button to clear panel", 10, 40);

		int numberPoints = listCoordsX.size();
		if (numberPoints > 1) {
			for (int i = 1; i < numberPoints; i++) {
				g.drawLine(
					listCoordsX.get(i - 1), 
					listCoordsY.get(i - 1), 
					listCoordsX.get(i), 
					listCoordsY.get(i)
				);
			}
		}
	}
}
