package _03_classes.d_static;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class CircleDemo {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Circle circle1 = new Circle();
		Circle circle2 = new Circle();
		Circle circle3 = new Circle();
		
		System.out.println("Anzahl Objekte: " + Circle.count);
		
		System.out.println("Pi: " + Circle.getPi());
	}
}
