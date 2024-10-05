package exercises._07_gui.a_dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

/** Panel showing a die.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceImagePanel extends JPanel {
	private final int diceSize = 150;
	private final int boarderSize = 50;
	private int diceValue = 1;

	/** Change the displayed dice value.
	 *  
	 * @param diceValue New value to display
	 */
	public void setDiceValueAndRepaint(int diceValue) {
		if ((diceValue >= 1) && (diceValue <= 6)) {
			this.diceValue = diceValue;
			repaint();
		}
	}
	
	/** Define panel size.
	 */
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(diceSize + 2 * boarderSize, diceSize + 2 * boarderSize);
	}
	
	/** Draw the basic dice without the points on it.
	 */
	private void drawDiceWithoutPoints(Graphics g) {
		int arcSize = 10; 
		int innerFrame = 3;
		int innerSize = diceSize - 2 * innerFrame;
		
		g.setColor(Color.LIGHT_GRAY);
		g.fillRoundRect(boarderSize, boarderSize, diceSize, diceSize, arcSize, arcSize);
		g.setColor(Color.WHITE);
		g.fillRoundRect(boarderSize + innerFrame, boarderSize + innerFrame, innerSize, innerSize, arcSize, arcSize);
		g.setColor(Color.BLACK);
		g.drawRoundRect(boarderSize, boarderSize, diceSize, diceSize, arcSize, arcSize);
	}
	
	/** Draw the points to be displayed on the dice.
	 */
	private void drawDicePoints(Graphics g) {
		int diameter = 30;
		int center = boarderSize + diceSize / 2 - diameter/2;
		int delta = diceSize / 4;

		switch (diceValue) {
			case 1 -> g.fillOval(center, center, diameter, diameter);
			case 2 -> {
				g.fillOval(center - delta, center + delta, diameter, diameter);
				g.fillOval(center + delta, center - delta, diameter, diameter);
			}
			case 3 -> {
				g.fillOval(center, center, diameter, diameter);
				g.fillOval(center - delta, center + delta, diameter, diameter);
				g.fillOval(center + delta, center - delta, diameter, diameter);
			}
			case 4 -> {
				g.fillOval(center - delta, center - delta, diameter, diameter);
				g.fillOval(center - delta, center + delta, diameter, diameter);
				g.fillOval(center + delta, center - delta, diameter, diameter);
				g.fillOval(center + delta, center + delta, diameter, diameter);
			}
			case 5 -> {
				g.fillOval(center, center, diameter, diameter);
				g.fillOval(center - delta, center - delta, diameter, diameter);
				g.fillOval(center - delta, center + delta, diameter, diameter);
				g.fillOval(center + delta, center - delta, diameter, diameter);
				g.fillOval(center + delta, center + delta, diameter, diameter);
			}
			case 6 -> {
				g.fillOval(center, center - delta, diameter, diameter);
				g.fillOval(center, center + delta, diameter, diameter);
				g.fillOval(center - delta, center - delta, diameter, diameter);
				g.fillOval(center - delta, center + delta, diameter, diameter);
				g.fillOval(center + delta, center - delta, diameter, diameter);
				g.fillOval(center + delta, center + delta, diameter, diameter);
			}
		}
	}
	
	/** Redraw the panel with the dice.
	 */
	@Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);

		drawDiceWithoutPoints(g);
		drawDicePoints(g);
	}
}
