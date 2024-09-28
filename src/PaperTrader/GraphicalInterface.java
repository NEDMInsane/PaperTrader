package PaperTrader;

import javax.swing.*;
import java.awt.*;

public class GraphicalInterface {
    public static void login(LoginCallBack callback){
        Account[] loggedInAccount = new Account[1];
        JFrame frame = new JFrame();
        frame.setTitle("Paper Trader");
        frame.setSize(600, 300);
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
            Stock[] stocks = new Stock[]{new Stock("Apple", "AAPL", 30.24, 50)};
            loggedInAccount[0] = new Account("TestAccount-1234", 2000, stocks);
            callback.onLoginComplete(loggedInAccount[0]);
            System.out.println("Login Button clicked");
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            frame.dispose();
        });
        buttonPanel.add(loginButton);
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(e -> {
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.dispose();
        });
        buttonPanel.add(exitButton);
        frame.setVisible(true);
    }

    public static void mainFrame(Account account){
        JFrame frame = new JFrame();
        frame.setTitle("Paper Trader");
        frame.setSize(600, 800);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Create the menu bar
        JMenuBar menuBar = getMenuBar();

        // Set the menu bar for the frame
        frame.setJMenuBar(menuBar);
        JPanel mainPanel = new JPanel();
        frame.add(mainPanel);
        mainPanel.setBorder(BorderFactory.createTitledBorder(account.getAccountName()));
        mainPanel.setLayout(new GridLayout(1,2));

        // Create the button panel (left side) and add 3 buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // Vertical layout
        JButton buyStockButton = new JButton("Buy Stock");
        JButton sellStockButton = new JButton("Sell Stock");
        JButton updatePriceButton = new JButton("Update Price");

        // Add the buttons to the button panel
        buttonPanel.add(buyStockButton);
        buttonPanel.add(sellStockButton);
        buttonPanel.add(updatePriceButton);

        // Create the content panel (right side)
        JPanel contentPanel = getContentPanel();

        // Add the button panel to the left (WEST) and the content panel to the center
        mainPanel.add(buttonPanel);
        mainPanel.add(contentPanel);

        frame.setVisible(true);
    }

    private static JPanel getContentPanel() {
        JPanel contentPanel = new JPanel(new BorderLayout());

        // Create a table to display stock information (4 columns)
        String[] columnNames = {"Ticker", "Buy Price", "Current Price", "Amount"};
        Object[][] data = {
                {"AAPL", 145.0, 150.0, 10},
                {"GOOG", 2800.0, 2850.0, 5}
        };

        JTable stockTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(stockTable);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        return contentPanel;
    }

    private static JMenuBar getMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        // Create "File" menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0)); // Exit action

        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.addSeparator();  // Adds a separator line
        fileMenu.add(exitItem);

        // Create "Edit" menu
        JMenu editMenu = new JMenu("Edit");
        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        // Create "View" menu
        JMenu viewMenu = new JMenu("View");
        JMenuItem zoomInItem = new JMenuItem("Zoom In");
        JMenuItem zoomOutItem = new JMenuItem("Zoom Out");
        JMenuItem fullScreenItem = new JMenuItem("Full Screen");

        viewMenu.add(zoomInItem);
        viewMenu.add(zoomOutItem);
        viewMenu.add(fullScreenItem);

        // Add menus to the menu bar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);
        return menuBar;
    }
}
