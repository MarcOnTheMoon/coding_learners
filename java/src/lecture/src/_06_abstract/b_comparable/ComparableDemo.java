package _06_abstract.b_comparable;

import java.util.ArrayList;
import java.util.Collections;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ComparableDemo {
	public static void main(String[] args) {
		ArrayList<Vector2D> vectors = new ArrayList<Vector2D>();
		vectors.add(new Vector2D(0, 5));
		vectors.add(new Vector2D(0, -1));
		vectors.add(new Vector2D(7, 8));
		vectors.add(new Vector2D(0, 0));

		Collections.sort(vectors);
		for (Vector2D vector : vectors) {
			System.out.println(vector.getAbs());
		}
	}
}
