package repository;

import datasource.Datasource;
import entity.Tweet;

import java.sql.SQLException;

public class TweetRepository {
    private static final  String INSERT_SQL  = """
            INSERT INTO tweet()
            VALUES(?)
            """;
    private static final String DELETE_BY_ID_SQL= """
            DELETE FROM tweet 
            WHERE id= ?
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM tweet 
            WHERE ID  = ?
            """;
    private static final String FIND_BY_CREATOR = """
            SELECT * FROM tweet
            WHERE tweet = ?
            """;

    public Tweet save (Tweet tweet)throws SQLException{
      var statement =  Datasource.getConnection().prepareStatement(INSERT_SQL);
            statement.setString(1,tweet.getContent());
            statement.execute();
            statement.close();
            return tweet;

        }
    }





