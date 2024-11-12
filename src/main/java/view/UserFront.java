package view;

import entity.User;
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
        System.out.println("enter your bio about yourself: ");
        String bio =scanner.nextLine();
        userService.userSignUp(accountName,email,username,password,bio);



    }

}
