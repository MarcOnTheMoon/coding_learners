package _07_gui.a_layout;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Creates simple window with labels.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E03_Labels {
	public E03_Labels() {
		// Create frame and set properties
		JFrame frame = new JFrame("Label example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);
		frame.setLayout(new GridLayout(2, 1));  // 2 rows, 1 column

		// Create labels
		ImageIcon image = new ImageIcon("resources/DocksSmall.jpg");
		JLabel label1 = new JLabel("Docks", image, JLabel.CENTER);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setVerticalTextPosition(JLabel.BOTTOM);

		JLabel label2 = new JLabel("Horizontal alignment right");
		label2.setHorizontalAlignment(JLabel.RIGHT);
		label2.setBorder(BorderFactory.createEtchedBorder(Color.RED, Color.ORANGE));

		// Add labels to content pane
		Container contentPane = frame.getContentPane();
		contentPane.add(label1);
		contentPane.add(label2);

		frame.setVisible(true);
	}
		
	public static void main(String[] args) {
		new E03_Labels();
	}
}
