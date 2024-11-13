package view;

import entity.Tag;
import entity.Tweet;
import entity.User;
import repository.TagRepository;
import repository.TweetRepository;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
//
//TweetRepository tweetRepository = new
//        TweetRepository();
//Tweet tweet = new Tweet("hi",null,1);

//tweetRepository.save(tweet);
        codeRun();

    }

    private static void codeRun() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is ELON MUSK");
        System.out.println("Welcome to --> X <--");
        boolean flag = true;
        while (flag) {
            System.out.println("1.signUp");
            System.out.println("2.login");
            System.out.println("3.close application");
            System.out.print("choose: ");
            int choose = scanner.nextInt();
            if (choose == 1) {
                UserFront.sign();
            } else if (choose == 2) {
                UserFront.log();
            } else if (choose == 3) {
                flag = false;
                System.out.println("closing application....");
            } else
                System.out.println("invalid number!!!!");
        }
    }

}

