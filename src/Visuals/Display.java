package Visuals;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import twitter4j.Status;

@SuppressWarnings("serial")
public class Display extends JFrame {
	public final static int F_HEIGHT = 1000;
	public final static int F_WIDTH = 1600;
	
	//Constructor
	public Display (HashMap<String, Integer> data, ArrayList<Status> tweets) {
		//Frame Size
		this.setSize(F_WIDTH, F_HEIGHT);
//		this.setResizable(false);
		//JPanel stuff
		MapPanel mapPanel = new MapPanel();
		mapPanel.setSize(F_WIDTH / 2, F_HEIGHT);
		mapPanel.setLayout(new BorderLayout());
		this.setLayout(null);
		
		TwitterPanel twitterPanel = new TwitterPanel(tweets);
//		twitterPanel.setSize(100, 100);
//		twitterPanel.setLayout(new BorderLayout());
		
		JLabel bottomLabel = new JLabel("Bottom header!");
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapPanel.add(bottomLabel, BorderLayout.PAGE_END);
//		TwitterPanel.add(bottomLabel, BorderLayout.PAGE_END);
		twitterPanel.setLocation(F_WIDTH / 2, 0);
		this.add(mapPanel);
		this.add(twitterPanel);

		
		//Add the panel
		//this.add(mapPanel);
		//Make it visible
		this.setVisible(true);
	}
}
