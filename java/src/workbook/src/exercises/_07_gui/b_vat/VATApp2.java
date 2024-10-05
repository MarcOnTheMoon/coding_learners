package exercises._07_gui.b_vat;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
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
public class VATApp2 {
	
	/** Constructor creating and displaying frame.
	 */
	private VATApp2() {
		// Create frame and set properties
		JFrame frame = new JFrame("MwSt");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);

		// Elements
		JLabel vatLabel = new JLabel("0,00 €");
		JLabel vatDescriptionLabel = new JLabel("Enthaltene MwSt (19 %):");
		JTextField grossText = new JTextField("0,00");
		JCheckBox vat7Box = new JCheckBox("Verminderter Steuersatz");
		
		// Event handling
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// Get entered gross
				String input = grossText.getText();
				input = input.replace(',', '.');		// Locale for decimal places from US to DE
				
				// Determine and set VAT
				// Note: try/catch to be added in task for chapter on exception handling 
				try {
					int vatPercent = (vat7Box.isSelected()) ? 7 : 19; 
					double gross = Double.parseDouble(input);
					double net = gross / (1.0 + vatPercent / 100.0);
					
					vatDescriptionLabel.setText(String.format("Enthaltene MwSt (%d %%):", vatPercent));
					vatLabel.setText(String.format("%.2f €", gross - net));
				} catch (NumberFormatException e) {
					vatLabel.setText("Fehlerhafte Eingabe!");
				}
			}
		};
		
		grossText.addActionListener(actionListener);
		vat7Box.addActionListener(actionListener);
		
		// Layout: Calculation panel
		int border = 5;		
		JPanel calcPanel = new JPanel();
		calcPanel.setLayout(new GridLayout(3, 2, 2 * border, border));
		calcPanel.add(new JLabel("Bruttobetrag:"));
		calcPanel.add(grossText);
		calcPanel.add(vatDescriptionLabel);
		calcPanel.add(vatLabel);

		// Layout: Button panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(vat7Box);
		
		// Layout: Content pane
		Container contentPane = frame.getContentPane();
		((JPanel)contentPane).setBorder(new EmptyBorder(border, border, border, border));
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(calcPanel);
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
		new VATApp2();
	}
}
