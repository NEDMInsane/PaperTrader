package PaperTrader;

import javax.swing.*;
import java.awt.*;

public class GraphicalInterface {
    public static Account login(){
        Account account = null;
        JFrame frame = new JFrame();
        frame.setTitle("Paper Trader");
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setLayout(new GridLayout(2,1));

        JPanel inputPanel = new JPanel();
        mainPanel.add(inputPanel);
        GridLayout layoutManager = new GridLayout(1,4);
        inputPanel.setLayout(layoutManager);
        JLabel usernameLabel = new JLabel("Username:");
        inputPanel.add(usernameLabel);
        JTextField usernameText = new JTextField();
        inputPanel.add(usernameText);
        JLabel passwordLabel = new JLabel("Password:");
        inputPanel.add(passwordLabel);
        JPasswordField passwordText = new JPasswordField();
        inputPanel.add(passwordText);


        JPanel buttonPanel = new JPanel();
        mainPanel.add(buttonPanel);
        buttonPanel.setLayout(new GridLayout(1,2));
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            System.out.println("Login Button clicked");
        });
        buttonPanel.add(loginButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            frame.dispose();
        });
        buttonPanel.add(exitButton);

        frame.setVisible(true);

        account = new Account("ASD", 2000, null);

        return account;
    }
}
