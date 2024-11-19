package repository;

import datasource.Datasource;
import entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.AuthenticationServices;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@NoArgsConstructor
public class UserRepository {

    private static final  String INSERT_SQL  = """
            INSERT INTO USERS(account_name ,email,username,password,bio)
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
    private static final String UPDATE_USER_SQL = """
            UPDATE USERS SET
            account_name=?,
            email=?,
            username=?,
            PASSWORD=?,
            BIO=?
    
            WHERE user_id=?
            """;


    public User save(User user)throws SQLException{
      var statement=  Datasource.getConnection().prepareStatement(INSERT_SQL);
      statement.setString(1,user.getAccountName());
        statement.setString(2,user.getEmail());
        statement.setString(3,user.getUsername());
        statement.setString(4,user.getPassword());
        statement.setString(5,user.getBio());
        statement.execute();
        statement.close();
        return user;
    }
    public void deleteById(int id)throws  SQLException{
        try(var statement=  Datasource.getConnection().prepareStatement(DELETE_BY_ID_SQL)){
            statement.setLong(1,id);
           var affectedRows =  statement.executeUpdate();
            System.out.println("Account delete: " +affectedRows);
        }
    }

    public User findById(int id)throws  SQLException{
        try(var statement=  Datasource.getConnection().prepareStatement(FIND_BY_ID_SQL)){
              statement.setLong(1 , id);
           ResultSet resultSet= statement.executeQuery();
           User user =  null;
           if (resultSet.next()){
               Long userId =resultSet.getLong( 1 );
               String accountName = resultSet.getString(2);
               String email = resultSet.getString(3);
               String username = resultSet.getString(4);
               String password = resultSet.getString(5);
               String bio = resultSet.getString(6);
               Date createDate =resultSet.getDate(7);

               user = new User(userId,accountName,email,username,password,bio,createDate);


           }
           return user;
        }

    }
    public User findByUsername(String username) throws SQLException {
        try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_USERNAME)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();

            User user = null;
            if (resultSet.next()) {
                Long userId = resultSet.getLong(1);
                String accountName = resultSet.getString(2);
                String email = resultSet.getString(3);
                String userName = resultSet.getString(4);
                String password = resultSet.getString(5);
                String bio = resultSet.getString(6);
                Date createDate = resultSet.getDate(7);

                user = new User(userId, accountName, email, userName, password, bio, createDate);


            }

            return user;
        }
    }
        public User findByEmail(String email) throws SQLException {
            try (var statement = Datasource.getConnection().prepareStatement(FIND_BY_EMAIL)) {
                statement.setString(1, email);
                ResultSet resultSet = statement.executeQuery();

                User user = null;
                if (resultSet.next()) {
                    Long userId =resultSet.getLong(1 );
                    String accountName = resultSet.getString(2);
                    String gmail = resultSet.getString(3);
                    String userName = resultSet.getString(4);
                    String password = resultSet.getString(5);
                    String bio = resultSet.getString(6);
                    Date createDate =resultSet.getDate(7);

                    user = new User(userId,accountName,gmail,userName,password,bio,createDate);


                }

                return user;
            }
    }
    public User update(User user) throws SQLException {

        try (
             var statement = Datasource.getConnection().prepareStatement(UPDATE_USER_SQL)) {

          var userId= AuthenticationServices.getLoggedInUser().getUserId();
            statement.setString(1, user.getAccountName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getBio());
            statement.setLong(6, userId);


            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                System.out.println("Update failed, no rows affected.");
             //   throw new SQLException
            }

            System.out.println("User updated successfully: ID = " + user.getUserId());

        } catch (SQLException e) {

        }

        return user;
    }




}
