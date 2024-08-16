// StrategyPatternExample.java

import java.util.Scanner;

// Step 2: Define Strategy Interface
interface PaymentStrategy {
    void pay(double amount);
}

// Step 3: Implement Concrete Strategies
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    private String cvv;
    private String expiryDate;

    public CreditCardPayment(String cardNumber, String cardHolderName, String cvv, String expiryDate) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;

    public PayPalPayment(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Step 4: Implement Context Class
class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}

// Step 5: Test the Strategy Implementation with User Interaction
public class StrategyPatternExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PaymentContext context = new PaymentContext();

        System.out.println("Select payment method:");
        System.out.println("1. Credit Card");
        System.out.println("2. PayPal");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                System.out.print("Enter Card Number: ");
                String cardNumber = scanner.nextLine();
                System.out.print("Enter Card Holder Name: ");
                String cardHolderName = scanner.nextLine();
                System.out.print("Enter CVV: ");
                String cvv = scanner.nextLine();
                System.out.print("Enter Expiry Date (MM/YY): ");
                String expiryDate = scanner.nextLine();

                PaymentStrategy creditCardPayment = new CreditCardPayment(cardNumber, cardHolderName, cvv, expiryDate);
                context.setPaymentStrategy(creditCardPayment);
                break;
                
            case 2:
                System.out.print("Enter PayPal Email: ");
                String email = scanner.nextLine();
                System.out.print("Enter PayPal Password: ");
                String password = scanner.nextLine();

                PaymentStrategy payPalPayment = new PayPalPayment(email, password);
                context.setPaymentStrategy(payPalPayment);
                break;
                
            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return;
        }

        System.out.print("Enter amount to pay: ");
        double amount = scanner.nextDouble();

        context.pay(amount);
        scanner.close();
    }
}
