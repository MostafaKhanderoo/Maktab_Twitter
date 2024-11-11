package view;

import entity.User;
import repository.UserRepository;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        UserRepository userRepository = new UserRepository();
        User user = new User(1,"mostafa", "mostafakhanderoo7@gmail.com","mostafa","11684","hello my name is mostafa",null,1);



   userRepository.deleteById(1);
    }
}
