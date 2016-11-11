
package apis;

import java.util.ArrayList;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**Connects to the Twitter API through the Twitter4J library.
 * Provides static methods to perform various functions on Twitter.*/
public class TwitterAPI {
	
	private static Twitter twitter;

	/**Tests the TwitterAPI class.*/
	public static void main(String[] args) {
		ArrayList<Status> searchResults = searchTwitter("california election", 10);
		
		for (Status searchResult : searchResults)
			System.out.println('@' + searchResult.getUser().getScreenName() + ": " + searchResult.getText());
	}
	
	public static void init() {
		twitter = TwitterFactory.getSingleton();
	}

	/**Searches Twitter given a query and number of results.*/
	public static ArrayList<Status> searchTwitter(String search, int size) {		
		Query query = new Query(search);
		query.setCount(size);
		
		ArrayList<Status> results = new ArrayList<Status>();

		try {
			QueryResult result = twitter.search(query);

			for (Status status : result.getTweets())
				 results.add(status);
		} catch (TwitterException e) {
			e.printStackTrace();
		}
		
		return results;
	}
	
	/**Filters through a list of Tweets and returns the most popular.*/
	public static Status mostPopular(ArrayList<Status> tweets) {
		Status mostPopular = null;
		int mostFavorited = 0;
		for (Status tweet : tweets)
			if (tweet.getFavoriteCount() > mostFavorited)
			{
				mostFavorited = tweet.getFavoriteCount();
				mostPopular = tweet;
			}
		
		return mostPopular;
	}
}