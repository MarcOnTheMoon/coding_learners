package exercises._07_gui.d_plants_and_widgets;

import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SliderApp {
	
	/** Constructor creating and displaying frame.
	 */
	private SliderApp() {
		// Create frame and set properties
		JFrame frame = new JFrame("Schieberegler und Fortschritt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Elements
		int initialValue = 10;
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 100, initialValue);
		JProgressBar progress = new JProgressBar(JProgressBar.HORIZONTAL);
		
		progress.setValue(initialValue);
		progress.setString(Integer.toString(initialValue));
		progress.setStringPainted(true);

		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent event) {
				int selectedValue = slider.getValue();
				progress.setValue(selectedValue);
				progress.setString(Integer.toString(selectedValue));
			}	
		});
		
		// Layout
		int border = 10;		
		Container contentPane = frame.getContentPane();
		((JPanel)contentPane).setBorder(new EmptyBorder(border, border, border, border));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(new JLabel("Der Wert des Schiebereglers ..."));
		contentPane.add(slider);
		contentPane.add(new JLabel(" "));
		contentPane.add(new JLabel("... wird an den Fortschrittsbalken weitergegeben."));
		contentPane.add(progress);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);		
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new SliderApp();
	}
}
