package service.impl;

import entity.Tag;
import entity.Tweet;
import repository.TagRepository;
import repository.TweetRepository;

import java.sql.SQLException;
import java.util.List;

public class TweetService {

    TweetRepository tweetRepository;

    public Tweet createNewTweet(String content) throws SQLException {
        TweetRepository tweetRepository = new TweetRepository();
        Tweet creatTweet = new Tweet();
        creatTweet.setContent(content);
        creatTweet.setUserId(AuthenticationServices.getLoggedInUser().getUserId());
        tweetRepository.save(creatTweet);
        System.out.println("tweet crated...");
        return null;
    }


    TagRepository tagRepository;

    public List<Tag> viewAllTags() {
        List<Tag> tags = tagRepository.findAllTags();
        return tags;
    }

    public void selectUserTweets() throws SQLException {
        TweetRepository tweetRepository = new TweetRepository();
        var userId = AuthenticationServices.getLoggedInUser().getUserId();


        List<Tweet> tweets = tweetRepository.findAllTweetById(userId);

        if (tweets.isEmpty()) {
            System.out.println("No tweets found for this user.");
        } else {
            for (Tweet tweet : tweets) {

                System.out.println("Tweet id : " + tweet.getTweetId());
                System.out.println("Content :  " + tweet.getContent());
                System.out.println("CreateDate :  " + tweet.getCreateDate());
                System.out.println("UserId :  " + tweet.getUserId());
                System.out.println("----------------------");
            }
        }
    }

    public static void selectAllTweet() {
        var userId = AuthenticationServices.getLoggedInUser().getUserId();

        List<Tweet> tweets = TweetRepository.findAllTweet(userId);
        if (tweets.isEmpty()) {
            System.out.println("No tweet found.");
        } else {
            for (Tweet tweet : tweets) {

                System.out.println("Tweet id : " + tweet.getTweetId());
                System.out.println("Content :  " + tweet.getContent());
                System.out.println("CreateDate :  " + tweet.getCreateDate());
                System.out.println("UserId :  " + tweet.getUserId());
                System.out.println("----------------------");
            }
        }

    }
    public static Tweet updateTweet(Long id,String content){
        Tweet tweet = new Tweet();
        tweet.setTweetId(id);
        tweet.setContent(content);
        TweetRepository.updateUserTweet(tweet);
        System.out.println("update finish..");

return  tweet;
    }
    public static void deleteTweet(Long id) throws SQLException {
        TweetRepository.DeleteById(id);
    }


//    public List<Tweet> MyTweets(){
//
//
//    }

}
