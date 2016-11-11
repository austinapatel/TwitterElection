
package content;

import java.util.HashMap;

import apis.TwitterAPI;
import twitter4j.Status;

/**Loads Twitter data for each of the states and 
 * provides the color of each one.*/
public class TwitterVisualization {
	
	private static String[] states = new String[] {
			"Alabama", "Alaska", "Arizona", "Arkansas",
			"California", "Colorade", "Connecticut", 
			"Delaware", "Florida", "Georgia", "Hawaii",
			"Idaho", "Illinois", "Indiana", "Iowa",
			"Kansas", "Kentucky", "Louisiana", "Maine",
			"Maryland", "Massachusetts", "Michigan",
			"Mineesota", "Mississippi", "Missouri",
			"Montana", "Nebraska", "Nevada",
			"New Hampshire", "New Jersey", "New Mexico",
			"New York", "North Carolina", "North Dakota",
			"Ohio", "Oklahoma", "Oregon", "Pennsylvania",
			"Rhode Island", "South Carolina", "South Dakota",
			"Tennessee", "Texas", "Utah", "Vermont",
			"Virginia", "Washington", "West Virginia",
			"Wisconsin", "Wyoming"};
	
	public static void main(String[] args) {
		TwitterAPI.init();
		
//		System.out.println(TwitterVisualization.getStateTweets().get("California").getText());
//		System.out.println("Test");
		System.out.println(getStateColors("trump"));
	}
	
	/**Returns the Tweets to be for each state.*/
	public static HashMap<String, Status> getStateTweets() {
		HashMap<String, Status> tweets = new HashMap<String, Status>();
		
		for (String state : states)
			tweets.put(state, TwitterAPI.mostPopular(TwitterAPI.searchTwitter(state + " election", 1)));
		
		return tweets;
	}
	
	/**Returns the color of the state to display.
	 * 0 is no color, 100 is full color.*/
	public static HashMap<String, Integer> getStateColors(String query) {
		HashMap<String, Integer> results = new HashMap<String, Integer>();
		
		for (String state : states)
			results.put(state, 0);
			
		TwitterAPI.searchTwitter(query, 1000);
		
		return null;
	}
}
