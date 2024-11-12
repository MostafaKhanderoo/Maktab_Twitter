package view;

import entity.User;
import service.AuthenticationServices;
import service.TweetService;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserFront {

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
        System.out.print("enter your password");
        String password =scanner.nextLine();

        userService.userLogin(getText,password);
        User activeUser = AuthenticationServices.getLoggedInUser();
        logInUser(activeUser);
       // AuthenticationServices.getLoggedInUser(userService.userLogin());
    }

    public static void logInUser(User user) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1.create new tweet");
        System.out.println("2.view all tweet");
        System.out.println("3.change your profile");
        System.out.println("4.log out");
        System.out.print("choose: ");
        int choose = scanner.nextInt();
        boolean flag1 = true;
        while (flag1) {
            if (choose == 1) {
                createTweet();
            } else if (choose == 2) {
                viewAllTweet();
            } else if (choose == 3) {

            } else if (choose == 4) {
                flag1 = false;
            } else
                System.out.println("invalid number");
        }

    }
    public static void createTweet()throws  SQLException{
        Scanner scanner = new Scanner(System.in);
        TweetService tweetService = new TweetService();
        System.out.print("enter your content: ");
        String content = scanner.nextLine();
        tweetService.createNewTweet(content);
    }
    public static  void viewAllTweet(){

    }

}
