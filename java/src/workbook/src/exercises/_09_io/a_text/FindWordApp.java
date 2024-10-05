package exercises._09_io.a_text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class FindWordApp {
	private static final String textFile = "src/exercises/_09_io/a_text/DunkelGedicht.txt";
	private static final String word = "mit";

	/** Find all rows in text file containing a specific word.
	 * 
	 * @param file Source text file
	 * @param word Word to search for 
	 * @return all rows in the file containing the word
	 */
	private static ArrayList<String> getFileRowsContainingWord(File file, String word) {
		ArrayList<String> rows = new ArrayList<String>();
		
		try {
			// Open stream
			FileReader reader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(reader);

			// Add rows containing word to list
			while (bufferedReader.ready()) {
				String row = bufferedReader.readLine();
				if (row.contains(word))
					rows.add(row);
			}

			// Close stream
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("WARNING File not found: " + file.getAbsolutePath());
		} catch (IOException e) {
			System.out.println("WARNING Input/output exception");
		}
		
		return rows;
	}
	
	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) {
		File file = new File(textFile);
		
		// Ensure file access
		if (!file.exists() || !file.isFile() || !file.canRead()) {
			System.out.println("WARNING Cannot read file: " + file.getAbsolutePath());
			System.exit(0);
		}
		
		// Get file rows containing WORD
		ArrayList<String> rows = getFileRowsContainingWord(file, word);

		// Print result to console
		System.out.printf("Word \"%s\" found %d times.\n", word, rows.size());
		for (int i = 0; i < rows.size(); i++) {
			System.out.printf("%2d: %s\n", i + 1, rows.get(i));
		}
	}

}
