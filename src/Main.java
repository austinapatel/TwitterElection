import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Visuals.Display;
import apis.TwitterAPI;
import content.TwitterVisualization;

public class Main implements ActionListener{
	
	private static JTextField field;
	
	public static void main (String[] args)
	{
		TwitterAPI.init();
		JFrame frame = new JFrame();
		frame.setSize(500,500);
		frame.setLayout(null);
		
		JLabel text = new JLabel();
		text.setSize(500, 100);
		text.setText("Enter a search term!");
		text.setHorizontalAlignment(JLabel.CENTER);
		text.setFont(new Font("Arial", 20, 20));
		
		frame.add(text);
		
		field = new JTextField();
		field.setSize(400, 50);
		field.setLocation(50, 100);
		
		frame.add(field);
		
		JButton button = new JButton();
		button.setText("Submit");
		button.setSize(400, 50);
		button.setLocation(50, 200);
		
		frame.add(button);
		button.invalidate();
		frame.invalidate();
		
		button.addActionListener(new Main());
		
		text.setVisible(true);
		button.setVisible(true);
		field.setVisible(true);
		frame.setVisible(true);
		frame.setTitle("Welcome!");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Display map = new Display(TwitterVisualization.getStateColors(field.getText()), TwitterVisualization.getLastTweets());
//		new Display(null, null);
		map.setTitle("Results for: " + field.getText());
	}
}
