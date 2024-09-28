package PaperTrader;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Account loggedInAccount;

    public static void main(String[] args) {
        GraphicalInterface.login(account -> {
            if(account != null) {
                loggedInAccount = account;
                System.out.println("Logged in as: " + loggedInAccount.getAccountName());
                GraphicalInterface.mainFrame(loggedInAccount);
            } else {
                System.out.println("Log in failed!!!");
            }
                });

//        if(loginMenu()){
//            mainMenu();
//        } else {
//            System.out.println("ERR: Login Failed...");
//        }
    }
}