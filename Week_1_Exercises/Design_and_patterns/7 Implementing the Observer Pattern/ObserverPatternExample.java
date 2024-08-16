// ObserverPatternExample.java

import java.util.ArrayList;
import java.util.List;

// Step 2: Define Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Step 3: Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockName;
    private double stockPrice;

    public StockMarket() {
        this.observers = new ArrayList<>();
    }

    public void setStockPrice(String stockName, double stockPrice) {
        this.stockName = stockName;
        this.stockPrice = stockPrice;
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, stockPrice);
        }
    }
}

// Step 4: Define Observer Interface
interface Observer {
    void update(String stockName, double stockPrice);
}

// Step 5: Implement Concrete Observers
class MobileApp implements Observer {
    private String name;

    public MobileApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Mobile App " + name + " - Stock: " + stockName + " is now " + stockPrice);
    }
}

class WebApp implements Observer {
    private String name;

    public WebApp(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockName, double stockPrice) {
        System.out.println("Web App " + name + " - Stock: " + stockName + " is now " + stockPrice);
    }
}

// Step 6: Test the Observer Implementation
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp1 = new MobileApp("App1");
        Observer webApp1 = new WebApp("WebApp1");

        stockMarket.registerObserver(mobileApp1);
        stockMarket.registerObserver(webApp1);

        stockMarket.setStockPrice("ZOMATO", 150.00);
        stockMarket.setStockPrice("GMRINFRA", 2800.00);

        stockMarket.removeObserver(mobileApp1);

        stockMarket.setStockPrice("SUZLON", 3400.00);
    }
}
