package exercises._06_abstract.b_sort_iterate;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class WarehouseApp {

	public static void main(String[] args) {
		Warehouse warehouse = new Warehouse();
		warehouse.addContainer(new Container(72725462, "London"));
		warehouse.addContainer(new Container(82647552, "Hamburg"));
		warehouse.addContainer(new Container(23753255, "Melbourne"));
		warehouse.addContainer(new Container(95252532, "Bristol"));

		while (warehouse.hasNext()) {
			System.out.println(warehouse.next());
		}
	}
}
