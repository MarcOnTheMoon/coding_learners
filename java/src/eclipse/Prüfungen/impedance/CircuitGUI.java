package impedance;

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

/** GUI demonstrating impedance classes.
 * 
 * @author Marc Hensel
 * @version 2011-10-24
 */
public class CircuitGUI implements FocusListener {
	private JFrame frame;
	private MyDrawPanel drawPanel;
	JTextField textR_in_Ohm, textC_in_nF, textL_in_mH;
	JTextField textMinFreq_in_kHz, textMaxFreq_in_kHz;
	
	public CircuitGUI() {
		// Create frame and set properties
		frame = new JFrame("Schwingkreis");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);

		// Add elements to content pane
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));

		// Draw panel
		drawPanel = new MyDrawPanel(this);
		drawPanel.setPreferredSize(new Dimension(350, 450));
		contentPane.add(drawPanel);
		
		// Input panel
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(11,3));
		textR_in_Ohm = new JTextField("10");
		textC_in_nF = new JTextField("10");
		textL_in_mH = new JTextField("10");
		textMinFreq_in_kHz = new JTextField("1");
		textMaxFreq_in_kHz = new JTextField("100");

		for (int i = 0; i < 12; i++)	// Skip rows
			inputPanel.add(new JLabel(""));
	
		inputPanel.add(new JLabel("R = "));
		inputPanel.add(textR_in_Ohm);
		inputPanel.add(new JLabel(" Ohm"));
		inputPanel.add(new JLabel("C = "));
		inputPanel.add(textC_in_nF);
		inputPanel.add(new JLabel(" nF"));
		inputPanel.add(new JLabel("L = "));
		inputPanel.add(textL_in_mH);
		inputPanel.add(new JLabel(" mH"));
		inputPanel.add(new JLabel("Min. Frequenz "));
		inputPanel.add(textMinFreq_in_kHz);
		inputPanel.add(new JLabel(" kHz"));
		inputPanel.add(new JLabel("Max. Frequenz "));
		inputPanel.add(textMaxFreq_in_kHz);
		inputPanel.add(new JLabel(" kHz"));
		contentPane.add(inputPanel);
		
		// Event handling
		textR_in_Ohm.addFocusListener(this);
		textC_in_nF.addFocusListener(this);
		textL_in_mH.addFocusListener(this);
		textMinFreq_in_kHz.addFocusListener(this);
		textMaxFreq_in_kHz.addFocusListener(this);

		// Show frame
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CircuitGUI();
	}

	@Override
	public void focusGained(FocusEvent e) {
	}

	@Override
	public void focusLost(FocusEvent e) {
		drawPanel.repaint();
	}
}


/** Drawing panel for impedance classes.
 * 
 * @author Marc Hensel
 * @version 2011-10-24
 */
@SuppressWarnings("serial")
class MyDrawPanel extends JPanel {
	private CircuitGUI parentGUI;
	private final int X_BORDER = 20;	// Position of coordinate system
	private final int Y_BORDER = 40;
	private final int X_SIZE = 275;		// Size of coordinate system
	private final int Y_SIZE = 200;
	
	public MyDrawPanel(CircuitGUI gui) {
		parentGUI = gui;
	}
	
	/** Transform x value to x coordinate for drawing.
	 * 
	 * @param x True x value [in coordinate units]
	 * @return x coordinate for drawing (shifted accordingly)
	 */
	private int xW(double x) {
		return (int)(x + X_BORDER);
	}

	/** Transform y value to y coordinate for drawing.
	 * 
	 * @param y True y value [in coordinate units]
	 * @return y coordinate for drawing (shifted and mirrowed accordingly)
	 */
	private int yW(double y) {
		return (int)(Y_BORDER + Y_SIZE - y);
	}

	/** Get impedances set in GUI.
	 * 
	 * @return Resistor, Capacitor, and Inductor according to data in GUI
	 */
	private Impedance[] getImpedances() {
		Impedance[] impedances = new Impedance[3];

		// Read text input from GUI
		int valueR_Ohm = Integer.parseInt(parentGUI.textR_in_Ohm.getText());
		int valueC_nF = Integer.parseInt(parentGUI.textC_in_nF.getText());
		int valueL_mH = Integer.parseInt(parentGUI.textL_in_mH.getText());

		// Create array of impedances
		impedances[0] = new Resistor(valueR_Ohm);
		impedances[1] = new Capacitor(1.0E-9 * valueC_nF);
		impedances[2] = new Inductor(1.0E-3 * valueL_mH);
		return impedances;
	}
	
