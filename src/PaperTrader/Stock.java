package PaperTrader;

public class Stock {
    private String name = "";
    private String ticker = "";
    private double price = 0.00;
    private int amount = 0;

    public Stock(String name, String ticker, double initialPrice, int amount){
        this.name = name;
        this.ticker = ticker;
        this.price = initialPrice;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }
    public String getTicker(){
        return ticker;
    }
    public double price(){
        return price;
    }
    public int amount(){
        return amount;
    }

    public void setPrice(double price){
        this.price = price;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }

    public String[] getStockInfo(){
        return new String[]{name, ticker, Double.toString(price), Integer.toString(amount)};
    }
}
