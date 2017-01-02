package edu.sjsu.cmpe275.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext appcontext = new ClassPathXmlApplicationContext("beans.xml");
		TweetService tsi = (TweetService) appcontext.getBean("sample");
		TweetStats tstat = (TweetStats) appcontext.getBean("sample2");
		try {

			 tsi.tweet("John", "HI");
		//	 tsi.tweet("Peter", "Hello");
	//		tsi.tweet("Raveena", "Hey this is my first tweetlhfblkjsbdfkjsbdfkjbwakdu");

			 tsi.tweet("Raveen","Hey this is my first tweetlhfblkjsbdfkjsbdfkjbwakdufhbaudhfaudshf;uadwsf;uawdbf;uawdbsf;iuabwe;bcfua;weiubdfc;iaeuwbbfrjdsclvwsdibfaiuwefncb;awejdbks");
				tsi.tweet("Aaveena", "Hey this is my first tweetlhfblkjsbdfkjsbdfkjbwakdu");

			 tsi.follow("Raveen", "followee");
			 tsi.follow("Aay", "followee");
			 tsi.follow("Aay", "followee");
			tsi.follow("followee", "Aay");
			tsi.follow("Way", "John");
			tsi.follow("Way", "Johen");
			tsi.follow("Way", "Joheen");
			System.out.println("Longest tweet length=" + tstat.getLengthOfLongestTweet());

			System.out.println("Most Active Follower is " + tstat.getMostActiveFollower());
			System.out.println("Most Productive User is  " + tstat.getMostProductiveUser());
			System.out.println("reset called");
			tstat.resetStats();
			//tsi.follow("Raveen", "John");
		
			// System.out.println("Length is:"+tstat.getLengthOfLongestTweet());
			System.out.println("Longest tweet length = " + tstat.getLengthOfLongestTweet());

			System.out.println("Most Active Follower is " + tstat.getMostActiveFollower());
			System.out.println("Most Productive User is  " + tstat.getMostProductiveUser());

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
