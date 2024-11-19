package view;

import entity.LikeTweet;
import service.impl.LikeService;

import java.sql.SQLException;
import java.util.Scanner;
//ctrl + all + o
public class Main {
    public static void main(String[] args) throws SQLException {
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

