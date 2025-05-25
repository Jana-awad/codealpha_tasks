package StockTradingPlatform;

import java.util.ArrayList;

public class Portfolio {
double balance;
ArrayList<Holding>holdings=new ArrayList<>();
public Portfolio(double balance) {
	this.balance=balance;
}
public void buyStock(Stock stock,int quantity) {
	double totalCost=stock.price*quantity;
	if(balance>totalCost) {
		balance-=totalCost;
		holdings.add(new Holding(stock,quantity,stock.price));
		System.out.println("Bought "+quantity+" shares of "+stock.name);
	}else {
		System.out.println("Not enough balance");
	}
}

public void sellStock(String stockName, int quantityToSell) {
    for (int i = 0; i < holdings.size(); i++) {
        Holding h = holdings.get(i);
        if (h.stock.name.equalsIgnoreCase(stockName)) {
            if (h.quantity >= quantityToSell) {
                double totalSale = h.stock.price * quantityToSell;
                balance += totalSale;
                h.quantity -= quantityToSell;
                System.out.println("Sold " + quantityToSell + " shares of " + stockName + " for $" + totalSale);
                if (h.quantity == 0) {
                    holdings.remove(i);
                }
                return;
            } else {
                System.out.println("You don't own enough shares to sell.");
                return;
            }
        }
    }
    System.out.println("You don't own any shares of " + stockName);
}

public void viewPortfolio(Stock[] market) {
    if (holdings.isEmpty()) {
        System.out.println("Your portfolio is empty.");
        return;
    }
    System.out.println("\nYour Portfolio:");
    double totalValue = 0;
    for (Holding h : holdings) {
       
        double currentPrice = 0;
        for (Stock s : market) {
            if (s.name.equals(h.stock.name)) {
                currentPrice = s.price;
                break;
            }
        }
        double value = currentPrice * h.quantity;
        double profit = (currentPrice - h.purchasePrice) * h.quantity;
        totalValue += value;
        System.out.println("Stock name:"+h.stock.name+"\n quantity: " +h.quantity +"\nPurchase Price" +h.purchasePrice+"\ncurrentPrice" +currentPrice+"\nprofit" + profit);
    }
    System.out.println("Total Portfolio Value:"+ totalValue);
}
}