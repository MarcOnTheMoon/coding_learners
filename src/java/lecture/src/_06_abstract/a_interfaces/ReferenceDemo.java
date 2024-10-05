package _06_abstract.a_interfaces;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ReferenceDemo {
	public static void main(String[] args) {
		Vector2D classRef = new Vector2D(1, 3);
		Scalable interRef = classRef;
		
		classRef.resize(1.5);
		System.out.println(classRef.getX());

		interRef.resize(1.5);
//		System.out.println(interRef.getX());
	}
}
