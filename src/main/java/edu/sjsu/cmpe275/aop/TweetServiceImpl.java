package edu.sjsu.cmpe275.aop;

public class TweetServiceImpl implements TweetService {
	public static String user;
	public static String message;
	public static int counter;
	
	
	public void tweet(String user, String message){
		
		TweetServiceImpl.message=message;
		TweetServiceImpl.counter=TweetServiceImpl.counter+1;
		if (message.length()>140){
			throw new IllegalArgumentException();
		}
		
		
		System.out.println("User "+user +" has just tweeted this: "+message);
	}
	
	public void follow(String follower, String followee){
		
		System.out.println(follower+" is now following "+followee);
	}


}
