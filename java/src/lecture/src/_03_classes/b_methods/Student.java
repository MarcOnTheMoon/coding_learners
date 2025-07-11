package _03_classes.b_methods;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Student {
	String name;
	int matrNumber;
	int enrolledYear;

	String getName() {
		return name;
	}

	void setName(String newName) {
		name = newName;
	}

	void printName() {
		System.out.println(name);
	}
}
