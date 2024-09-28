package PaperTrader;

@FunctionalInterface
public interface LoginCallBack{
    void onLoginComplete(Account account);
}
