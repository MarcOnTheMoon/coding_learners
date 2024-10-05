package _07_gui.a_layout;

import javax.swing.*;

/** Creates simple window.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E01_HelloWorld {
	public E01_HelloWorld() {
		JFrame frame = new JFrame("GUI example");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);
		frame.setVisible(true);		
	}
	
	public static void main(String[] args) {
		new E01_HelloWorld();
	}
}









