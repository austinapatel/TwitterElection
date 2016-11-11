package Visuals;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Display extends JFrame {
	final int F_HEIGHT = 600;
	final int F_WIDTH = 800;
	
	//Constructor
	public Display () {
		//Frame Size
		this.setSize(F_WIDTH, F_HEIGHT);
		//JPanel stuff
		MapPanel mapPanel = new MapPanel();
		mapPanel.setSize(F_WIDTH, F_HEIGHT);
		mapPanel.setLayout(new BorderLayout());
		
		JLabel bottomLabel = new JLabel("Bottom header!");
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapPanel.add(bottomLabel, BorderLayout.PAGE_END);
		
		//Add the panel
		this.add(mapPanel);
		//Make it visible
		this.setVisible(true);
	}
	
	//Tester Main
	public static void main(String[] args) {
		Display map = new Display();
	}
}
