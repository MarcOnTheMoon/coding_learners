package _04_library.b_arrays;

import java.util.ArrayList;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ArrayListDemo {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		String birgit = "Birgit";
		
		names.add("Lena");
		names.add(birgit);
		names.add(new String("Jan"));
		
		for (int i = 0; i < names.size(); i++) {
			System.out.println(names.get(i));
		}
		
		if (names.contains(birgit)) {
			names.remove(birgit);
		}
	}
}
