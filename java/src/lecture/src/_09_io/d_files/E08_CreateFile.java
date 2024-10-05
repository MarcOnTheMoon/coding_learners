package _09_io.d_files;

import java.io.File;
import java.io.IOException;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E08_CreateFile {

	public static void main(String[] args) throws IOException {
		File file = new File("Testdatei.txt");
		boolean isExists = file.exists();

		if (!isExists) {
			System.out.println("Datei erzeugen");
			isExists = file.createNewFile();
		}

		if (isExists && file.isFile()) {
			System.out.println("Lesen: " + file.canRead());
			System.out.println("Schreiben: " + file.canWrite());
			file.delete();
		}
	}
}
