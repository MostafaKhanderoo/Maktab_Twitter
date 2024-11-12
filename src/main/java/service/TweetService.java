package service;

import entity.Tag;
import repository.TagRepository;
import repository.TweetRepository;

import java.sql.SQLException;
import java.util.List;

public class TweetService {

TweetRepository tweetRepository;
public  void createNewTweet(String content) throws SQLException {
    tweetRepository.save(content);
}

    TagRepository tagRepository;
    public List<Tag> viewAllTags(){
        List<Tag> tags = tagRepository.findAllTags() ;
        return tags;
    }

}