	/** Get minimum frequency set in GUI.
	 * 
	 * @return minimum frequency
	 */
	private int getMinFrequency_kHz() {
		return Integer.parseInt(parentGUI.textMinFreq_in_kHz.getText());
	}
	
	/** Get maximum frequency set in GUI.
	 * 
	 * @return maximum frequency
	 */
	private int getMaxFrequency_kHz() {
		return Integer.parseInt(parentGUI.textMaxFreq_in_kHz.getText());
	}
	
	/** Draw.
	 * 
	 * @param g Graphic context to draw on
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Create series and parallel circuit from impedances R, C, and L
		SeriesCircuit series = new SeriesCircuit();
		ParallelCircuit parallel = new ParallelCircuit();
		Impedance[] impedances = getImpedances();

		for (Impedance impedance : impedances) {
			series.addImpedance(impedance);
			parallel.addImpedance(impedance);
		}

		// Create imaginary impedance X = Im{Z} over frequency
		int minFreq_kHz = getMinFrequency_kHz();
		int maxFreq_kHz = getMaxFrequency_kHz();
		double[] seriesX = new double[X_SIZE];
		double[] parallelX = new double[X_SIZE];
				
		for (int i = 0; i < X_SIZE; i++) {
			double freq_Hz = (minFreq_kHz + (double)i/(double)X_SIZE * (maxFreq_kHz - minFreq_kHz)) * 1.0E3;
			double omega = 2 * Math.PI * freq_Hz;

			Complex seriesZ = series.getImpedanceAtOmega(omega); 
			seriesX[i] = seriesZ.getImag();

			Complex parallelZ = parallel.getImpedanceAtOmega(omega); 
			parallelX[i] = parallelZ.getImag();
		}
		
		// Find max. absolute values
		double seriesMaxAbsX = Math.abs(seriesX[0]);		
		for (double imag : seriesX) {
			if (Math.abs(imag) > seriesMaxAbsX) {
				seriesMaxAbsX = Math.abs(imag);
			}
		}
		
		double parallelMaxAbsX = Math.abs(parallelX[0]);
		for (double imag : parallelX) {
			if (Math.abs(imag) > parallelMaxAbsX) {
				parallelMaxAbsX = Math.abs(imag);
			}
		}
		
		// Draw imaginary part
		int[] x = new int[X_SIZE];
		int[] yS = new int[X_SIZE];
		int[] yP = new int[X_SIZE];
		for (int i = 0; i < X_SIZE; i++) {
			x[i] = xW(i);
			yS[i] = yW((int)(Y_SIZE * (seriesX[i] / seriesMaxAbsX)));
			yP[i] = yW((int)(Y_SIZE * (parallelX[i] / parallelMaxAbsX)));
		}
		
		g.setColor(Color.blue);
		g.drawString("Blindwiderstand X (Serienschaltung)", xW(0), 15);
		g.drawString(String.format("%.1f", seriesMaxAbsX), xW(10), yW(Y_SIZE-15));
		for (int i = 1; i < seriesX.length; i++) {
			g.drawPolyline(x, yS, x.length);
		}

		g.setColor(Color.red);
		g.drawString("Blindwiderstand X (Parallelschaltung)", xW(0), 30);
		g.drawString(String.format("%.1f", parallelMaxAbsX), xW(10), yW(Y_SIZE-30));
		for (int i = 1; i < parallelX.length; i++) {
			g.drawPolyline(x, yP, x.length);
		}

		// Draw coordinate system
		g.setColor(Color.black);
		g.drawLine(xW(0), yW(-Y_SIZE), xW(0), yW(Y_SIZE));
		g.drawLine(xW(-5), yW(0), xW(X_SIZE), yW(0));
		
		x = new int[] {xW(-3), xW(3), xW(1)};
		yS = new int[] {yW(Y_SIZE-7), yW(Y_SIZE-7), yW(Y_SIZE)};
		g.fillPolygon(x, yS, x.length);
		x = new int[] {xW(X_SIZE-7), xW(X_SIZE-7), xW(X_SIZE+1)};
		yS = new int[] {yW(3), yW(-3), yW(0)};
		g.fillPolygon(x, yS, x.length);
		
		g.drawString("f_min", xW(5), yW(-20));
		g.drawString("f_max", xW(X_SIZE-20), yW(-20));
	}
}
