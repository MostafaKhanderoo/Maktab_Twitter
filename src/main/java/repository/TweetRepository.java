package repository;

import datasource.Datasource;
import entity.Tag;
import entity.Tweet;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TweetRepository {
    private static final String INSERT_SQL = """
            INSERT INTO tweet()
            VALUES(?)
            """;
    private static final String DELETE_BY_ID_SQL = """
            DELETE FROM tweet 
            WHERE id= ?
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM tweet 
            WHERE ID  = ?
            """;
    private static final String SELECT_ALL_TWEET = """
            SELECT * FROM tweet 
            """;
    private static final String FIND_BY_CREATOR = """
            SELECT * FROM tweet
            WHERE tweet = ?
            """;

    public Tweet save(String content) throws SQLException {

        var statement = Datasource.getConnection().prepareStatement(INSERT_SQL);

        statement.setString(1, content);
        statement.execute();
        statement.close();
        return null;

    }

    public void DeleteById(int id) throws SQLException {
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
                tweet = new Tweet(tweetId, content, creatTweetDate, creatorId);
            }
            return tweet;
        }

    }

    public List<Tweet> findAllTweet() {

        List<Tweet> tweets = new ArrayList<>();
        try (var statement = Datasource.getConnection().prepareStatement(SELECT_ALL_TWEET)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Long tweetId = resultSet.getLong(1);
                String content = resultSet.getString(2);
                Date creatTweetDate = resultSet.getDate(3);
                Long creatorId = resultSet.getLong(4);
                tweets.add(new Tweet(tweetId, content, creatTweetDate, creatorId));


            }
            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
                return null;
    }
}



