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

    public User userSignUp(String accountName,String email,String username, String password,String bio) throws SQLException {
        var checkingUser = userRepository.findByUsername(username);
         var checkingEmail  = userRepository.findByEmail(email);
        User user = new User();
        if (checkingUser != null) {
            System.out.println("Username is already taken!");
            return null;
        }else
        if (checkingEmail != null){
            System.out.println("email is already taken!");
            return null;
        }else {

            User signing = new User();
            signing.setAccountName(accountName);
            signing.setEmail(email);
            signing.setUsername(username);
            signing.setPassword(password);
            signing.setBio(bio);

            return userRepository.save(signing);
        }

    }

    public boolean userLogin(String username, String password) throws SQLException {
        var checkingUserName = userRepository.findByUsername(username);
        var checkingUserEmail = userRepository.findByUsername(username);
        if (checkingUserName != null || checkingUserEmail !=null) {
            if (checkingUserName.getPassword().equals(password) || checkingUserEmail.getPassword().equals(password)) {
                AuthenticationServices.setLoggedUser(checkingUserName);
                return true;
            }
        }else
            System.out.println("UserName or email not found try again!  ");
        return false;
    }
}
