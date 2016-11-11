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
	final int F_HEIGHT = 600;
	final int F_WIDTH = 800;
	
	//Constructor
	public Display (HashMap<String, Integer> data, ArrayList<Status> tweets) {
		//Frame Size
		this.setSize(F_WIDTH, F_HEIGHT);
		//JPanel stuff
		MapPanel mapPanel = new MapPanel();
		mapPanel.setSize(F_WIDTH, F_HEIGHT);
		mapPanel.setLayout(new BorderLayout());
		
		TwitterPanel TwitterPanel = new TwitterPanel(tweets);
		TwitterPanel.setSize(100, 100);
		TwitterPanel.setLayout(new BorderLayout());
		
		JLabel bottomLabel = new JLabel("Bottom header!");
		bottomLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mapPanel.add(bottomLabel, BorderLayout.PAGE_END);
		TwitterPanel.add(bottomLabel, BorderLayout.PAGE_END);
		
		//Add the panel
		this.add(mapPanel);
		this.add(TwitterPanel);
		//Make it visible
		this.setVisible(true);
	}
}
