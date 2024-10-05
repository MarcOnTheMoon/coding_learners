package exercises._07_gui.b_vat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class VATApp1 {
	
	/** Constructor creating and displaying frame.
	 */
	private VATApp1() {
		// Create frame and set properties
		JFrame frame = new JFrame("MwSt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);

		// Label
		JLabel vatLabel = new JLabel("0,00 €");
		
		// Text field
		JTextField grossText = new JTextField("0,00");
		grossText.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {
				// Get entered gross
				String input = grossText.getText();
				input = input.replace(',', '.');		// Locale for decimal places from US to DE
				
				// Determine and set VAT
				// Note: try/catch to be added in task for chapter on exception handling 
				try {
					double gross = Double.parseDouble(input);
					double net = gross / 1.19;
					vatLabel.setText(String.format("%.2f €", gross - net));
				} catch (NumberFormatException e) {
					vatLabel.setText("Fehlerhafte Eingabe!");
				}
			}
		});
		
		// Layout: Add border to content pane
		int border = 5;		
		Container contentPane = frame.getContentPane();
		JPanel contentPanelRef = (JPanel)contentPane; 
		contentPanelRef.setBorder(new EmptyBorder(border, border, border, border));

		// Layout: Add content
		contentPane.setLayout(new GridLayout(2, 2, 2 * border, border));
		contentPane.add(new JLabel("Bruttobetrag:"));
		contentPane.add(grossText);
		contentPane.add(new JLabel("Enthaltene MwSt (19 %):"));
		contentPane.add(vatLabel);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);		
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new VATApp1();
	}
}
