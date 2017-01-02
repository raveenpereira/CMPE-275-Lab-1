# CMPE-275-Lab-1
A web application that emulates Twitter. A user is able to tweet and follow another person.

In this lab, you implement the retry and stats concerns to a tweeting service through Aspect Oriented Programming (AOP). For ease of submission and grading, we wrap the two concerns into a single aspect, RetryAndDoStats.java. Please note this is an individual assignment.

Example Stats
The following examples are assuming stats are reset() before running every single example. 
Tweet message as tweet(“foo”,”barbar”). Then getLengthOfLongestTweet() returns 6.
Alice follows Bob, Bob follows Charlie (but fails to do so), and Bob follows Alice. getMostActiveFollower() returns “Bob”.
Successfully tweet a message ("Alice","[any message <= 140 chars]"), then getMostProductiveUser() returns “Alice”.


