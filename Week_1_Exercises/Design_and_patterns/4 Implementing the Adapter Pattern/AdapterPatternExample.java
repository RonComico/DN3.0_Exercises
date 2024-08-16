// AdapterPatternExample.java

// Step 2: Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Step 3: Implement Adaptee Classes

// PayPal payment gateway
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment through PayPal: $" + amount);
    }
}

// Stripe payment gateway
class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment through Stripe: $" + amount);
    }
}

// Square payment gateway
class Square {
    public void completePayment(double amount) {
        System.out.println("Processing payment through Square: $" + amount);
    }
}

// Step 4: Implement the Adapter Class

// PayPal Adapter
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

// Stripe Adapter
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Square Adapter
class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.completePayment(amount);
    }
}

// Step 5: Test the Adapter Implementation
public class AdapterPatternExample {
    public static void main(String[] args) {
        // Create instances of payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapters for each payment gateway
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments through different adapters
        payPalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        squareAdapter.processPayment(300.0);
    }
}
