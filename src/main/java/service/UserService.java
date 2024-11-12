package service;

import entity.Tweet;
import entity.User;
import repository.TweetRepository;
import repository.UserRepository;

import java.sql.SQLException;

public class UserService {
    UserRepository userRepository;
    TweetRepository tweetRepository;
  public UserService() throws SQLException {
      userRepository = new UserRepository();
      tweetRepository = new TweetRepository();
  }

    public User userSignUp(String username, String password) throws SQLException {
        var checkingUser = userRepository.findByUsername(username);

        if (checkingUser != null) {
            System.out.println("Username is already taken!");
            return null;
        }

        User signingUpUser = new User();
        signingUpUser.setUsername(username);
        signingUpUser.setPassword(password);

        return userRepository.save(signingUpUser);
    }

    public boolean userLogin(String username, String password) throws SQLException {
        var checkingUser = userRepository.findByUsername(username);
        if (checkingUser != null) {
            if (checkingUser.getPassword().equals(password)) {
                AuthenticationServices.setLoggedUser(checkingUser);
                return true;
            }
        }
        return false;
    }
}
