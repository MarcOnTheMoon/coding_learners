package _07_gui.c_dialogs;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/** Samples for message dialogs.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E09_MessageDialogs {

	public E09_MessageDialogs() {
		// Create and show frame
		JFrame frame = new JFrame("Message dialog example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		
		// Display dialogs
		JOptionPane.showMessageDialog(frame, "This is a plain message.", "Message", JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(frame, "This is an information message.", "Message", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(frame, "This is a warning.", "Message", JOptionPane.WARNING_MESSAGE);
	}

	public static void main(String[] args) {
		new E09_MessageDialogs();
	}
}

