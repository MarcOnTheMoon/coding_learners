package exercises._03_classes.b_methods_constructors;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TimePeriod {
	int periodSeconds;
	
	TimePeriod(int hours, int minutes, int seconds) {
		setPeriod(hours, minutes, seconds);
	}
	
	int getHours() {
		return periodSeconds / (60 * 60);
	}
	
	int getMinutes() {
		return (periodSeconds / 60) % 60;
	}

	int getSeconds() {
		return periodSeconds % 60;
	}

	void setPeriod(int hours, int minutes, int seconds) {
		periodSeconds = 60 * (60 * hours + minutes) + seconds;
	}
	
	void addSeconds(int seconds) {
		periodSeconds += seconds;
	}
	
	void printFormatted() {
		System.out.printf("%d:%02d:%02d", getHours(), getMinutes(), getSeconds());
	}
}
