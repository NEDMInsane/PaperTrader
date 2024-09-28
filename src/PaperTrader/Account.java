package PaperTrader;

import java.util.Arrays;

public class Account {
    private String accountName = "";
    private double liquidCash = 0.0;
    private Stock[] portfolio = new Stock[0];

    public Account(String accountName, double liquidCash, Stock[] stocks){
        this.accountName = accountName;
        this.liquidCash = liquidCash;
        if(stocks == null){
            this.portfolio = new Stock[0];
        } else {
            this.portfolio = stocks;
        }
    }

    public void appendPortfolio(Stock addedStock){
        Stock[] appendedStocks = new Stock[portfolio.length+1];
        for(int i = 0; i < portfolio.length; i++){
            appendedStocks[i] = portfolio[i];
        }
        appendedStocks[appendedStocks.length-1] = addedStock;
        this.portfolio = appendedStocks;
    }

    public void buyStock(Stock stock){
        if(hasLiquid(stock.price() * stock.amount())){
            System.out.println("You have enough liquid cash");
            decrementLiquidCash(stock.price() * stock.amount());
            appendPortfolio(stock);
        } else {
            // TODO: Implement trading on margin.
            System.out.println("You do not have enough liquid cash");
        }
    }

    private void decrementLiquidCash(double price) {
        liquidCash -= price;
    }

    private void incrementLiquidCash(double price) {
        liquidCash += price;
    }

    private boolean hasLiquid(double price) {
        return liquidCash - price >= 0;
    }

    public void addStock(Stock stock){
        appendPortfolio(stock);
    }

    public void addStock(String name, String ticker, double price, int amount){
        Stock stock = new Stock(name, ticker, price, amount);
        if(portfolio == null){
            portfolio = new Stock[]{stock};
        } else {
            appendPortfolio(stock);
        }
    }

    public void printPortfolio(){
        for(Stock stock : this.portfolio){
            System.out.println(Arrays.toString(stock.getStockInfo()));
        }
    }

    public String[] getAccountInfo(){
        String[] info = new String[3];
        info[0] = accountName;
        info[1] = Double.toString(liquidCash);
        info[2] = Integer.toString(portfolio.length);
        return info;
    }
    public String getAccountName() {return accountName;}
    public double getLiquidCash() {return liquidCash;}
    public Stock[] getPortfolio() {return portfolio;}
    public void setAccountName(String accountName) {this.accountName = accountName;}
    public void setLiquidCash(double liquidCash) {this.liquidCash = liquidCash;}
    public void setPortfolio(Stock[] portfolio) {this.portfolio = portfolio;}
}
