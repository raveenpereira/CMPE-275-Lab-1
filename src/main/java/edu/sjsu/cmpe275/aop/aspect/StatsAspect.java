package edu.sjsu.cmpe275.aop.aspect;

import org.aspectj.lang.JoinPoint;
import java.util.*;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import edu.sjsu.cmpe275.aop.TweetStatsImpl;

/**
 * This class build up all the statictics of the tweeting service. The stats can
 * be accessed by calling the methods in the TweetStatsImpl class
 * 
 * @author Raveen
 * @version 1.1
 *
 */
@Aspect
public class StatsAspect {
	/**
	 * We use the afterReturning advice to build two stat features:length of
	 * longest tweet and the most productive user afterReturning is used because
	 * we need to calculate these stats only if the method executed successfully
	 * 
	 * @param joinPoint
	 *            used to capture method names and arguments
	 */
	@AfterReturning("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.tweet(..))")
	public void returnstats(JoinPoint joinPoint) {
		/**
		 * using joinPoint to get the length of the tweet message.
		 */

		int length = joinPoint.getArgs()[1].toString().length();
		if (length > TweetStatsImpl.lengthLongestTweet)
			TweetStatsImpl.lengthLongestTweet = length;
		/**
		 * If the productiveUser Hashmap already contains the user, just add the
		 * length Else create a new entry in the map with the user and the tweet
		 * length
		 */
		if (TweetStatsImpl.productiveUser.containsKey(joinPoint.getArgs()[0].toString())) {

			int oldLength = TweetStatsImpl.productiveUser.get(joinPoint.getArgs()[0].toString());
			TweetStatsImpl.productiveUser.put(joinPoint.getArgs()[0].toString(), oldLength + length);

		} else {

			TweetStatsImpl.productiveUser.put(joinPoint.getArgs()[0].toString(), length);

		}

	}

	/**
	 * The After advice is used to build up the following stat. After is used
	 * because even if the operation fails, this statistic has to be incremented
	 * 
	 * @param joinPoint
	 *            used to capture the method name and arguments
	 */
	@After("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.follow(..))")
	public void returnfollow(JoinPoint joinPoint) {
		String follower = joinPoint.getArgs()[0].toString();
		String followee = joinPoint.getArgs()[1].toString();

		if (TweetStatsImpl.following.containsKey(follower)) {

			/**
			 * I have used a Hashmap of arraylists in order to make sure the user dosent
			 * follow the same person again
			 */
			List<String> itemsList = TweetStatsImpl.following.get(follower);
			if (itemsList.contains(followee)) {
				System.out.println(follower + " is already following " + followee);
			} else {
				itemsList.add(followee);
				TweetStatsImpl.following.put(follower, itemsList);
			}

		} else {

			List<String> itemsList = new ArrayList<String>();

			itemsList.add(followee);
			TweetStatsImpl.following.put(follower, itemsList);

		}

	}
}