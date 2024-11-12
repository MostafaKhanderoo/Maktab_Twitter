package view;

import entity.Tag;
import entity.User;
import repository.TagRepository;
import repository.UserRepository;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is ELON MUSK");
        System.out.println("Welcome to --> X <--");

        boolean flag1= true;
        while (flag1 = true) {
            System.out.println("1.signUp");
            System.out.println("2.login");
            System.out.println("3.close application");
            System.out.print("choose: ");
            int choose = scanner.nextInt();
            if (choose == 1){
               UserFront.sign();
            }else if (choose == 2){
                UserFront.log();
            }else if (choose ==3){
                flag1 = false;
            }else
                System.out.println("invalid number!!!!");
        }





        }

    }

