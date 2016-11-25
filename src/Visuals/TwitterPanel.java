package Visuals;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import twitter4j.Status;

@SuppressWarnings("serial")
public class TwitterPanel extends JPanel implements ActionListener {
	private ArrayList<Status> status;
	private Timer timer;
	private int num = 5;
	
	public TwitterPanel(ArrayList<Status> status) {
		this.setVisible(true);
		this.setBackground(Color.CYAN);
		this.status = status;
		timer = new Timer(3000, this);
		timer.start();
	}

//	public static void main(String[] args) {
//		JFrame frame = new JFrame();
//		frame.setLayout(null);
//		frame.setSize(1000, 1000);
//		frame.add(new TwitterPanel(null));
//		frame.setVisible(true);
//	}
	
	public void stopTimer() {
		timer.stop();
	}

	protected void paintComponent(Graphics g) {
		// Call the "paint" method in the parent class
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 16));
		int y = 20;
		
		if (status != null)
			for (int i = num - 5; i < num; i ++)
			{
				g.drawString(status.get(i).getText(), 0, y);
				y+=30;
			}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		num += 5;
		if (num > status.size())
		{
			num = 5;
		}
		this.paintComponent(getGraphics());
	}
}