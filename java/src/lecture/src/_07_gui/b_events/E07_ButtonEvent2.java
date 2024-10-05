package _07_gui.b_events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

/** Creates window with button and panel.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E07_ButtonEvent2 {
	private JPanel panel;

	public E07_ButtonEvent2() {
		// Create frame and set properties
		JFrame frame = new JFrame("Button example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 200);
		frame.setLocation(50, 50);

		// Create and layout contents
		JButton buttonRed = new JButton("Change color to red");
		JButton buttonBlue = new JButton("Change color to blue");
		JButton buttonRandom = new JButton("Change to random color");

		frame.setLayout(new GridLayout(4, 1));  // 4 rows, 1 column
		Container contentPane = frame.getContentPane();
		panel = new JPanel();
		contentPane.add(buttonRed);
		contentPane.add(buttonBlue);
		contentPane.add(buttonRandom);
		contentPane.add(panel);
		frame.pack();

		// Event handling for button
		buttonRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				panel.setBackground(Color.RED);			
			}
		});
		
		buttonBlue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				panel.setBackground(Color.BLUE);			
			}
		});
		
		buttonRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				Random	random = new Random();
				float	red = random.nextFloat();
				float	green = random.nextFloat();
				float	blue = random.nextFloat();
				Color	color = new Color(red, green, blue);

				panel.setBackground(color);			
			}
		});

		// Tool tips
		buttonRed.setToolTipText("Change background color to red");
		buttonBlue.setToolTipText("Change background color to blue");
		buttonRandom.setToolTipText("Change background to random color");

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new E07_ButtonEvent2();
	}
}
