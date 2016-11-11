
package twitter_api;

import java.util.ArrayList;

import Visuals.Display;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**Connects to the Twitter API through the Twitter4J library.
 * Provides static methods to perform various functions on Twitter.*/
public class TwitterAPI {

	/**Tests the TwitterAPI class.*/
	public static void main(String[] args) {
		ArrayList<Status> searchResults = searchTwitter("assassinate trump", 10);
		
		Display map = new Display();
		
		for (Status searchResult : searchResults)
			System.out.println('@' + searchResult.getUser().getScreenName() + ": " + searchResult.getText());
	}

	/**Searches Twitter given a query and number of results.*/
	public static ArrayList<Status> searchTwitter(String search, int size) {
		Twitter twitter = TwitterFactory.getSingleton();
		
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
}