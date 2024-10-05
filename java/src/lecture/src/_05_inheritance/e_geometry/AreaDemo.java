package _05_inheritance.e_geometry;

import java.util.ArrayList;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AreaDemo {
	public static void main(String[] args) {
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(new Circle(2.0, 3.0, 1.0));
		shapes.add(new Rectangle(-1.0, 0.0, 3.5, 4.0));
		shapes.add(new Square(0.0, 0.0, 2.5));
		
		double sumArea = 0.0;
		for (Shape shape : shapes) {
			sumArea += shape.getArea();
		}
		
		System.out.println("Overall area of shapes = " + sumArea);
	}
}

