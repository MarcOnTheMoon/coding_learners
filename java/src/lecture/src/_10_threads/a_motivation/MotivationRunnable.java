package _10_threads.a_motivation;

import java.awt.image.BufferedImage;
import java.util.GregorianCalendar;

/** Image processing runnable doing line by line linear filtering.
 * <br><br>
 * The processing is slowed down artificially for demonstration purposes.
 * <br><br>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
class MotivationRunnable implements Runnable {
	private final BufferedImage source, target;
	private final double[][] mask;
	private final boolean isMaskNegative;
	private final int firstY, lastY;

	/** Create instance.
	 * 
	 * @param source Source image
	 * @param target Target image [out]
	 * @param mask Filter coefficients
	 * @param isMaskNegative Pass true if mask contains negative coefficients
	 * @param firstY First image row to filter
	 * @param lastY Last image row to filter
	 */
	public MotivationRunnable(BufferedImage source, BufferedImage target, double[][] mask, boolean isMaskNegative, int firstY, int lastY) {
		this.source = source;
		this.target = target; 
		this.mask = mask;
		this.isMaskNegative = isMaskNegative;
		this.firstY = firstY;
		this.lastY = lastY;
	}
	
	/** Wait actively for a specific time interval.
	 * <p>
	 * Waiting "actively" (i.e., getting and comparing current time in
	 * while loop instead of using sleep for thread) avoids, that other
	 * threads automatically gets a processing time slice while waiting.
	 */
	public static void activelyDelay() {
		long waitMilliSec = 20;
		long startTimeMs = new GregorianCalendar().getTimeInMillis();
		long timePassedMs = 0;
		
		while (timePassedMs < waitMilliSec) {
			timePassedMs = new GregorianCalendar().getTimeInMillis() - startTimeMs;
		}
	}
	
	public void run() {
		for (int y = firstY; y <= lastY; y++) {
			activelyDelay();
			MotivationIpMethods.applyLinearFilter(source, target, mask, isMaskNegative, 1, y, source.getWidth() - 2, 1);
		}
	}	
}
