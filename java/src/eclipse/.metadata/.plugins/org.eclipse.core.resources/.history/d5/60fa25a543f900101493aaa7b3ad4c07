package exercises._07_gui.a_dice;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceApp2 implements ActionListener {
	private final String ACTION_CMD_ROLL = "Roll";
	private JLabel resultLabel;
	
	/** Constructor creating and displaying frame.
	 */
	private DiceApp2() {
		// Create frame and set properties
		JFrame frame = new JFrame("Würfel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Initialize menu and contents
		createAndSetMenuBar(frame);
		createAndSetContentPane(frame);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Init menu bar.
	 * 
	 * @param frame Frame to add bar to
	 */
	private void createAndSetMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		JMenu playMenu = new JMenu("Spielen");
		JMenuItem rollItem = new JMenuItem("Würfeln");
		
		// Component layout
		menuBar.add(playMenu);
		playMenu.add(rollItem);		
		frame.setJMenuBar(menuBar);
		
		// Event handling
		rollItem.setActionCommand(ACTION_CMD_ROLL);
		rollItem.addActionListener(this);
	}
	
	/** Init content pane.
	 * 
	 * @param frame Frame of which to initialize content
	 */
	private void createAndSetContentPane(JFrame frame) {
		// Label
		resultLabel = new JLabel("?");
		resultLabel.setFont(new Font("Arial", Font.PLAIN, 71));
		resultLabel.setHorizontalAlignment(JLabel.CENTER);

		// Button
		JButton rollButton = new JButton("Würfeln");		
		rollButton.setActionCommand(ACTION_CMD_ROLL);
		rollButton.addActionListener(this);
				
		// Layout
		JPanel labelPanel = new JPanel();
		labelPanel.setPreferredSize(new Dimension(250, 90));
		labelPanel.add(resultLabel);

		JPanel buttonPanel = new JPanel();
		rollButton.setMaximumSize(new Dimension(250, 40));
		buttonPanel.add(rollButton);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(labelPanel);
		contentPane.add(buttonPanel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals(ACTION_CMD_ROLL)) {
			// Roll dice and display result
			int diceResult = (int)(6.0 * Math.random()) + 1;
			resultLabel.setText(Integer.toString(diceResult));
		}
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new DiceApp2();
	}
}
