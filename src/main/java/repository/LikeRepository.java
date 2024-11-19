package repository;

import datasource.Datasource;
import entity.LikeDislike;
import entity.LikeTweet;
import service.AuthenticationServices;

import java.sql.SQLException;

public class LikeRepository {

    private static final String  LIKE= """
            INSERT into like_dislike(user_id,tweet_id,likeTweet,dislikeTweet)
            VALUES (?,?,?,?)
           """;
    private static final String  DISLIKE= """
            INSERT into like_dislike(user_id,tweet_id,likeTweet,dislikeTweet)
            VALUES (?,?,?,?)
           """;
    public static LikeTweet likeTweet(LikeTweet likeTweet) {
        try (var statement = Datasource.getConnection().prepareStatement(LIKE)) {
            statement.setLong(1, likeTweet.getUserId());
            statement.setLong(2, likeTweet.getTweetId());
            statement.setBoolean(3, true);
            statement.setBoolean(4, false);
statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return likeTweet;
    }

    public static LikeTweet disLike(LikeTweet likeTweet) {
        try (var statement = Datasource.getConnection().prepareStatement(DISLIKE)) {
            statement.setLong(1, likeTweet.getUserId());
            statement.setLong(2, likeTweet.getTweetId());
            statement.setBoolean(3, false);
            statement.setBoolean(4, true);
           statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return likeTweet;

    }
}


