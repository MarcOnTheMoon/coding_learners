package exercises._09_io.a_text;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class LogInputApp {

	/** Application starting point.
	 * 
	 * @param args Command-line parameters (not used)
	 */
	public static void main(String[] args) throws IOException {
		String path = "output_files/";
		String fileName = "LogInput.txt";
		
		// Init file and ensure access
		File file = new File(path + fileName);

		if (!file.exists()) {
			file.createNewFile();
		}
		if (!file.exists() || !file.isFile() || !file.canWrite()) {
			System.out.println("WARNING Cannot write to file: " + file.getAbsolutePath());
			System.exit(0);
		}
		
		// Init keyboard scanner and file writer
		Scanner scanner = new Scanner(System.in);
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		// Scan text and write to file
		System.out.println("Enter text to write to file (\"stop\" to stop input):");
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			
			if (!line.equalsIgnoreCase("stop")) {
				bufferedWriter.write(line);
				bufferedWriter.newLine();
			} else {
				break;
			}
		}
		
		// Clean-up
		scanner.close();
		bufferedWriter.close();
		System.out.println("Written to file: " + path + fileName);
	}
}
