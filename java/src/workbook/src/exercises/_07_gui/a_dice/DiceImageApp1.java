package exercises._07_gui.a_dice;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceImageApp1 {

	/** Constructor creating and displaying frame.
	 */
	private DiceImageApp1() {
		// Create frame and set properties
		JFrame frame = new JFrame("Würfel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Drawing panel
		DiceImagePanel diceImagePanel = new DiceImagePanel();

		// Button
		JButton rollButton = new JButton("Würfeln");
		rollButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// Roll dice and display result
				int diceValue = (int) Math.round(6.0 * Math.random() + 0.5);
				diceImagePanel.setDiceValueAndRepaint(diceValue);
			}
		});
		
		// Layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(rollButton);
		
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(diceImagePanel);
		contentPane.add(buttonPanel);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new DiceImageApp1();
	}
}

