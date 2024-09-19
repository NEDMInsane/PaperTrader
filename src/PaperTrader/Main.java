package PaperTrader;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Account loggedInAccount;

    public static Stock getNewStock(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter stock name: ");
        String name = sc.nextLine();
        System.out.print("Enter stock ticker: ");
        String ticker = sc.nextLine();
        System.out.print("Enter stock price: ");
        double price = sc.nextDouble();
        System.out.print("Enter stock amount: ");
        int amount = sc.nextInt();
        return new Stock(name, ticker, price, amount);
    }

    public static boolean verifyNewStock(Stock stock){
        Scanner sc = new Scanner(System.in);
        System.out.print("Is this stock correct?(Y/N): ");
        System.out.print(Arrays.toString(stock.getStockInfo()));
        if(sc.nextLine().equals("Y") || sc.nextLine().equals("y")){
            return true;
        } else {
            System.out.println("ERR: Stock not correct exiting to Main Menu...");
            return false;
        }
    }

    public static void mainMenu(){
        Scanner scnr = new Scanner(System.in);
        boolean running = true;
        while(running) {
            System.out.println("Paper Trader");
            System.out.println("1.) Print Portfolio");
            System.out.println("2.) Add Stock");
            System.out.println("3.) Sell Stock");
            System.out.println("4.) Change Price");
            System.out.println("5.) Change Quantity");
            System.out.println("6.) Quit");
            System.out.println("What would you like to do: ");
            String selection = scnr.next();
            switch(selection){
                case "1":
                    System.out.println("Selected \"Print Portfolio\"");
                    loggedInAccount.printPortfolio();
                    break;
                case "2":
                    System.out.println("Selected \"Add Stock\"");
                    Stock stock = getNewStock();
                    if(verifyNewStock(stock)){
                        loggedInAccount.appendPortfolio(stock);
                    }
                    break;
                case "3":
                    System.out.println("Selected \"Sell Stock\"");
                    break;
                case "4":
                    System.out.println("Selected \"Change Price\"");
                    break;
                case "5":
                    System.out.println("Selected \"Change Quantity\"");
                    break;
                case "6":
                case "q":
                    System.out.println("Quit");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option... Quitting...");
                    running = false;
            }
        }
    }

    public static boolean loginMenu(){
        //TODO: Actually implement login authentication.
        Scanner scnr = new Scanner(System.in);
        Random rand = new Random();
        System.out.print("Enter username: ");
        //Use the username for an account name plus random numbers.
        String username = scnr.nextLine();
        System.out.print("Enter password: ");
        String password = scnr.nextLine();
        String accountName = username + "-" + String.format("%04d", rand.nextInt(10000));
        Account account = new Account(accountName, 20000.00, null);
        System.out.println(Arrays.toString(account.getAccountInfo()));
        loggedInAccount = account;
        return true;
    }

    public static void main(String[] args) {
        if(loginMenu()){
            mainMenu();
        } else {
            System.out.println("ERR: Login Failed...");
        }
    }
}