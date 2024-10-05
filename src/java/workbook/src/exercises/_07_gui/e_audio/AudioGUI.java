package exercises._07_gui.e_audio;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/** Sample solution.<br><br>
 *
 * Author: Marc Hensel (<a href="http://www.haw-hamburg.de/marc-hensel">link</a>)<br>
 * Project: coding_learners_java (<a href="https://github.com/MarcOnTheMoon/coding_learners_java/">link</a>)<br>
 * Copyright: 2024, Marc Hensel<br>
 * Version: 2024.01.30<br>
 * License: CC BY-NC-SA 4.0 (see <a href="https://creativecommons.org/licenses/by-nc-sa/4.0/deed.en">link</a>)
 */
public class AudioGUI {
	static final int plotPanelHeight = 175;
	private final JFrame frame;
	private final AudioModel model;

	/** Constructor creating and displaying frame.
	 */
	public AudioGUI(AudioModel model) {
		// Reference data model
		this.model = model;
		
		// Create frame and set properties
		frame = new JFrame("Audio");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationByPlatform(true);
		frame.setResizable(false);

		// Create panels
		JPanel plotPanel = createPlotsPanel();
		JPanel controlPanel = createControlPanel();

		// Layout
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		contentPane.add(plotPanel);
		contentPane.add(controlPanel);

		// Show frame
		frame.pack();
		frame.setVisible(true);
	}

	/** Create panel containing time-domain and frequency-domain plots.
	 * 
	 * @return panel with control widgets
	 */
	private JPanel createPlotsPanel() {
		// Create plot panels (time-domain)
		String labelX = "m";
		Point originOffset = new Point(0, plotPanelHeight / 2);
		Dimension dimension = new Dimension(model.NUMBER_SAMPLES, plotPanelHeight);
		PlotPanel signalPanel = new PlotPanel(model.signal.getSamples(), labelX, "Signal s(m)", dimension, originOffset);
		PlotPanel noisePanel = new PlotPanel(model.noise.getSamples(), labelX, "Noise n(m)", dimension, originOffset);
		PlotPanel signalWithNoisePanel = new PlotPanel(model.signalAndNoise.getSamples(), labelX, "s(m) + n(m)", dimension, originOffset);
		PlotPanel denoisedPanel = new PlotPanel(model.denoised.getSamples(), labelX, "Denoised d(m)", dimension, originOffset);

		// Create plot panels (frequency-domain, DFT)
		labelX = "u";
		originOffset.setLocation(model.NUMBER_SAMPLES / 2, 0);
		PlotPanel signalPanelDFT = new PlotPanel(model.signal.getLogSpectrum(), labelX, "S(u)", dimension, originOffset);
		PlotPanel noisePanelDFT = new PlotPanel(model.noise.getLogSpectrum(), labelX, "N(u)", dimension, originOffset);
		PlotPanel signalWithNoisePanelDFT = new PlotPanel(model.signalAndNoise.getLogSpectrum(), labelX, "S(u) + N(u)", dimension, originOffset);
		PlotPanel denoisedPanelDFT = new PlotPanel(model.denoised.getLogSpectrum(), labelX, "D(u)", dimension, originOffset);

		// Layout plot panels
		GridLayout gridLayout = new GridLayout(4, 2);
		gridLayout.setHgap(5);
		gridLayout.setVgap(5);

		JPanel panel = new JPanel();
		panel.setLayout(gridLayout);
		panel.add(signalPanel);
		panel.add(signalPanelDFT);
		panel.add(noisePanel);
		panel.add(noisePanelDFT);
		panel.add(signalWithNoisePanel);
		panel.add(signalWithNoisePanelDFT);
		panel.add(denoisedPanel);
		panel.add(denoisedPanelDFT);

		return panel;
	}

