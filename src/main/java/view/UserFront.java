package view;

import entity.User;
import repository.TweetRepository;
import service.impl.*;

import java.sql.SQLException;
import java.util.Scanner;

public class UserFront {
    static  final Scanner scanner = new Scanner(System.in);

    public static void sign()throws SQLException {
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("singing page...");
        User user = new User();
        System.out.print("enter your accountName: ");
        String accountName =scanner.nextLine();
        System.out.print("enter your email: ");
        String email =scanner.nextLine();
        System.out.print("enter your username: ");
        String username =scanner.nextLine();
        System.out.print("enter your password: ");
        String password =scanner.nextLine();
        System.out.print("enter your bio about yourself: ");
        String bio =scanner.nextLine();
        userService.userSignUp(accountName,email,username,password,bio);



    }
    public static void log()throws SQLException{
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);
        System.out.println("log page...");
        System.out.print("enter your username OR email: ");
        String getText = scanner.nextLine();
        System.out.print("enter your password: ");
        String password =scanner.nextLine();

        userService.userLogin(getText,password);


        logInUser();
     //   AuthenticationServices.getLoggedInUser(userService.userLogin());
    }

    public static void logInUser() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.create new tweet");
        System.out.println("2.view all tweets");
        System.out.println("3.view my tweets");
        System.out.println("4.change your profile");
        System.out.println("5.log out");
        System.out.print("choose: ");
        int choose = scanner.nextInt();
        UserService userService = new UserService();
        boolean flag1 = true;
        while (flag1) {
            if (choose == 1) {
                createTweet();
                break;
            } else if (choose == 2) {
                viewAllTweet();
                System.out.println("All tweet... ");
                System.out.println();
                System.out.println("Choose what you want to do.");

                System.out.println("1.like this tweet.");
                System.out.println("2.disLike this tweet.");
                System.out.println("3.retweet to this tweet.");
                System.out.println("4.Return to the previous page.");
                System.out.print("choose : ");
                int choose2 = scanner.nextInt();
                if (choose2 ==1){
                    likeSomeTweet();
                }else if (choose2==2){
                    dislikeSomeTweet();
                }else if (choose2==3){
                    retweet();
                    break;
                }else if (choose2==4){

                }else
                    System.out.println("invalid number");



                break;
            } else if (choose == 3) {
                viewAllTweetById();

                System.out.println("tweet ");
                System.out.println();
                System.out.println("Choose what you want to do.");

                System.out.println("1.update my tweet...");
                System.out.println("2.delete my tweet...");
                System.out.println("3.Return to the previous page.");
                System.out.print("choose : ");
                int choose1 = scanner.nextInt();
                if (choose1 ==1){
                    updateTweet();
                }else if (choose1==2){
                    deleteTweet();
                }else if (choose1==3){
                    break;
                }else System.out.println("invalid number");
                break;
            }
            else if(choose == 4){
            updateProfile();
            }else if (choose == 5) {
                userService.logOut();
                flag1 = false;
                System.out.println("Logging Out.......");
            } else
                System.out.println("invalid number");
        }

    }
    public static void createTweet()throws  SQLException{
        System.out.println("Tweet...");
        TweetRepository tweetRepository = new TweetRepository();
        Scanner scanner = new Scanner(System.in);

        TweetService tweetService = new TweetService();
        System.out.print("enter your content: ");
        String content = scanner.nextLine();
       // Tweet tweet = new Tweet(1,content,null,null,1);
        tweetService.createNewTweet(content);

    }
    public  static void updateProfile() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("update profile page..");
        UserService userService = new UserService();
        User user = new User();
        System.out.print("enter your new accountName: ");
        String accountName =scanner.nextLine();
        System.out.print("enter your new email: ");
        String email =scanner.nextLine();
        System.out.print("enter your new username: ");
        String username =scanner.nextLine();
        System.out.print("enter your new password: ");
        String password =scanner.nextLine();
        System.out.print("enter your new bio about yourself: ");
        String bio =scanner.nextLine();
        userService.updateProfile(accountName,email,username,password,bio);
return;
    }

    public static  void viewAllTweet(){
TweetService.selectAllTweet();
    }
    public static void viewAllTweetById() throws SQLException {
        TweetService tweetService = new TweetService();
        tweetService.selectUserTweets();

    }

public static void updateTweet(){
        Scanner scanner = new Scanner(System.in);

    System.out.print("enter tweet id : ");
    Long numberId = scanner.nextLong();
    scanner.nextLine();
    System.out.printf("enter new content: ");
    String newContent = scanner.nextLine();
        TweetService.updateTweet(numberId ,newContent);
}
public static void deleteTweet() throws SQLException {

    System.out.print("choose Tweet to delete: ");
    Long id = scanner.nextLong();
TweetService.deleteTweet(id);
}


public static  void likeSomeTweet(){
     var userId=   AuthenticationServices.getLoggedInUser().getUserId();
    System.out.println("enter tweetId");
    Long tweetId= scanner.nextLong();
    LikeService.like(userId,tweetId);


}

    public static  void dislikeSomeTweet(){
        var userId=   AuthenticationServices.getLoggedInUser().getUserId();
        System.out.println("enter tweetId");
        Long tweetId= scanner.nextLong();
        LikeService.disLike(userId,tweetId);


    }
    public static void retweet() throws SQLException {
        System.out.println("ReTweet...");
       var userId= AuthenticationServices.getLoggedInUser().getUserId();
        RetweetService retweetService = new RetweetService();
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter your content: ");
        String content = scanner.nextLine();
        System.out.print("choose tweet Id: ");
        Long tweetId = scanner.nextLong();
        RetweetService.createRetweet(content,userId,tweetId);

    }


}
