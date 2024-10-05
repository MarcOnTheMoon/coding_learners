package exercises._06_abstract.b_sort_iterate;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Container implements Comparable<Container> {
	private final int trackingID;
	private final String destination;
	
	public Container(int trackingID, String destination) {
		super();
		this.trackingID = trackingID;
		this.destination = destination;
	}

	public int getTrackingID() {
		return trackingID;
	}

	public String getDestination() {
		return destination;
	}

	@Override
	public int compareTo(Container other) {
		return destination.compareToIgnoreCase(other.destination);
	}

	@Override
	public String toString() {
		return String.format("Container No.%d to %s", trackingID, destination);
	}
}
