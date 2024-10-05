package exercises._10_threads;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class StopWatchApp {
	private SecondsThread thread;
	private JLabel timeLabel;

	/** Initialize GUI.
	 */
	private StopWatchApp() {
		// Create frame and set properties
		JFrame frame = new JFrame("Stoppuhr");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);
		
		// Create widgets
		JPanel timePanel = initTimePanel();
		JPanel buttonPanel = initButtonPanel();
		
		// Layout
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(timePanel);
		contentPane.add(buttonPanel);
		
		// Show frame
		frame.pack();
		frame.setVisible(true);
	}
	
	/** Create widget for displaying elapsed time.
	 * 
	 * @return panel to be added to content pane
	 */
	private JPanel initTimePanel() {
		// Label
		timeLabel = new JLabel();
		timeLabel.setFont(new Font("Courier New", Font.BOLD, 42));
		timeLabel.setHorizontalAlignment(JLabel.CENTER);
		timeLabel.setPreferredSize(new Dimension(150, 75));
		setTime(0);

		// Layout
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 75));
		panel.add(timeLabel);
		return panel;
	}
	
	/** Create widget containing control buttons.
	 * 
	 * @return panel to be added to content pane
	 */
	private JPanel initButtonPanel() {
		// Create widgets
		JButton startStopButton = new JButton("Start");
		JButton resetButton = new JButton("Reset");
		resetButton.setEnabled(false);
		
		// Event handling: start/stop 
		startStopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				if (startStopButton.getText().equals("Start")) {
					// Start
					startStopButton.setText("Stop");
					resetButton.setEnabled(false);
					startThread();
				} else {
					// Stop
					startStopButton.setEnabled(false);
					resetButton.setEnabled(true);
					stopThread();
				}
			}
		});

		// Event handling: reset
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startStopButton.setText("Start");
				startStopButton.setEnabled(true);
				resetButton.setEnabled(false);
				setTime(0);
			}
		});

		// Layout
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(startStopButton);
		panel.add(resetButton);
		return panel;
	}
	
	/** Start thread increasing elapsed time each second.
	 */
	private void startThread() {
		thread = new SecondsThread(this);
		thread.start();
	}
	
	/** Stop thread increasing elapsed time each second.
	 */
	private void stopThread() {
		if (thread != null) {
			thread.interrupt();
			thread = null;
		}
	}
	
	/** Set elapsed time displayed in GUI.
	 * 
	 * @param elapsedSecs Elapsed time in seconds
	 */
	void setTime(int elapsedSecs) {
		timeLabel.setText(String.format("%02d:%02d", elapsedSecs / 60, elapsedSecs % 60));
	}
	
	/** Application entry point.
	 * 
	 * @param args Command-line arguments (not used)
	 */
	public static void main(String[] args) {
		new StopWatchApp();
	}
}

/** Thread for running stop watch.<br><br>
 *
 * Increments a counter each second.
 * Sets the elapsed time in a parent GUI.
 */
class SecondsThread extends Thread {
	private final StopWatchApp watch;
	
	/** Initializes thread object.
	 * 
	 * @param watch Parent stop watch to set time in
	 */
	public SecondsThread(StopWatchApp watch) {
		super();
		this.watch = watch;
	}

	@Override
	public void run() {
		int elapsedSecs = 0;
		long targetTimeMs = System.currentTimeMillis();

		// Run until thread gets interrupted
		while (true) {
			// Synchronize to seconds (compensate time for overhead)
			targetTimeMs += 1000;
			long sleepTimeMs = targetTimeMs - System.currentTimeMillis(); 
					
			// Sleep until second has elapsed
			try {
				Thread.sleep(sleepTimeMs);
			} catch (InterruptedException e) {
				return;
			}

			// Notify stop watch
			watch.setTime(++elapsedSecs);
		}
	}
}