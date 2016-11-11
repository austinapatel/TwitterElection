package Visuals;
import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import twitter4j.Status;

@SuppressWarnings("serial")
public class Display extends JFrame implements WindowListener {
	public final static int F_HEIGHT = 700;
	public final static int F_WIDTH = 1300;
	
	private TwitterPanel twitterPanel;
	
	//Constructor
	public Display (HashMap<String, Integer> data, ArrayList<Status> tweets) {
		//Frame Size
		this.setSize(F_WIDTH, F_HEIGHT);
		this.setResizable(false);
		//JPanel stuff
		MapPanel mapPanel = new MapPanel(data);
		mapPanel.setSize((int) (F_WIDTH * .75), F_HEIGHT);
		mapPanel.setLayout(new BorderLayout());
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
		
		twitterPanel = new TwitterPanel(tweets);
//		twitterPanel.setSize(100, 100);
//		twitterPanel.setLayout(new BorderLayout());
		
		JLabel bottomLabel = new JLabel("Bottom header!");
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapPanel.add(bottomLabel, BorderLayout.PAGE_END);
//		TwitterPanel.add(bottomLabel, BorderLayout.PAGE_END);
		twitterPanel.setLocation((int) (F_WIDTH * .75), 0);
		this.add(mapPanel);
		this.add(twitterPanel);

		//Make it visible
		this.setVisible(true);
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		twitterPanel.stopTimer();
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
}
