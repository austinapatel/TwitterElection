package Visuals;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

import twitter4j.Status;


public class TwitterPanel extends JPanel implements ActionListener {
	private ArrayList<Status> status;
	private Timer timer;
	private int num = 10;
	private JTextArea textAreal;
	
	public TwitterPanel(ArrayList<Status> status) {
		this.setVisible(true);
		this.setSize((int) (Display.F_WIDTH * .75), Display.F_HEIGHT);
		this.setBackground(Color.CYAN);
		this.status = status;
		timer = new Timer(3000, this);
		timer.start();
		textAreal = new JTextArea("", 5, 10);
		textAreal.setPreferredSize(new Dimension(100, 100));
	    textAreal.setLineWrap(true);
	    textAreal.setWrapStyleWord(true);
	    textAreal.setVisible(true);
	    this.add(textAreal);
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
		g.setFont(new Font("Arial", Font.BOLD, 12));
		
		String text = "";
		for (int i = 0; i < num; i++)
		{
			text += status.get(num).getText();
		}
		textAreal.setText(text);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		num+=10;
		if (num > status.size())
		{
			num = 10;
		}
		this.paintComponent(getGraphics());	
	}
}