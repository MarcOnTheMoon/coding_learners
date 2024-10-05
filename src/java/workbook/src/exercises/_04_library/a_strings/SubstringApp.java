package exercises._04_library.a_strings;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class SubstringApp {
	
	public static String getSubstring(String input, String firstWord, String lastWord) {
		int startIndex = input.indexOf(firstWord);
		int endIndex = input.indexOf(lastWord, startIndex + firstWord.length()) + lastWord.length();

		return input.substring(startIndex, endIndex);
	}
	
	public static void main(String[] args) {
		String input = "Und wer baggert da so sp�t noch am Baggerloch?";
		String firstWord = "wer";
		String lastWord = "da";
		String substring = getSubstring(input, firstWord, lastWord);
		
		System.out.println("Text      : " + input);
		System.out.println("Start     : " + firstWord);
		System.out.println("End       : " + lastWord);
		System.out.println("Extracted : " + substring);
	}
}
