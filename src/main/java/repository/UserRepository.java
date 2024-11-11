package repository;

import datasource.Datasource;
import entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    public User save(User user)throws SQLException{
      var statement=  Datasource.geConnection().prepareStatement(INSERT_SQL);
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
        try(var statement=  Datasource.geConnection().prepareStatement(DELETE_BY_ID_SQL)){
            statement.setLong(1,id);
           var affectedRows =  statement.executeUpdate();
            System.out.println("Account delete: " +affectedRows);
        }
    }

    public User findById(int id)throws  SQLException{
        try(var statement=  Datasource.geConnection().prepareStatement(FIND_BY_ID_SQL)){
            statement.setLong(1 , id);
           ResultSet resultSet= statement.executeQuery();
           User user =  null;
           if (resultSet.next()){
               Long userId =resultSet.getLong(1 );
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



}
