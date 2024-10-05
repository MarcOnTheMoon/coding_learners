package _07_gui.b_events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/** Creates window with button and panel.<br>br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E07_ButtonEvent implements ActionListener {
	private JPanel panel;
	private JButton buttonRed, buttonBlue, buttonRandom;

	public E07_ButtonEvent() {
		// Create frame and set properties
		JFrame frame = new JFrame("Button example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocation(50, 50);

		// Create and layout contents
		buttonRed = new JButton("Change color to red");
		buttonBlue = new JButton("Change color to blue");
		buttonRandom = new JButton("Change to random color");

		frame.setLayout(new GridLayout(4, 1));  // 4 rows, 1 column
		Container contentPane = frame.getContentPane();
		panel = new JPanel();
		contentPane.add(buttonRed);
		contentPane.add(buttonBlue);
		contentPane.add(buttonRandom);
		contentPane.add(panel);
		frame.pack();

		// Event handling for button
		buttonRed.setActionCommand("Change color to red");
		buttonRed.addActionListener(this);
		buttonBlue.setActionCommand("Change color to blue");
		buttonBlue.addActionListener(this);
		buttonRandom.setActionCommand("Change to random color");
		buttonRandom.addActionListener(this);

		// Tool tips
		buttonRed.setToolTipText("Change background color to red");
		buttonBlue.setToolTipText("Change background color to blue");
		buttonRandom.setToolTipText("Change background to random color");

		frame.setVisible(true);
	}

	/**
	 * Event handling.
	 * 
	 * @param event Event object (created by runtime)
	 */
	public void actionPerformed(ActionEvent event) {
		System.out.println(event.getActionCommand());
		System.out.println(event.getSource());

		if (event.getSource() == buttonRed) {
			panel.setBackground(Color.RED);			
		} else if (event.getSource() == buttonBlue) {
			panel.setBackground(Color.BLUE);			
		} else if (event.getSource() == buttonRandom) {
			Random	random = new Random();
			float	red = random.nextFloat();
			float	green = random.nextFloat();
			float	blue = random.nextFloat();
			Color	color = new Color(red, green, blue);

			panel.setBackground(color);			
		}
	}

	public static void main(String[] args) {
		new E07_ButtonEvent();
	}
}
