package service.impl;

import entity.ReTweet;
import repository.TweetRepository;

import java.sql.SQLException;

public class RetweetService {

public static  void  createRetweet(String content ,Long userId,Long tweetId) throws SQLException {
    ReTweet reTweet = new ReTweet();
    reTweet.setContent(content);
    reTweet.setUserId(userId);
    reTweet.setTweetId(tweetId);

    TweetRepository.retweet(reTweet);
}

}
