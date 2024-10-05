package _06_abstract._geometry;

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
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(0.0, 0.0, 2.0));
		shapes.add(new Circle(0.0, 0.0, 1.0));
		shapes.add(new Rectangle(0.0, 0.0, 10.0, 5.0));
		shapes.add(new Square(0.0, 0.0, 0.5));

		System.out.println("Fl�chen (unsortiert):");
		for (Shape shape : shapes) {
			System.out.println(shape.getArea());
		}

		Collections.sort(shapes);
		System.out.println("\nFl�chen (sortiert):");
		for (Shape shape : shapes) {
			System.out.println(shape.getArea());
		}
	}
}
