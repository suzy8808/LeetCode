package dollar.kimi;

import java.util.HashMap;

public class MainTest {
	// ["MinStack","push","push","push","top","pop","getMin","pop","getMin","pop","push","top","getMin","push","top","getMin","pop","getMin"]
	// [[],[2147483646],[2147483646],[2147483647],[],[],[],[],[],[],[2147483647],[],[],[-2147483648],[],[],[],[]]
	public static void main(String[] args) throws InterruptedException {
		HashMap<Integer, Tweet> map = new HashMap<Integer, Tweet>();
		Tweet tweet2 = new Tweet(1, 0);
		map.put(1, tweet2);
		Tweet tweet = map.get(1);
		tweet.time = 1;
		System.out.println(map.get(1).time);
	}

}

class Tweet {
	int tweetId;
	int time;

	public Tweet(int tweetId, int time) {
		super();
		this.tweetId = tweetId;
		this.time = time;
	}

}
