package _04_library.b_arrays;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class ArraySortingDemo {

	public static void sort(int[] a) {
		int i = 0;
		while (i <= a.length - 2) {
			if (a[i] > a[i+1]) {
				// Swap elements and shift index to left element
				int temp = a[i];
				a[i] = a[i+1];
				a[i+1] = temp;
				if (i > 0) {
					i--;
				}
			} else {
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		// Create data and print to console
		int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 7};
		
		System.out.print("Unsorted\t: ");
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.print("\n");
		
		// Sort array and print to console
		sort(array);		
		System.out.print("Sorted\t\t: ");
		for (int number : array) {
			System.out.print(number + " ");
		}
		System.out.print("\n");
	}
}
