package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import twitter4j.Status;


public class TwitterPanel extends JPanel implements ActionListener {
	private ArrayList<Status> status;
	Timer timer;
	private int num = 10;
	public TwitterPanel(ArrayList<Status> status) {
		this.setVisible(true);
		this.setSize(Display.F_WIDTH / 2, Display.F_HEIGHT);
		this.setBackground(Color.BLUE);
		this.status = status;
		timer = new Timer(3000, this);
		timer.start();
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
		g.setColor(Color.RED);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		int y = 10;
		
		for (int i = num - 10; i < num; i ++)
		{
			g.drawString(status.get(0).getText(), 0, y);
			y+=30;
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		num+= 10;
		if (num > status.size())
			timer.stop();
		this.repaint();
	}
}