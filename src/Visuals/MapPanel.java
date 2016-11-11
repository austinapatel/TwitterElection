package Visuals;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MapPanel extends JPanel {
	protected void paintComponent(Graphics g)
	{
		this.setBackground(Color.WHITE);
		BufferedImage mapImage = null;
		File imagefile = new File("Images/Nevada.png");
		BufferedImage mapImage2 = null;
		File imagefile2 = new File("Images/California.png");
        try {
			mapImage = ImageIO.read(imagefile);
			mapImage2 = ImageIO.read(imagefile2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    //paint background image
        mapImage = tint(mapImage);
	    super.paintComponent(g);
	    g.drawImage(mapImage, 0, 0, this);
	    g.drawImage(mapImage.getScaledInstance(800, -1, mapImage. SCALE_SMOOTH), 0, 0, this);

	}
	
	//Change Color
	public static BufferedImage tint(BufferedImage img) {

	    for (int x = 0; x < img.getWidth(); x++) {
	        for (int y = 0; y < img.getHeight(); y++) {
	        	if(!isTransparent(x, y, img)) {
	        		Color color = new Color(img.getRGB(x, y));
	            	Color brighter = Color.RED.brighter();
	            	img.setRGB(x, y, brighter.getRGB());
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
