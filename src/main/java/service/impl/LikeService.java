package service.impl;

import entity.LikeTweet;
import repository.LikeRepository;

public class LikeService {

    public static LikeTweet like(long userId, Long tweetId){
        LikeTweet likeTweet = new LikeTweet();
        likeTweet.setUserId(userId);
        likeTweet.setTweetId(tweetId);
        LikeRepository.likeTweet(likeTweet);
        System.out.println("liked  tweet");
return likeTweet;
    }

    public static LikeTweet disLike(long userId, Long tweetId) {
        LikeTweet likeTweet = new LikeTweet();

        likeTweet.setUserId(userId);
        likeTweet.setTweetId(tweetId);
        LikeRepository.disLike(likeTweet);
        System.out.println("disLike  tweet");
        return likeTweet;
    }

}
