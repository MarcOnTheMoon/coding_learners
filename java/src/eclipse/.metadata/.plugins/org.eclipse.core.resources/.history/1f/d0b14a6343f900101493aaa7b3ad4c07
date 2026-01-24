package exercises._06_abstract.b_sort_iterate;

import java.util.ArrayList;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class Warehouse implements Iterator {
	private final ArrayList<Container> containers = new ArrayList<Container>();
	private int iteratorNextIndex;
	
	public void addContainer(Container container) {
		containers.add(container);
	}
	
	public void removeContainer(Container container) {
		containers.remove(container);
	}

	@Override
	public Object next() {
		Object object = null;
		
		if (hasNext()) {
			object = (Object) containers.get(iteratorNextIndex++);
		}
		return object;
	}

	@Override
	public boolean hasNext() {
		return iteratorNextIndex < containers.size();
	}

	@Override
	public void reset() {
		iteratorNextIndex = 0;	
	}
}
