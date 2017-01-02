package edu.sjsu.cmpe275.aop;

import java.util.*;
import java.util.Map.Entry;

/**
 * This class implements the TweetStats Interface
 * 
 * @author Raveen
 * @version 1.1
 *
 */
public class TweetStatsImpl implements TweetStats {
	/**
	 * lengthLongestTweet stores the length of the longest tweet until the next
	 * reset following is a Hashmap that stores a Username as key and the number
	 * of people he follows as value productiveUser is a Hashmap that stores
	 * Username as key and length of all his tweets
	 */
	public static int lengthLongestTweet;
	public static HashMap<String, Integer> productiveUser = new HashMap<String, Integer>();
	public static HashMap<String, List<String>> following = new HashMap<String, List<String>>();

	/**
	 * This method clears all the statistics
	 */
	public void resetStats() {
		lengthLongestTweet = 0;
		following.clear();
		productiveUser.clear();

	}

	/**
	 * returns the length of the longest tweet as integer
	 */
	public int getLengthOfLongestTweet() {

		return lengthLongestTweet;
	}

	/**
	 * returns a string value of the name of the most active follower
	 */
	public String getMostActiveFollower() {
		ArrayList<String> largestListnew = new ArrayList<String>();
		Entry<String, List<String>> maxnew = null;
		for (Entry<String, List<String>> i : following.entrySet()) {

			if (maxnew == null || i.getValue().size() > maxnew.getValue().size()) {
				// maxnew.setValue() = i.getKey().toString();
				maxnew = i;
				largestListnew.clear();
				largestListnew.add(maxnew.getKey());
			} else if (maxnew.getValue() == i.getValue()) {

				largestListnew.add(i.getKey());
			}

		}
		/**
		 * The results stored in an arraylist which is then sorted in
		 * alphabetical order The first element is returned if the list is not
		 * empty If list is empty null is returned
		 */
		Collections.sort(largestListnew);
		java.util.Collections.sort(largestListnew);
		if (largestListnew.size() == 0) {
			return null;
		} else {

			return largestListnew.get(0).toString();

		}

	}

	/**
	 * returns a string value of the most productive user
	 */
	public String getMostProductiveUser() {
		ArrayList<String> largestList1 = new ArrayList<String>();
		Entry<String, Integer> max = null;
		for (Entry<String, Integer> i : productiveUser.entrySet()) {
			if (max == null || i.getValue() > max.getValue()) {
				max = i;
				largestList1.clear();
				largestList1.add(max.getKey());
			} else if (max.getValue() == i.getValue()) {

				largestList1.add(i.getKey());
			}

		}
		/**
		 * The results stored in an arraylist which is then sorted in
		 * alphabetical order The first element is returned if the list is not
		 * empty
		 */
		Collections.sort(largestList1);
		java.util.Collections.sort(largestList1);
		if (largestList1.size() == 0) {
			return null;
		} else {

			return largestList1.get(0).toString();

		}

	}

}
