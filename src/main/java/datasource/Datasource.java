package datasource;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Datasource {
    @Getter
    private static final Connection connection;
    private Datasource(){

    }
    static {
        var jdbc="jdbc:postgresql://localhost:5432/postgres";
        try {
             connection = DriverManager.getConnection(jdbc,"postgres","mostafa11684");
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        Runtime.getRuntime().addShutdownHook(new Thread(){
            public void run(){
                try {
                    connection.close();
                } catch (SQLException e) {
                   throw new RuntimeException(e);
                }
            }
        });
    }

   public static Connection getConnection(){
    return connection;
   }

}
