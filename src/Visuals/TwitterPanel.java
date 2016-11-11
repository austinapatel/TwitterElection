package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import twitter4j.Status;

public class TwitterPanel extends JPanel {
	public TwitterPanel(ArrayList<Status> status) {
		this.setVisible(true);
		this.setSize(Display.F_WIDTH / 2, Display.F_HEIGHT);
		this.setBackground(Color.YELLOW);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setLayout(null);
		frame.setSize(1000, 1000);
		frame.add(new TwitterPanel(null));
		frame.setVisible(true);
	}

	protected void paintComponent(Graphics g) {
		// Call the "paint" method in the parent class
		super.paintComponent(g);

		System.out.println("drawing");
		// Draw a blue line
		g.setColor(Color.BLUE);
		g.drawLine(45, 25, 445, 25);

		// Draw a red rectangle
		g.setColor(Color.RED);
		g.drawRect(45, 50, 400, 285);

		// Draw some green text
		g.setColor(Color.GREEN);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString("Hello, World!", 155, 120);

		// Draw a filled-in magenta circle
		g.setColor(Color.MAGENTA);
		g.fillOval(200, 180, 100, 100);
	}
}
