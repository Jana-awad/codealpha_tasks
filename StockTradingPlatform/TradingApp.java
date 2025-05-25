package StockTradingPlatform;

import java.util.Scanner;

public class TradingApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        Stock apple = new Stock("Apple", 150.0);
        Stock google = new Stock("Google", 125.5);
        Stock amazon = new Stock("Amazon", 105.75);

        Stock[] market = { apple, google, amazon };


        Portfolio portfolio = new Portfolio(5000.0);

        boolean running = true;

        while (running) {
            System.out.println("\n--- Stock Trading Simulator ---");
            System.out.println("Your balance: $" + portfolio.balance);
            System.out.println("Available Stocks:");
            for (int i = 0; i < market.length; i++) {
                System.out.println( i + 1+":"+ market[i].name+","+ market[i].price);
            }
            System.out.println("\nMenu:");
            System.out.println("1. Buy Stock");
            System.out.println("2. Sell Stock");
            System.out.println("3. View Portfolio");
            System.out.println("4. Exit");
            System.out.print("Enter option: ");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter stock number to buy: ");
                    int buyChoice = sc.nextInt();
                    if (buyChoice < 1 || buyChoice > market.length) {
                        System.out.println("Invalid stock selection.");
                        break;
                    }
                    Stock stockToBuy = market[buyChoice - 1];

                    System.out.print("Enter quantity to buy: ");
                    int buyQuantity = sc.nextInt();

                    portfolio.buyStock(stockToBuy, buyQuantity);
                    break;

                case 2:
                    System.out.print("Enter the name of the stock to sell: ");
                    sc.nextLine();
                    String stockNameToSell = sc.nextLine();

                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = sc.nextInt();

                    portfolio.sellStock(stockNameToSell, sellQuantity);
                    break;

                case 3:
                    portfolio.viewPortfolio(market);
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting... Thanks for trading!");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
        sc.close();
    }
}
