package _07_gui.a_layout;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Creates window with nested layouts using class JPanel.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E05_PanelLayout {
	public E05_PanelLayout() {
		// Create frame and set properties
		JFrame frame = new JFrame("Layout example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,  300);
		frame.setLocation(50, 50);

		// Create contents
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(new JButton("Rechts"));
		panel1.add(new JButton("oben"));

		JPanel panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		panel2.add(new JButton("Links"));
		panel2.add(new JButton("unten"));
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(2, 2));
		contentPane.add(new JLabel("Links oben", JLabel.CENTER));
		contentPane.add(panel1);
		contentPane.add(panel2);
		contentPane.add(new JLabel("Rechts unten", JLabel.CENTER));
		
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		new E05_PanelLayout();
	}
}
