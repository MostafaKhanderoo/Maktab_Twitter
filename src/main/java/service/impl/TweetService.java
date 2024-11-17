package service.impl;

import entity.Tag;
import entity.Tweet;
import repository.TagRepository;
import repository.TweetRepository;

import java.sql.SQLException;
import java.util.List;

public class TweetService {

TweetRepository tweetRepository;
    public Tweet createNewTweet(String content,long userId) throws SQLException {
        TweetRepository tweetRepository = new TweetRepository();
    Tweet creatTweet = new Tweet();
    creatTweet.setContent(content);
    creatTweet.setUserId(userId);
    tweetRepository.save(creatTweet);
        System.out.println("tweet crated...");
    return null;
}


    TagRepository tagRepository;
    public List<Tag> viewAllTags(){
        List<Tag> tags = tagRepository.findAllTags() ;
        return tags;
    }

}
