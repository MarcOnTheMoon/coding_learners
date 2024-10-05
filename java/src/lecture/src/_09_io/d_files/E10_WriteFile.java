package _09_io.d_files;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E10_WriteFile {

	public static void main(String[] args) throws IOException {
		File file = new File("Testdatei.txt");
		FileWriter writer = new FileWriter(file);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		
		bufferedWriter.write("Dies ist die erste Zeile.");
		bufferedWriter.newLine();
		bufferedWriter.write("Und hier kommt die zweite Zeile.");
		bufferedWriter.newLine();
		bufferedWriter.close();
	}
}
