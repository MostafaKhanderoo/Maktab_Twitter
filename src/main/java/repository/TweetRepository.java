package repository;

import datasource.Datasource;
import entity.Tweet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class TweetRepository {
    private static final String INSERT_SQL = """
            INSERT INTO tweet(content ,user_id)
            VALUES(?,?)
            """;
    private static final String DELETE_BY_ID_SQL = """
            DELETE FROM tweet 
            WHERE tweet_id= ?
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM tweet 
            WHERE tweet_id  = ?
            """;
    private static final String SELECT_ALL_TWEET = """
            SELECT * FROM tweet 
            WHERE user_id != ?
            """;
    private static final String FIND_BY_CREATOR = """
            SELECT * FROM tweet
            WHERE tweet = ?
            """;
    private static final String SELECT_ALL_TWEET_BY_ID = """
            SELECT * FROM tweet 
            WHERE user_id = ?
            """;
    private  static  final String UPDATE_TWEET= """
            UPDATE tweet SET
            content = ?
            WHERE tweet_id = ?
            """;
    public Tweet save(Tweet tweet) throws SQLException {
        var statement = Datasource.getConnection().prepareStatement(INSERT_SQL);
     statement.setString(1,tweet.getContent());
     statement.setLong(2,tweet.getUserId());
        statement.execute();
        statement.close();

return tweet;
    }

    public static void DeleteById(Long id) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(DELETE_BY_ID_SQL)) {
            statement.setLong(1, id);
            var affectedRows = statement.executeUpdate();
            System.out.println("tweet deleted : " + affectedRows);
        }

    }

    public Tweet findById(int id) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_ID_SQL)) {
            statement.setLong(1, id);
            Tweet tweet = null;
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Long tweetId = resultSet.getLong(1);
                String content = resultSet.getString(2);
                Date creatTweetDate = resultSet.getDate(3);
                Long creatorId = resultSet.getLong(4);
            //    tweet = new Tweet(tweetId, content, creatTweetDate, creatorId);
            }
            return tweet;
        }

    }
    public List<Tweet> findAllTweetById(long id) throws SQLException {
        List<Tweet> tweets = new LinkedList<>();
        try (var statement = Datasource.getConnection().prepareStatement(SELECT_ALL_TWEET_BY_ID)) {
            statement.setLong(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.println("tets");

                Long tweetId = resultSet.getLong(1);
                String content = resultSet.getString(2);
                Date createTweetDate = resultSet.getDate(3);
                Long creatorId = resultSet.getLong(4);


                Tweet tweet = new Tweet(tweetId, content, createTweetDate, creatorId);


                tweets.add(tweet);

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return tweets;
    }


    public static List<Tweet> findAllTweet(Long id) {

        List<Tweet> tweets = new ArrayList<>();
        try (var statement = Datasource.getConnection().prepareStatement(SELECT_ALL_TWEET)) {
            statement.setLong(1,id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long tweetId = resultSet.getLong(1);
                String content = resultSet.getString(2);
                Date creatTweetDate = resultSet.getDate(3);
                Long creatorId = resultSet.getLong(4);
              Tweet tweet = new Tweet(tweetId,content,creatTweetDate,creatorId);
                tweets.add(tweet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                return tweets;
    }
    public  static Tweet updateUserTweet(Tweet tweet){
try(var statement=Datasource.getConnection().prepareStatement(UPDATE_TWEET)){
    statement.setString(1,tweet.getContent());
    statement.setLong(2,tweet.getTweetId());
    int affectedRows = statement.executeUpdate();
    if (affectedRows == 0) {
        System.out.println("update failed...");
        //throw new SQLException
    }
} catch (SQLException e) {
    e.printStackTrace();
}
return tweet;
    }

}



