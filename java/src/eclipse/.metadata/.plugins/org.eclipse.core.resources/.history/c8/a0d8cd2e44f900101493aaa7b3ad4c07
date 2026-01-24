package exercises._09_io.a_text;

import java.awt.Container;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SudokuApp {
	private static final String dataFile = "src/exercises/_09_io/a_text/SudokuData.txt";
	private final SudokuBlock[] blocks = new SudokuBlock[9];
	
	/** Constructor initializing game data and GUI.
	 * 
	 * @param dataFilePath Path of text file with initial Sudoku data
	 */
	private SudokuApp(String dataFilePath) {
		// Create frame and set properties
		JFrame frame = new JFrame("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Create and initialize blocks
		for (int i = 0; i < blocks.length; i++)
			blocks[i] = new SudokuBlock();
		setDataFromFile(dataFilePath);
		
		// Layout
		int border = 15, hGap = 30, vGap = 20;
		Container contentPane = frame.getContentPane();
		((JPanel)contentPane).setBorder(new EmptyBorder(border, border, border, border));
		GridLayout gridLayout = new GridLayout(3, 3);
		gridLayout.setHgap(hGap);
		gridLayout.setVgap(vGap);
		contentPane.setLayout(gridLayout);

		for (SudokuBlock block : blocks)
			contentPane.add(block);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Set game data from text file.
	 * 
	 * @param filePath Path of text file with Sudoku data
	 */
	private void setDataFromFile(String filePath) {
		// Ensure file access
		File file = new File(filePath);
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			System.out.println("WARNING Cannot read file: " + filePath);
			return;
		}
		
		try {
			// Open stream
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);

			// Add rows containing word to list
			int blockID = 0; 
			while (bufferedReader.ready() && (blockID < 9)) {
				SudokuBlock block = blocks[blockID++];
				String row = bufferedReader.readLine();
				String[] values = row.split(",");
				
				for (int i = 0; i < values.length; i++) {
					if (values[i].length() > 0) {
						block.setData(i, Integer.parseInt(values[i]));
					}
				}
			}

			// Close stream
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("WARNING File not found: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("WARNING Input/output exception");
		}
	}

	/** Main method creating and displaying GUI.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		new SudokuApp(dataFile);
	}
}

/** Sudoku sub field containing 3x3 numbers.
 */
class SudokuBlock extends JPanel {
	private final int[] data = new int[9];
	private final JLabel[] labels = new JLabel[9];
	
	/** Constructor initializing an empty block.
	 */
	SudokuBlock() {
		// Set layout
		int hGap = 15, vGap = 5;
		GridLayout gridLayout = new GridLayout(3, 3);
		gridLayout.setHgap(hGap);
		gridLayout.setVgap(vGap);
		setLayout(gridLayout);
		
		// Create and add labels
		for (int i = 0; i < labels.length; i++) {
			labels[i] = new JLabel(".");
			add(labels[i]);
		}
	}
	
	/** Set value of a specific field in the block.
	 * 
	 * @param index Index of field to set in [1,9]
	 * @param value Value to set in [1,9]
	 */
	void setData(int index, int value) {
		boolean isValidIndex = ((index >= 0) && (index < data.length));
		boolean isValidValue = ((value >= 1) && (value <= 9));
				
		if (isValidIndex && isValidValue) {
			data[index] = value;
			labels[index].setText(Integer.toString(value));
		}
	}
}