package content;

import apis.TwitterAPI;

public class SearchTwitterThread extends Thread {
	
	private String query;
	private int size;
	
	public SearchTwitterThread(String query, int size) {
		this.query = query;
		this.size = size;
	}
	
	public void run() {
		TwitterAPI.searchTwitter(query, size);
    }
}
