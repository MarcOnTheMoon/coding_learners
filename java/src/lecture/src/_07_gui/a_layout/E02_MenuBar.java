package _07_gui.a_layout;

import javax.swing.*;

/** Creates simple window with menu bar.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E02_MenuBar {
	public E02_MenuBar() {
		// Create frame and set properties
		JFrame frame = new JFrame("Menu bar example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);

		// Create menu bar and add to frame
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		// Create menu "File"
		JMenu menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuFile.add(new JMenuItem("Open"));
		menuFile.add(new JMenuItem("Save"));
		menuFile.addSeparator();
		menuFile.add(new JMenuItem("Exit"));

		// Create menu "Help"
		JMenu menuHelp = new JMenu("Help");
		menuBar.add(menuHelp);
		menuHelp.add(new JMenuItem("About"));		

		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new E02_MenuBar();
	}
}

