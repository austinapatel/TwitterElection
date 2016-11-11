import Visuals.Display;
import apis.TwitterAPI;
import content.TwitterVisualization;

public class Main {

	
	public static void main (String[] args)
	{
		TwitterAPI.init();
//		Display map = new Display(TwitterVisualization.getStateColors("trump"), TwitterVisualization.getLastTweets());
		new Display(null, null);
	}
}
