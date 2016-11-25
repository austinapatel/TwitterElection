
package content;

import java.util.ArrayList;
import java.util.HashMap;

import apis.TwitterAPI;
import sentiment.NLP;
import twitter4j.Status;

/**
 * Loads Twitter data for each of the states and provides the color of each one.
 */
public class TwitterVisualization {

	public static String[] states = new String[] { "Alabama", "Arizona", "Arkansas", "California",
			"Colorado", "Connecticut", "Delaware", "Florida", "Georgia", "Idaho", "Illionois", "Indiana",
			"Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota",
			"Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico",
			"New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island",
			"South Carolina", "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington",
			"West Virginia", "Wisconsin", "Wyoming" };
	
	private static ArrayList<Status> lastTweets;

//	public static void main(String[] args) {
//		TwitterAPI.init();
//
//		// System.out.println(TwitterVisualization.getStateTweets().get("California").getText());
//		// System.out.println("Test");
//		System.out.println(getStateColors("trump"));
//	}
	
	public static ArrayList<Status> getLastTweets() {
		return lastTweets;
	}

	/** Returns the Tweets to be for each state. */
	public static HashMap<String, Status> getStateTweets() {
		HashMap<String, Status> tweets = new HashMap<String, Status>();

		for (String state : states)
			tweets.put(state, TwitterAPI.mostPopular(TwitterAPI.searchTwitter(state + " election", 1)));

		return tweets;
	}

	/**
	 * Returns the color of the state to display. 0 is no color, 100 is full
	 * color.
	 */
//	public static HashMap<String, Integer> getStateColors(String query) {
//		NLP.init();
//
//		HashMap<String, Integer> netResults = new HashMap<String, Integer>(),
//				positiveResults = new HashMap<String, Integer>(), negativeResults = new HashMap<String, Integer>(),
//				neutralResults = new HashMap<String, Integer>();
//
//		for (String state : states) {
//			netResults.put(state, 0);
//			positiveResults.put(state, 0);
//			negativeResults.put(state, 0);
//			neutralResults.put(state, 0);
//		}
//
//		ArrayList<Status> tweets = TwitterAPI.searchTwitter(query, 100);
//
//		int total = 0;
//
//		for (Status tweet : tweets)
//			for (String state : states)
//				if (tweet.getText().contains(state) || tweet.getUser().getLocation().contains(state)) {
//					int result = NLP.findSentiment(tweet.getText());
//					int change = 0;
//
//					if (result == 3) {
//						change = 1;
//						positiveResults.put(state, positiveResults.get(state) + 1);
//					} else if (result == 2) {
//						change = 0;
//						neutralResults.put(state, neutralResults.get(state) + 1);
//					} else if (result == 1) {
//						change = -1;
//						negativeResults.put(state, negativeResults.get(state) + 1);
//					}
//
//					total++;
//
//					netResults.put(state, netResults.get(state) + change);
//				}
//
//		System.out.println("Negative: " + negativeResults);
//		System.out.println("Positive: " + positiveResults);
//		System.out.println("Neutral: " + neutralResults);
//		System.out.println("Net: " + netResults);
//		// System.out.println(total);
//
//		return netResults;
//	}

	public static HashMap<String, Integer> getStateColors(String query) {
		NLP.init();
		lastTweets = new ArrayList<Status>();

		HashMap<String, Integer> sentiment = new HashMap<String, Integer>();
		HashMap<String, Integer> mentions = new HashMap<String, Integer>();
		HashMap<String, Integer> results = new HashMap<String, Integer>();
		
		HashMap<String, Integer> netResults = new HashMap<String, Integer>(),
				positiveResults = new HashMap<String, Integer>(), negativeResults = new HashMap<String, Integer>(),
				neutralResults = new HashMap<String, Integer>();

		for (String state : states) {
			netResults.put(state, 0);
			positiveResults.put(state, 0);
			negativeResults.put(state, 0);
			neutralResults.put(state, 0);
		}

		for (String state : states) {
			sentiment.put(state, 0);
			results.put(state, 0);
			mentions.put(state, 0);
		}

		for (String state : states)
		{
			ArrayList<Status> tweets = TwitterAPI.searchTwitter(state + " " + query, 10);
			
			for (Status tweet : tweets)
				if (tweet.getText().contains(state) || tweet.getUser().getLocation().contains(state)) {
					mentions.put(state, mentions.get(state) + 1);
					int result = NLP.findSentiment(tweet.getText());
					int change = 0;
	
//					if (result == 3)
//						change = 1;
//					else if (result == 2)
//						change = 0;
//					else if (result == 1)
//						change = -1;
					
					if (result == 3) {
						change = 1;
						positiveResults.put(state, positiveResults.get(state) + 1);
					} else if (result == 2) {
						change = 0;
						neutralResults.put(state, neutralResults.get(state) + 1);
					} else if (result == 1) {
						change = -1;
						negativeResults.put(state, negativeResults.get(state) + 1);
					}
					
					netResults.put(state, netResults.get(state) + change);
				
					lastTweets.add(tweet);
		
					sentiment.put(state, sentiment.get(state) + change);
				}
		}
		
		System.out.println("Negative: " + negativeResults);
		System.out.println("Positive: " + positiveResults);
		System.out.println("Neutral: " + neutralResults);
		System.out.println("Net: " + netResults);
		
		for (String state : states)
			results.put(state, (sentiment.get(state) < 0) ? -mentions.get(state) : mentions.get(state));

		return results;
	}
}