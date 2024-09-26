package PaperTrader;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    //public static Account loggedInAccount;

    public static void main(String[] args) {
        Account loggedInAccount = GraphicalInterface.login();

        if(loggedInAccount.equals(null)){
            GraphicalInterface.mainFrame();
        }

//        if(loginMenu()){
//            mainMenu();
//        } else {
//            System.out.println("ERR: Login Failed...");
//        }
    }
}