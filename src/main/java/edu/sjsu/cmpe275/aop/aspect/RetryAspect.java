package edu.sjsu.cmpe275.aop.aspect;

import java.io.IOException;
import org.aspectj.lang.*;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * This class implements the Retrying aspect of our program.
 * 
 * @author Raveen
 * @version 1.1
 *
 */
@Aspect
public class RetryAspect {
	
	/**
	 * This method is used to implement logic for retrying to publish a tweet 
	 * in case of network errors or illegal length
	 * @param proceedingJoinPoint executes the method
	 * @throws Throwable throws an exception
	 */
	@Around("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.tweet(..))")
	public void retryTweet(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		int count = 1;
		int max = 3;
		/**
		 * If an IOException is thrown two more retries are attempted If an
		 * IllegalArgumentException is thrown an appropriate message is
		 * displayed
		 */
		while (true) {
			try {

				proceedingJoinPoint.proceed();
				// System.out.println("sucess");
				break;

			} catch (IOException e) {
				System.out.println("Retrying " + count + " time");
				if (++count == max) {
					System.out.println("Operation Failed. Network Failure");
					break;
					// proceedingJoinPoint.proceed();
					// throw e;

				}
			} catch (IllegalArgumentException e) {
			
				System.out.println("Tweet not published.Illegal length");
				// throw e;
				break;
				
			}

		}

	}

	/**
	 * This method implements the retry logic for following
	 * 
	 * @param proceedingJoinPoint  executes the method
	 *           
	 * @throws Throwable  throws an exception
	 *            
	 */
	@Around("execution(* edu.sjsu.cmpe275.aop.TweetServiceImpl.follow(..))")
	public void retryFollow(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		// System.out.println("before follow");
		int count = 1;
		int max = 3;
		while (true) {

			try {
				proceedingJoinPoint.proceed();
				break;
			} catch (IOException e) {
				System.out.println("Retrying " + count + " time");
				if (++count == max) {
					System.out.println("Operation Failed. Network Failure");
					// proceedingJoinPoint.proceed();
					//throw e;
					break;

				}

			}

		}
	}

}
