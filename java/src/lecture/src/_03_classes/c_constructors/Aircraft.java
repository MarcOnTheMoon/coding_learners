package _03_classes.c_constructors;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Aircraft {
	public String model;
	public String airline;
	public int numberEngines;

	public Aircraft() {
		numberEngines = 1;
	}

	public Aircraft(String model) {
		this();
		this.model = model;
	}

	public Aircraft(String model, String airline) {
		this(model);
		this.airline = airline;
	}
}
