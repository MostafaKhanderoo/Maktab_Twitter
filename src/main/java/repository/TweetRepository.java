package repository;

public class TweetRepository {
    private static final  String INSERT_SQL  = """
            INSERT INTO USERS()
            VALUES(?,?,?,?,?)
            """;
    private static final String DELETE_BY_ID_SQL= """
            DELETE FROM USERS 
            WHERE id= ?
            """;
    private static final String FIND_BY_ID_SQL = """
            SELECT * FROM USERS 
            WHERE ID  = ?
            """;
    private static final String FIND_BY_USERNAME = """
            SELECT * FROM USERS
            WHERE username = ?
            """;
    private static final String FIND_BY_EMAIL= """
            SELECT * FROM USERS
            WHERE email=?
            """;
}
