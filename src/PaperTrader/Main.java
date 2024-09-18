package PaperTrader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Stock[] stocks = new Stock[0];

    public static void appendStock(Stock addedStock){
        Stock[] appendedStocks = new Stock[stocks.length+1];
        for(int i = 0; i < stocks.length; i++){
            appendedStocks[i] = stocks[i];
        }
        appendedStocks[appendedStocks.length-1] = addedStock;
        stocks = appendedStocks;
    }

    public void addStock(String name, String ticker, double price, int amount){
        Stock stock = new Stock(name, ticker, price, amount);
        if(stocks == null){
            stocks = new Stock[]{stock};
        } else {
            appendStock(stock);
        }
    }

    public static void printStocks(){
        for(Stock stock : stocks){
            System.out.println(Arrays.toString(stock.getStockInfo()));
        }
    }

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

    public static void verifyNewStock(Stock stock){
        Scanner sc = new Scanner(System.in);
        System.out.print("Is this stock correct?(Y/N): ");
        System.out.print(Arrays.toString(stock.getStockInfo()));
        if(sc.nextLine().equals("Y")){
            appendStock(stock);
        } else {
            System.out.println("ERR: Stock not correct exiting to Main Menu...");
        }
    }

    public static void main(String[] args) {
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
                    printStocks();
                    break;
                case "2":
                    System.out.println("Selected \"Add Stock\"");
                    verifyNewStock(getNewStock());
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
}