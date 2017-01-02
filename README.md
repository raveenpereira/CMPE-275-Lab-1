# CMPE-275-Lab-1
A web application that emulated Twitter. A user is able to tweet and follow another person.
CMPE 275 - Lab 1  using Aspect Oriented Programming
In this lab, you implement the retry and stats concerns to a tweeting service through Aspect Oriented Programming (AOP). For ease of submission and grading, we wrap the two concerns into a single aspect, RetryAndDoStats.java. Please note this is an individual assignment.



For your testing purpose, you need to provide your own implementation of TweetServiceImpl.java, and simulate failures, but you do not need to submit this file, as the TA will use his own implementation(s) for grading purpose.
Project Setup
You can refer to the tutorial here on how to start the lab. A sample project with build file with dependencies, application context, and Java files is here (version 1-1, last updated on 11:38 pm 10/8/2016) for your reference and testing.
Example Stats
The following examples are assuming stats are reset() before running every single example. Additional test cases will be used for grading.
Tweet message as tweet(“foo”,”barbar”). Then getLengthOfLongestTweet() returns 6.
Alice follows Bob, Bob follows Charlie (but fails to do so), and Bob follows Alice. getMostActiveFollower() returns “Bob”.
Successfully tweet a message ("Alice","[any message <= 140 chars]"), then getMostProductiveUser() returns “Alice”.


