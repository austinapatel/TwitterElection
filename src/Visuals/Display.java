package Visuals;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import twitter4j.Status;

@SuppressWarnings("serial")
public class Display extends JFrame implements WindowListener {
	public static int F_HEIGHT = 1000;
	public static int F_WIDTH = 1300;
	
	public static double mapSize = 0.75, textSize = 1 - mapSize;
	
	private TwitterPanel twitterPanel;
	
	//Constructor
	public Display (HashMap<String, Integer> data, ArrayList<Status> tweets) {		
		//Frame Size
		this.setSize(F_WIDTH, F_HEIGHT);
		this.setResizable(true);
		//JPanel stuff
		MapPanel mapPanel = new MapPanel(data);
		mapPanel.setSize(F_WIDTH, (int) (F_HEIGHT * mapSize));
		mapPanel.setLayout(new BorderLayout());
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(this);
		
		twitterPanel = new TwitterPanel(tweets);
		twitterPanel.setSize(F_WIDTH, (int) (F_HEIGHT * textSize));
		
//		twitterPanel.setLayout(new BorderLayout());
		
		
//		TwitterPanel.add(bottomLabel, BorderLayout.PAGE_END);
		twitterPanel.setLocation(0, (int) (F_HEIGHT * mapSize));
		this.add(mapPanel); 
		this.add(twitterPanel);
		//this.pack();
		//Make it visible
		this.setVisible(true);
		
		this.getRootPane().addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                // This is only called when the user releases the mouse button.
                resetSize();
            }
        });
	}
	
	private void resetSize() {
		F_HEIGHT = this.getHeight();
		F_WIDTH = this.getWidth();
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
