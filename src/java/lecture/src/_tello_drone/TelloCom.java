package _tello_drone;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/** Communication with the drone Tello EDU.
 * <p>
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.05.27<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class TelloCom {
	private final int statePort = 8890;				// Tello's client sending state messages with 10 Hz
	private final int cmdPort = 8889;					// Tello's server accepting command messages
	private InetAddress cmdServerAddress;
	private final int stateRequestTimeoutMs = 1000;

	/** Instantiate.
	 */
	public TelloCom() {
		try {
			cmdServerAddress = InetAddress.getByName("192.168.10.1");
		} catch (UnknownHostException e) {
			System.out.println("WARNING Unknown server host");
		}
	}

	/**
	 * Send a command string to a connected Tello.
	 * 
	 * @param command String to send
	 */
	public void sendCommand(String command) {
		try {
			// Prepare socket
			DatagramSocket socket = new DatagramSocket(cmdPort);		// Must use same port as Tello server
			socket.connect(cmdServerAddress, cmdPort);

			// Send command string
			if (socket.isConnected() && !socket.isClosed() && !command.isEmpty()) {
				byte[] data = command.getBytes();
				DatagramPacket packet = new DatagramPacket(data, data.length, cmdServerAddress, cmdPort);
				socket.send(packet);
			} else
				System.out.printf("WARNING Cannot send command: \"%s\"\n", command);

			// Close socket
			socket.close();
		} catch (Exception e) {
			System.out.printf("EXCEPTION Cannot send command \"%s\": %s\n", command, e.getMessage());
		}
	}
	
	/**
	 * Get remaining battery level from connected Tello
	 * 
	 * @return remaining battery level in percent or 0
	 */
	public int getBatteryLevel() {
		int level = 0;
		byte[] receivedData = new byte[1024];
		byte[] data = null;
		
		// Receive next status string from Tello
		try {
			DatagramSocket socket = new DatagramSocket(statePort);		// Must use same port as Tello client
			DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);

			socket.setSoTimeout(stateRequestTimeoutMs);			// Set max. waiting time in ms
			socket.receive(receivePacket);
			socket.close();
			data = Arrays.copyOf(receivePacket.getData(), receivePacket.getLength());
		} catch (Exception e) {
			System.out.printf("EXCEPTION Cannot receive battery level: %s\n", e.getMessage());
		}
		
		// Read level from status string
		if (data != null) {
			String stateString = new String(data);
			String[] keyValuePairs = stateString.split(";");	// Pairs formatted as "key:value"
			
			for (String keyValue : keyValuePairs) {
				String[] splitted = keyValue.split(":");		// Array containing {key, value}
				if (splitted[0].equalsIgnoreCase("bat")) {		// Battery level: key = "bat"
					level = Integer.parseInt(splitted[1]);
					break;
				}
			}
		}
		
		return level;
	}
}
