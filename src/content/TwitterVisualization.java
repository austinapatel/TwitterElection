
package content;

import java.util.ArrayList;
import java.util.HashMap;

import apis.TwitterAPI;
import sentiment.NLP;
import twitter4j.Status;

/**Loads Twitter data for each of the states and 
 * provides the color of each one.*/
public class TwitterVisualization {
	
	private static String[] states = new String[] {
			"Alabama", "Alaska", "Arizona", "Arkansas",
			"California", "Colorado", "Connecticut", 
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
		NLP.init();
		
		HashMap<String, Integer> results = new HashMap<String, Integer>();
		
		for (String state : states)
			results.put(state, 0);
			
		ArrayList<Status> tweetStatuses = TwitterAPI.searchTwitter(query, 5000);
		ArrayList<String> tweets = new ArrayList<String>();
		
		for (Status tweet : tweetStatuses)
			tweets.add(tweet.getText());
		
//		ArrayList<String> tweets = new ArrayList<String>();
//		tweets.add("i love and pizza and rainbows yes my life is great California");
//		tweets.add("i want to kill death destruction trump Arkansas");
		
		for (String tweet : tweets)
			for (String state : states)
				if (tweet.contains(state))
				{
					int result = NLP.findSentiment(tweet);
					int change = -1;
					
					if (result == 3)
						change = 2;
					
					results.put(state, results.get(state) + change);
				}
			
		return results;
	}
}
