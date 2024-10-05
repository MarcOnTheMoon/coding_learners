package _tello_drone;

/** Simple sample application for basic control of Tello EDU drones.<p>
 * <p>
 * Notes:<br>
 * - Connect to the drone by WiFi before running this application.<br>
 * - Tello architecture and commands:
 *   <a href="https://dl-cdn.ryzerobotics.com/downloads/Tello/Tello%20SDK%202.0%20User%20Guide.pdf">Tello SDK 2.0 User Guide (V1.0)</a>
 * <p>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.05.27<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TelloApp {
	
	public static void main(String[] args) {
		TelloCom communication = new TelloCom();

		communication.sendCommand("command");   	// Set Tello to SDK mode
		new TelloGUI(communication);				// Create and start GUI
	}
}
