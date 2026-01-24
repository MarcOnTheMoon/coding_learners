package exercises._06_abstract.b_sort_iterate;

import java.util.ArrayList;
import java.util.Collections;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ContainerApp {

	public static void main(String[] args) {
		ArrayList<Container> containers = new ArrayList<Container>();
		
		// Create unsorted list of containers and print to the console
		containers.add(new Container(72725462, "London"));
		containers.add(new Container(82647552, "Hamburg"));
		containers.add(new Container(23753255, "Melbourne"));
		containers.add(new Container(95252532, "Bristol"));

		System.out.println("Initial list:");
		for (Container container : containers) {
			System.out.println(container);
		}

		// Sort list and print to the console
		Collections.sort(containers);
		
		System.out.println("\nSorted by destination:");
		for (Container container : containers) {
			System.out.println(container);
		}
	}
}