	/** Create panel containing widgets for user input.
	 * 
	 * @return panel with control widgets
	 */
	private JPanel createControlPanel() {
		// Create control widgets
		JTextField textSignalAmplitude = new JTextField(Integer.toString(model.signalAmplitude));
		JTextField textSignalFrequency = new JTextField(Integer.toString(model.signalFrequencyHz));
		JTextField textNoiseAmplitude = new JTextField(Integer.toString(model.noiseAmplitude));
		JTextField textNoiseFrequency = new JTextField(Integer.toString(model.noiseFrequencyHz));
		JTextField textNoisePeakIndex = new JTextField(Integer.toString(model.noisePeakIndex));
		JTextField textNoisePeakRadius = new JTextField(Integer.toString(model.noisePeakRadius));
		
		// Event handling
		ActionListener actionListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					// Assign input values to audio model
					model.signalAmplitude = Integer.parseInt(textSignalAmplitude.getText());
					model.signalFrequencyHz = Integer.parseInt(textSignalFrequency.getText());
					model.noiseAmplitude = Integer.parseInt(textNoiseAmplitude.getText());
					model.noiseFrequencyHz = Integer.parseInt(textNoiseFrequency.getText());
					model.noisePeakIndex = Integer.parseInt(textNoisePeakIndex.getText());
					model.noisePeakRadius = Integer.parseInt(textNoisePeakRadius.getText());
					
					// Update audio data and repaint GUI
					model.update();
					frame.repaint();
				} catch (Exception exception) {
					System.out.println("ERROR: " + exception.getMessage());
				}
			}
		};
		
		textSignalAmplitude.addActionListener(actionListener);
		textSignalFrequency.addActionListener(actionListener);
		textNoiseAmplitude.addActionListener(actionListener);
		textNoiseFrequency.addActionListener(actionListener);
		textNoisePeakIndex.addActionListener(actionListener);
		textNoisePeakRadius.addActionListener(actionListener);

		// Layout control widgets
		JPanel signalPanel = new JPanel();
		signalPanel.setLayout(new GridLayout(1, 5));
		signalPanel.add(new JLabel("Signal:", SwingConstants.CENTER));
		signalPanel.add(new JLabel("a_s =", SwingConstants.CENTER));
		signalPanel.add(textSignalAmplitude);
		signalPanel.add(new JLabel("f_s [Hz] =", SwingConstants.CENTER));
		signalPanel.add(textSignalFrequency);

		JPanel noisePanel = new JPanel();
		noisePanel.setLayout(new GridLayout(1, 5));
		noisePanel.add(new JLabel("Noise:", SwingConstants.CENTER));
		noisePanel.add(new JLabel("a_n =", SwingConstants.CENTER));
		noisePanel.add(textNoiseAmplitude);
		noisePanel.add(new JLabel("f_n [Hz] =", SwingConstants.CENTER));
		noisePanel.add(textNoiseFrequency);

		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new GridLayout(1, 5));
		filterPanel.add(new JLabel("Denoise:", SwingConstants.CENTER));
		filterPanel.add(new JLabel("index =", SwingConstants.CENTER));
		filterPanel.add(textNoisePeakIndex);
		filterPanel.add(new JLabel("radius =", SwingConstants.CENTER));
		filterPanel.add(textNoisePeakRadius);

		JPanel samplingPanel = new JPanel();
		samplingPanel.setLayout(new GridLayout(1, 3));
		samplingPanel.add(new JLabel(String.format("Sampling rate: %.1f kHz", model.SAMPLING_RATE_HZ / 1000.0), SwingConstants.CENTER));
		samplingPanel.add(new JLabel(String.format("Number samples: %d", model.NUMBER_SAMPLES), SwingConstants.CENTER));
		samplingPanel.add(new JLabel(String.format("Window: %.1f ms", 1000.0 * model.NUMBER_SAMPLES / (double)model.SAMPLING_RATE_HZ), SwingConstants.CENTER));

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.add(signalPanel);
		panel.add(filterPanel);
		panel.add(noisePanel);
		panel.add(samplingPanel);
		
		return panel;
	}
}
