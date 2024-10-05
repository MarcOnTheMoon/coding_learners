package _tello_drone;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

/** Very, very simple GUI to control a drone Tello EDU.
 * <p>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.05.27<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TelloGUI {
	private final JProgressBar batteryLevel;
	
	/**
	 * Initialize the Tello drone and GUI.
	 */
	public TelloGUI(TelloCom communication) {
		// Create frame and set properties
		JFrame frame = new JFrame("Tello EDU");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);

		// Create menu
		createAndSetMenuBar(frame);

		// Create take-off and landing buttons
		JButton takeoffButton = new JButton("Starten");		
		JButton landingButton = new JButton("Landen");

		takeoffButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				communication.sendCommand("takeoff");
				takeoffButton.setEnabled(false);
				landingButton.setEnabled(true);
			}
		});

		landingButton.setEnabled(false);
		landingButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				communication.sendCommand("land");
				takeoffButton.setEnabled(true);
				landingButton.setEnabled(false);
			}
		});

		// Create command text field and button
		JTextField commandText = new JTextField("cw 180");			// Rotate clockwise by 180 degrees
		JButton commandButton = new JButton("Sende Befehl");
		commandButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				communication.sendCommand(commandText.getText());
			}
		});
		
		// Create progress bar to display remaining battery level
		batteryLevel  = new JProgressBar(0, 100);
		batteryLevel.setBackground(Color.white);
		batteryLevel.setStringPainted(true);
		setBatteryLevel(communication.getBatteryLevel());

		// Layout
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1,3));
		buttonPanel.add(takeoffButton);
		buttonPanel.add(landingButton);
		buttonPanel.add(commandButton);

		JPanel commandPanel = new JPanel();
		commandPanel.setLayout(new BoxLayout(commandPanel, BoxLayout.X_AXIS));
		commandPanel.add(new JLabel("Befehl: "));
		commandPanel.add(commandText);

		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new ImagePanel());
		contentPane.add(buttonPanel);
		contentPane.add(commandPanel);
		contentPane.add(batteryLevel);

		// Show GUI
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * Create and set menu bar
	 * 
	 * @param frame Frame to add menu bar to
	 */
	private void createAndSetMenuBar(JFrame frame) {
		JMenuBar menuBar = new JMenuBar();
		JMenu helpMenu = new JMenu("Hilfe"); 
		JMenuItem aboutItem = new JMenuItem("Über");

		// Event handling
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame,
					"Beispiel-Anwendung zur Kontrolle einer Tello EDU-Drohne\n\n"
					+ "\u00A9 2022 Marc Hensel\nwww.haw-hamburg.de/marc-hensel",
					"Über", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		// Build menu structure and set menu bar for frame
		helpMenu.add(aboutItem);
		menuBar.add(helpMenu);
		frame.setJMenuBar(menuBar);
	}
	
	/**
	 * Set battery level in GUI
	 *  
	 * @param level Remaining battery level in percent
	 */
	public void setBatteryLevel(int level) {
		// If parameter is in range
		if ((level >= 0) && (level <= 100)) {
			// Set value
			batteryLevel.setValue(level);
			batteryLevel.setString("Battery: " + level + "% (not updated)");

			// Set progress bar's color
			if (level > 40)
				batteryLevel.setForeground(new Color(0, 150, 0));		// Green
			else if (level > 20)
				batteryLevel.setForeground(new Color(240, 240, 0));		// Yellow
			else
				batteryLevel.setForeground(new Color(255, 0, 0));		// Red
		}
	}
}
