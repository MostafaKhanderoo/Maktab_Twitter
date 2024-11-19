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
        }else if (checkingEmail != null){
            System.out.println("email is already taken!");
            return null;
        }else {

            User signing = new User();
            signing.setAccountName(accountName);
            signing.setEmail(email);
            signing.setUsername(username);
            signing.setPassword(password);
            signing.setBio(bio);

             userRepository.save(signing);
            System.out.println("signing It was successful.");
             return user;
        }

    }

    public User userLogin(String getText, String password) throws SQLException {
        var checkingUserName = userRepository.findByUsername(getText);
        var checkingUserEmail = userRepository.findByEmail(getText);
        if (checkingUserName != null || checkingUserEmail !=null) {
            if (checkingUserName.getPassword().equals(password) || checkingUserEmail.getPassword().equals(password)) {
            //    AuthenticationServices.setLoggedUser();
                AuthenticationServices.setLoggedUser(checkingUserName);
                System.out.println("test");
            //    AuthenticationServices.setLoggedUser(checkingUserEmail);
                AuthenticationServices.getLoggedInUser();
                System.out.println( AuthenticationServices.getLoggedInUser().getAccountName());
                System.out.println(AuthenticationServices.getLoggedInUser().getUserId());
                System.out.println();

                System.out.println("log was successful.");

            }
        }else
            System.out.println("UserName or email not found try again!  ");
        return null;
    }

    public void logOut (){
      AuthenticationServices.logout();

    }
    public void updateProfile(String accountName,String email,String username, String password,String bio) throws SQLException {
      AuthenticationServices.getLoggedInUser().getAccountName();
      User user = new User();
      user.setAccountName(accountName);
      user.setEmail(email);
      user.setUsername(username);
      user.setPassword(password);
      user.setBio(bio);
        userRepository.update(user);
        System.out.println("updating finish..");

    }



}
