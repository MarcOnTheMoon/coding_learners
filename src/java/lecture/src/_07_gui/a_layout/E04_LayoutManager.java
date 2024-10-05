package _07_gui.a_layout;

import java.awt.Container;
import java.awt.GridLayout;

//import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/** Creates window with layout.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E04_LayoutManager {
	public E04_LayoutManager() {
		// Create frame and set properties
		JFrame frame = new JFrame("Layout example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);

		// Create contents
		Container contentPane = frame.getContentPane();
//		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
//		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.setLayout(new GridLayout(2, 2));
		contentPane.add(new JButton("Auf die"));
		contentPane.add(new JButton("Plätze"));
		contentPane.add(new JButton("fertig"));
		contentPane.add(new JButton("los!"));

		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new E04_LayoutManager();
	}
}
