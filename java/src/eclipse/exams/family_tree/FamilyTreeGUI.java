package family_tree;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FamilyTreeGUI implements ActionListener, ListSelectionListener {
	@SuppressWarnings("rawtypes")
	DefaultListModel listModel = new DefaultListModel();
	private JLabel selectedLabel = new JLabel("");
	private JLabel motherLabel = new JLabel("");
	private JLabel fatherLabel = new JLabel("");

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FamilyTreeGUI() {
		// Frame initialization
		JFrame frame = new JFrame("Stammbaum: Bitte Person ausw�hlen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(50, 50);

		// List
		JList memberList = new JList(listModel);
		JScrollPane scrollPane = new JScrollPane(memberList);
		scrollPane.setPreferredSize(new Dimension(500, 200));
		memberList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		// Information text labels
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(3, 2));
		textPanel.add(new JLabel("Ausgew�hlt:"));
		textPanel.add(selectedLabel);
		textPanel.add(new JLabel("Mutter:"));
		textPanel.add(motherLabel);
		textPanel.add(new JLabel("Vater:"));
		textPanel.add(fatherLabel);

		// Buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 2));
		JButton populateButton = new JButton("Initialisieren");
		JButton saveButton = new JButton("Liste speichern");
		buttonPanel.add(populateButton);
		buttonPanel.add(saveButton);

		// Event handling list
		memberList.addListSelectionListener(this);
		populateButton.setActionCommand("Populate");
		populateButton.addActionListener(this);
		saveButton.setActionCommand("SaveList");
		saveButton.addActionListener(this);
		
		// Layout
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(scrollPane);
		contentPane.add(textPanel);
		contentPane.add(buttonPanel);
		
		// Show GUI
		frame.pack();
		frame.setVisible(true);
	}
	
	@SuppressWarnings("unchecked")
	private void initFamilyMembers() {
		FamilyMember abraham = new FamilyMember("Abraham", "Simpson", 1909, true);
		FamilyMember homer = new FamilyMember("Homer", "Simpson", 1956, true);
		FamilyMember marge = new FamilyMember("Marge", "Bouvier", 1958, false);		
		FamilyMember bart = new FamilyMember("Bart", "Simpson", 1982, true);
		FamilyMember lisa = new FamilyMember("Lisa", "Simpson", 1984, false);
		FamilyMember maggy = new FamilyMember("Maggy", "Simpson", 1991, false);
		homer.setFather(abraham);
		bart.setFather(homer);
		bart.setMother(marge);		
		lisa.setFather(homer);
		lisa.setMother(marge);
		maggy.setFather(homer);
		maggy.setMother(marge);

		listModel.addElement(abraham);
		listModel.addElement(homer);
		listModel.addElement(marge);
		listModel.addElement(bart);
		listModel.addElement(lisa);
		listModel.addElement(maggy);		
	}
	
	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new FamilyTreeGUI();
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void valueChanged(ListSelectionEvent e) {
		JList memberList = (JList) e.getSource();

		// Set label for selected family member
		FamilyMember selectedMember = (FamilyMember) listModel.getElementAt(memberList.getSelectedIndex());
		String label = String.format("%s %s", selectedMember.getFirstName(), selectedMember.getSurname());
		selectedLabel.setText(label);

		// Set label for selected family member's mother
		if (selectedMember.getMother() != null) {
			label = String.format("%s %s", selectedMember.getMother().getFirstName(), selectedMember.getMother().getSurname());
			motherLabel.setText(label);
		} else {
			motherLabel.setText("");
		}

		// Set label for selected family member's father
		if (selectedMember.getFather() != null) {
			label = String.format("%s %s", selectedMember.getFather().getFirstName(), selectedMember.getFather().getSurname());
			fatherLabel.setText(label);
		} else {
			fatherLabel.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {

		// TODO: remove for PVL
		// Init family members
		if (event.getActionCommand().equals("Populate")) {
			initFamilyMembers();
		}

		// Save list
		if (event.getActionCommand().equals("SaveList")) {
			// Select destination file
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
			fileChooser.setApproveButtonText("Speichern");
			fileChooser.setDialogTitle("Liste speichern");
			fileChooser.setSelectedFile(new File("FamilyTree.ser"));
			
			// Save data to file
			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				String filePath = fileChooser.getSelectedFile().getAbsolutePath();

				try {
					FileOutputStream fileStream = new FileOutputStream(filePath);
					ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);

					objectStream.writeObject(listModel);
					objectStream.close();
				} catch (IOException e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		}
	}
}
