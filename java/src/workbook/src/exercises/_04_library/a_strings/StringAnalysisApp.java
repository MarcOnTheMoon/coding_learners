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
public class StringAnalysisApp {

	public static void main(String[] args) {
		int numberVocals = 0;
		int numberConsonants = 0;
		String input = JOptionPane.showInputDialog("Please enter a text to analyze");
		
		// Print input to the console
		System.out.println("Text       : " + input);

		// Count vocals and consonants
		input = input.toLowerCase();
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
//			boolean isLetter = (character >= 'a') && (character <= 'z');	// Using char
			boolean isLetter = Character.isLetter(character);				// Using Character
			
			// Is character a letter?
			if (isLetter) {
				switch (character) {
					case 'a', 'e', 'i', 'o', 'u' -> numberVocals++;
					default -> numberConsonants++;
				}
			}
		}
		
		// Print results to console
		System.out.println("Vocals     : " + numberVocals);
		System.out.println("Consonants : " + numberConsonants);
	}
}
