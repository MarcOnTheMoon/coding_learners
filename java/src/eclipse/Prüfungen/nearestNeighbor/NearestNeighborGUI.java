package nearestNeighbor;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NearestNeighborGUI implements ActionListener {
	private int numberDataPointsEach = 500;				// Make: 500
	private double gaussianScaleFactor = 1.25;			// Make: 1.25
	private boolean isDisplayClassVectors = true;		// Make: true
	
	private JFrame frame;
	NearestNeighbor classifier;
	DrawPanel drawPanel;
	
	/**
	 * 
	 */
	public NearestNeighborGUI() {
		// Create frame and set properties
		frame = new JFrame("Nächster-Nachbar-Klassifikation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		frame.setLocation(50, 50);

		// Create buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		JButton buttonReset = new JButton("Neue Daten");
		JButton buttonNext = new JButton("Nächster Schritt");
		buttonPanel.add(buttonNext);
		buttonPanel.add(new JLabel("  "));
		buttonPanel.add(buttonReset);
		
		// Button event handling
		buttonReset.setActionCommand("ButtonReset");
		buttonReset.addActionListener(this);
		buttonNext.setActionCommand("ButtonNext");
		buttonNext.addActionListener(this);

		// Add to content pane
		Container contentPane = frame.getContentPane();
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		drawPanel = new DrawPanel();
		frame.add(drawPanel);
		contentPane.add(buttonPanel);
		
		// Init classifier
		resetClassifier();
		
		frame.pack();
		frame.setVisible(true);
	}
	
	/**
	 * 
	 */
	private void resetClassifier() {
		Random random = new Random();
	
		classifier = new NearestNeighbor(2);
		classifier.setMeanVectors(new MathVector(new double[]{1,1}), new MathVector(new double[]{9,9}));
		
		// Create Gaussian clouds around (x,y) = (3, 7) and (x,y) = (7, 3)
		for (int i = 0; i < numberDataPointsEach; i++) {
			double x = gaussianScaleFactor * random.nextGaussian() + 3.0;
			double y = gaussianScaleFactor * random.nextGaussian() + 7.0;
			classifier.addToListNew(new MathVector(new double[]{x, y}));
		}
		for (int i = 0; i < numberDataPointsEach; i++) {
			double x = gaussianScaleFactor * random.nextGaussian() + 7.0;
			double y = gaussianScaleFactor * random.nextGaussian() + 3.0;
			classifier.addToListNew(new MathVector(new double[]{x, y}));
		}
		
		// Print sorted vector list to console
		ArrayList<MathVector> listNew = classifier.getListNew();
		Collections.sort(listNew);
		System.out.println("New vectors (sorted by absolute values):");
		int i = 0;
		for (MathVector v : listNew) {
			System.out.printf("  %4d: ||v|| = %.2f (v = %s)\n", ++i, v.getAbs(), v.toString());
		}
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new NearestNeighborGUI();
	}

	/**
	 * 
	 */
	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("ButtonReset")) {
			System.out.println("Reset data");
			resetClassifier();
		}
		
		if (event.getActionCommand().equals("ButtonNext")) {
			classifier.updateMeanVectors();
			System.out.println("Mean class A = " + classifier.getMeanA());
			System.out.println("Mean class B = " + classifier.getMeanB());
		}
		
		drawPanel.repaint();
	}


	/**
	 * 
	 * @author Arbeit
	 *
	 */
	class DrawPanel extends JPanel {
		private static final long serialVersionUID = 20100611L;
		private int panelSize = 350; 
		private int xBorder = 25;
		private int yBorder = 30;
		private int drawSize = 300;
		private double maxLogicalSize = 10.0;

		public DrawPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
		}
	
		/** Set panel size.
		 */
		public Dimension getPreferredSize() {
			return new Dimension(panelSize, panelSize);
		}
		
		private int val2pixX(double x) {
			return (int)Math.round(x * (drawSize / maxLogicalSize) + xBorder);
		}

		private int val2pixY(double y) {
			return (int)Math.round(yBorder + drawSize - y * (drawSize / maxLogicalSize));
		}

		public void paintComponent(Graphics g) {
			int x, y; 
			g.clearRect(0, 0, panelSize, panelSize);
			
			// Draw unclassified vectors
			ArrayList<MathVector> list = classifier.getListNew();
			for (MathVector mathVector : list) {
				g.drawOval(val2pixX(mathVector.getElement(0)), val2pixY(mathVector.getElement(1)), 5, 5);
			}

			// Draw class A
			g.setColor(Color.green);
			ArrayList<MathVector> listA = classifier.getListA();
			MathVector meanA = classifier.getMeanA();
			for (MathVector mathVector : listA) {
				g.drawOval(val2pixX(mathVector.getElement(0)), val2pixY(mathVector.getElement(1)), 5, 5);
			}
			if (isDisplayClassVectors) {
				x = val2pixX(meanA.getElement(0));
				y = val2pixY(meanA.getElement(1));
				g.fillOval(x, y, 8, 8);
				g.setColor(Color.black);
				g.drawOval(x, y, 8, 8);
				g.setColor(Color.white);
				g.fillRect(x + 11, y - 3, 16, 14);
				g.setColor(Color.black);
				g.drawRect(x + 11, y - 3, 16, 14);
				g.drawString("A", x + 16, y + 9);
			}

			// Draw class B
			g.setColor(Color.red);
			ArrayList<MathVector> listB = classifier.getListB();
			MathVector meanB = classifier.getMeanB();
			for (MathVector mathVector : listB) {
				g.drawOval(val2pixX(mathVector.getElement(0)), val2pixY(mathVector.getElement(1)), 5, 5);
			}
			if (isDisplayClassVectors) {
				x = val2pixX(meanB.getElement(0));
				y = val2pixY(meanB.getElement(1));
				g.fillOval(x, y, 8, 8);
				g.setColor(Color.black);
				g.drawOval(x, y, 8, 8);
				g.setColor(Color.white);
				g.fillRect(x + 11, y - 3, 16, 14);
				g.setColor(Color.black);
				g.drawRect(x + 11, y - 3, 16, 14);
				g.drawString("B", x + 16, y + 9);
			}
			
			// Draw separator
			if (isDisplayClassVectors) {
				g.setColor(Color.blue);
				double xA = meanA.getElement(0);
				double yA = meanA.getElement(1);
				double xB = meanB.getElement(0);
				double yB = meanB.getElement(1);
				double xCenter = (xA + xB) / 2.0;
				double yCenter = (yA + yB) / 2.0;
				double xDiff = xA - xB;
				double yDiff = yA - yB;
				double xNorm = 1.0;
				double yNorm = - xDiff / yDiff;
				double x1 = xCenter + xNorm;
				double y1 = yCenter + yNorm;
				double m = (yCenter - y1) / (xCenter - x1);
				double b = y1 - m * x1;
				g.drawLine(
					val2pixX((-20 - b)/m),
					val2pixY(-20),
					val2pixX((20 - b)/m),
					val2pixY(20));
			}
			
			// Draw coordinate system
			g.setColor(Color.black);
			g.drawLine(xBorder, yBorder + drawSize, xBorder + drawSize, yBorder + drawSize);
			x = xBorder + drawSize;
			y = yBorder + drawSize;
			g.fillPolygon(new int[]{x - 5, x, x - 5}, new int[]{y - 5, y, y + 5}, 3);
			g.drawString("Breite", x - 30, y + 14);

			g.drawLine(xBorder, yBorder + drawSize, xBorder, yBorder);
			x = xBorder;
			y = yBorder;
			g.fillPolygon(new int[]{x - 5, x, x + 5}, new int[]{y + 5, y, y + 5}, 3);
			g.drawString("Höhe", x - 14, y - 7);
		}	
	}
}