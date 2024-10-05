package exercises._05_inheritance.c_super_class;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Duration {
	private int minutes, seconds;
	
	public Duration(int minutes, int seconds) {
		int secondsOverall = 60 * minutes + seconds;	// In case seconds > 60
		
		this.minutes = secondsOverall / 60;
		this.seconds = secondsOverall % 60;
	}

	public Duration(String time) {
		String[] minSecs = time.split(":");
		
		if (minSecs.length == 2) {
			this.minutes = Integer.parseInt(minSecs[0]);
			this.seconds = Integer.parseInt(minSecs[1]);
		}
	}
	
	public int getMinutes() {
		return minutes;
	}

	public int getSeconds() {
		return seconds;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", minutes, seconds);
	}
}
