package _08_exceptions.c_custom_classes;

class MyException extends Exception {
	public MyException(String message) {
		super(message);
	}
}

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E15_OwnExceptionWithMessage {
	
	public static void main(String[] args) {
		try {
			throw new MyException("An exception just for fun :-) ...");
		} catch (MyException e) {
			System.out.println("Message: " + e.getMessage());
		}
	}
}
