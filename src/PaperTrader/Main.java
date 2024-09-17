package PaperTrader;

import java.util.Scanner;

public class Main {
    private Stock[] stocks;

    public Stock[] appendStock(Stock addedStock){
        Stock[] appendedStocks = new Stock[stocks.length+1];
        for(int i = 0; i < this.stocks.length; i++){
            appendedStocks[i] = this.stocks[i];
        }
        appendedStocks[appendedStocks.length-1] = addedStock;
        return appendedStocks;
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
                    break;
                case "2":
                    System.out.println("Selected \"Add Stock\"");
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