package _10_threads.c_states_methods;

import java.awt.Color;

import javax.swing.JFrame;

/** Lecture sample code.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class E05_FlashLight {
	private boolean isLightOn;
	private final JFrame frame;

	private E05_FlashLight() {
		frame = new JFrame("Blinklicht");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setSize(300, 250);
		frame.setVisible(true);
	}

	public void switchLight() {
		isLightOn = !isLightOn;
		if (isLightOn) {
			frame.getContentPane().setBackground(Color.YELLOW);
		} else {
			frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		}
	}

	public static void main(String[] args) {
		E05_FlashLight e05_FlashLight = new E05_FlashLight();
		FlashThread thread = new FlashThread(e05_FlashLight);
		thread.start();
	}
}

class FlashThread extends Thread {
	private final E05_FlashLight e05_FlashLight;
	
	public FlashThread(E05_FlashLight e05_FlashLight) {
		super();
		this.e05_FlashLight = e05_FlashLight;
	}

	@Override
	public void run() {
		while (true) {
			e05_FlashLight.switchLight();
			try {
				Thread.sleep(750);
			} catch (InterruptedException e) {
			}
		}
	}
}
