package exercises._04_library.a_strings;

import javax.swing.JOptionPane;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ParseKeyValueApp {

	public static void main(String[] args) {
		String key = null, value = null;

		// Get user input
		String input = JOptionPane.showInputDialog("Enter key and value (formatted \\\"key=value\\\")");
		
		// Identify separator '='
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '=') {
				key = input.substring(0, i);
				value = input.substring(i + 1);
				break;
			}
		}

		// Print input and result to the console
		if ((key != null) && (value != null))
			System.out.printf("Input : %s\nKey   : %s\nValue : %s\n", input, key, value);
	}
}
