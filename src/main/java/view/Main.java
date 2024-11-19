package view;

import entity.LikeDislike;
import entity.LikeTweet;
import entity.User;
import repository.LikeRepository;
import repository.UserRepository;
import service.LikeService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//ctrl + all + o
public class Main {
    public static void main(String[] args) throws SQLException {
        // codeRun();
        LikeTweet likeTweet = new LikeTweet();
        likeTweet.setUserId(2);
        likeTweet.setTweetId(3);
        //LikeRepository likeRepository = new LikeRepository();
      //  likeRepository.likeTweet(likeTweet);
        LikeService.like(likeTweet.getUserId(),likeTweet.getTweetId());
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

