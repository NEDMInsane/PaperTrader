package PaperTrader;

public class Stock {
    private String name = "";
    private String ticker = "";
    private double buyPrice = 0.00;
    private double currentPrice = 0.00;
    private int amount = 0;

    public Stock(String name, String ticker, double buyPrice, int amount){
        this.name = name;
        this.ticker = ticker;
        this.buyPrice = buyPrice;
        this.amount = amount;
    }

    public static void updateCurrentPrice(){
        // Check for price changes in stock, then update the current price.

    }

    public String getName(){
        return name;
    }
    public String getTicker(){
        return ticker;
    }
    public double price(){
        return currentPrice;
    }
    public double getBuyPrice() { return buyPrice; }
    public int amount(){
        return amount;
    }

    public void setCurrentPrice(double currentPrice){ this.currentPrice = currentPrice; }
    public void setBuyPrice(double buyPrice){
        this.buyPrice = buyPrice;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public void setTicker(String ticker){ this.ticker = ticker; }

    public String[] getStockInfo(){
        return new String[]{name, ticker, Double.toString(buyPrice), Double.toString(currentPrice), Integer.toString(amount)};
    }
}
