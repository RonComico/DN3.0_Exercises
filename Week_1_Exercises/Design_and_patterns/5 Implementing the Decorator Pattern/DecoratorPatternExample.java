// DecoratorPatternExample.java

// Step 2: Define Component Interface
interface Notifier {
    void send(String message);
}

// Step 3: Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Step 4: Implement Decorator Classes

// Abstract Decorator Class
abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;

    public NotifierDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
    }
}

// Concrete Decorator for SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS: " + message);
    }
}

// Concrete Decorator for Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlack(message);
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack: " + message);
    }
}

// Step 5: Test the Decorator Implementation
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Create a basic notifier
        Notifier notifier = new EmailNotifier();

        // Decorate with SMS and Slack functionalities
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

        // Send notifications
        slackNotifier.send("Hello World!");
    }
}
