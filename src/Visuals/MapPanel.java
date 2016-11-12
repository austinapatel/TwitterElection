package Visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import content.TwitterVisualization;

public class MapPanel extends JPanel {
	
	private HashMap<String, BufferedImage> states;
	private HashMap<String, Integer> data;
	BufferedImage borders = null;
	
	public MapPanel(HashMap<String, Integer> data2) {
		states = new HashMap<String, BufferedImage>();
		data = data2;
		
		try {
			borders = ImageIO.read(new File("Images/white-states.png"));
			for (String state : TwitterVisualization.states) {
				states.put(state, ImageIO.read(new File("Images/" + state + ".png")));
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics g)
	{
		//Make the states and state images
		this.setBackground(Color.WHITE);		
		
		//Paint it all
	    super.paintComponent(g);
	    
	    for(String diffStates : TwitterVisualization.states) {
	    	if(data.get(diffStates) < 0) 
	    		states.replace(diffStates, tint(states.get(diffStates), true));
	    	else 
	    		states.replace(diffStates, tint(states.get(diffStates), false));
	    }
	    
	    for (String state : TwitterVisualization.states)
	    	g.drawImage(states.get(state).getScaledInstance((int) (Display.F_WIDTH * .75), -1, states.get(state).SCALE_SMOOTH), 0, 0, this);
	    
	    g.drawImage(borders.getScaledInstance((int) (Display.F_WIDTH * .75), -1, borders.SCALE_SMOOTH), 0, 0, this);
	}
	
	//Change Color
	public static BufferedImage tint(BufferedImage img, Boolean rOrG) {

	    for (int x = 0; x < img.getWidth(); x++) {
	        for (int y = 0; y < img.getHeight(); y++) {
	        	if(!isTransparent(x, y, img)) {
	        		Color color = new Color(img.getRGB(x, y));
	            	Color rBrighter = Color.RED.brighter();
	            	Color gBrighter = Color.GREEN.brighter();
	            	if(rOrG)
	            		img.setRGB(x, y, rBrighter.getRGB());
	            	else 
	            		img.setRGB(x, y, gBrighter.getRGB());
	        	}
	        }
	    }
	    return (img);
	}
	
	public static boolean isTransparent(int x, int y, BufferedImage img) {
		  int pixel = img.getRGB(x,y);
		  if( (pixel>>24) == 0x00 ) {
		      return true;
		  }
		  else {
			  return false;
		  }
		}
}
