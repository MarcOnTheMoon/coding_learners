package exercises._07_gui.a_dice;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceApp1 {
	
	/** Constructor creating and displaying frame.
	 */
	private DiceApp1() {
		// Create frame and set properties
		JFrame frame = new JFrame("Würfel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		frame.setSize(250, 100);
		
		// Label
		JLabel resultLabel = new JLabel("Zum Würfeln Button drücken");
		
		// Button
		JButton rollButton = new JButton("Würfeln");
		rollButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Roll dice and display result
				int diceResult = (int)(6.0 * Math.random()) + 1;
				resultLabel.setText("Ergebnis: " + diceResult);
			}
		});
		
		// Layout
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new GridLayout(2, 1));
		contentPane.add(resultLabel);
		contentPane.add(rollButton);
		
		// Show frame
		frame.setVisible(true);
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new DiceApp1();
	}
}
