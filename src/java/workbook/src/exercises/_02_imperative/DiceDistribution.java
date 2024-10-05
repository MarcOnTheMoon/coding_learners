package exercises._02_imperative;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class DiceDistribution {
	public static void main(String[] args) {
		int numberThrows = (int)(100 * 1.e6);
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0;
		
		// Throw dice n times
		for (long i = 0; i < numberThrows; i++) {
			int number = (int)(6.0 * Math.random()) + 1;
			
			if (number == 1)
				count1++;
			else if (number == 2)
				count2++;
			else if (number == 3)
				count3++;
			else if (number == 4)
				count4++;
			else if (number == 5)
				count5++;
			else if (number == 6)
				count6++;
			else
				System.out.println("Dieses Ergebnis gibt es nicht: " + number);
		}
		
		// Print percentage of thrown numbers
		System.out.println("Anzahl: " + numberThrows / (int)1.e6 + " Millionen");
		System.out.println("Augenzahl 1: " + 100 * count1 / (double) numberThrows + " %");
		System.out.println("Augenzahl 2: " + 100 * count2 / (double) numberThrows + " %");
		System.out.println("Augenzahl 3: " + 100 * count3 / (double) numberThrows + " %");
		System.out.println("Augenzahl 4: " + 100 * count4 / (double) numberThrows + " %");
		System.out.println("Augenzahl 5: " + 100 * count5 / (double) numberThrows + " %");
		System.out.println("Augenzahl 6: " + 100 * count6 / (double) numberThrows + " %");
	}
}
