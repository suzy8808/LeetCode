package dollar.kimi.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Twitter {
	HashMap<Integer, User> userMap;
	int time;

	/** Initialize your data structure here. */
	public Twitter() {
		userMap = new HashMap<Integer, User>();
		time = 1;
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		User user = getUser(userId);
		Tweet tweet = new Tweet(tweetId, time++);
		user.tweets.add(tweet);
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		User user = getUser(userId);
		List<Tweet> tweets = new ArrayList<Tweet>(user.tweets);

//		LinkedList<Tweet> linkedList = new LinkedList<Tweet>();
//		for (int i = 0; i < 10; i++)
//			linkedList.add(new Tweet(-1, -1));
//
//		for (Tweet tweet : tweets) {
//			for (int i = 0; i < 10; i++) {
//				if (linkedList.get(i).time < tweet.time) {
//					linkedList.add(i, tweet);
//					break;
//				}
//			}
//		}
//
//		for (Integer followeeId : user.followMap.keySet()) {
//			if (followeeId == userId)
//				continue;
//			User followee = getUser(followeeId);
//			for (Tweet tweet : followee.tweets) {
//				for (int i = 0; i < 10; i++) {
//					if (linkedList.get(i).time < tweet.time) {
//						linkedList.add(i, tweet);
//						break;
//					}
//				}
//			}
//		}
//		List<Integer> ans = new ArrayList<Integer>();
//		for (int i = 0; i < 10; i++) {
//			Tweet tweet = linkedList.get(i);
//			if (tweet.tweetId == -1)
//				break;
//			ans.add(tweet.tweetId);
//		}

		for (Integer followeeId : user.followMap.keySet()) {
			if (followeeId == userId)
				continue;
			User followee = getUser(followeeId);
			tweets.addAll(followee.tweets);
		}
		tweets.sort(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.time - o1.time;
			}
		});
		int len = tweets.size() > 10 ? 10 : tweets.size();
		List<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < len; i++) {
			ans.add(tweets.get(i).tweetId);
		}
		return ans;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		User follower = getUser(followerId);
		User followee = getUser(followeeId);

		follower.followMap.put(followeeId, followee);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		User follower = getUser(followerId);

		follower.followMap.remove(followeeId);
	}

	User getUser(int userId) {
		User user = null;
		if (!userMap.containsKey(userId)) {
			HashMap<Integer, User> followMap = new HashMap<Integer, Twitter.User>();
			List<Tweet> tweets = new ArrayList<Twitter.Tweet>();
			user = new User(userId, followMap, tweets);
			userMap.put(userId, user);
		} else {
			user = userMap.get(userId);
		}
		return user;
	}

	class User {
		int userId;
		HashMap<Integer, User> followMap;
		List<Tweet> tweets;

		public User(int userId, HashMap<Integer, User> followMap, List<Tweet> tweets) {
			super();
			this.userId = userId;
			this.followMap = followMap;
			this.tweets = tweets;
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
}
