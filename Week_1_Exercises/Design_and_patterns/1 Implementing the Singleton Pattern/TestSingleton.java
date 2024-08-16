// Logger.java
class Logger {
    // Step 2: Private static instance of Logger
    private static Logger instance;

    // Step 2: Private constructor
    private Logger() {
        // Initialization code, if any
    }

    // Step 3: Public static method to get the instance
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Example method to demonstrate logging functionality
    public void log(String message) {
        System.out.println("Log message: " + message);
    }
}

// TestSingleton.java
public class TestSingleton {
    public static void main(String[] args) {
        // Step 4: Verify singleton implementation
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Both references should point to the same instance
        System.out.println("Are both logger instances the same? " + (logger1 == logger2));

        // Test the logging functionality
        logger1.log("This is a log message.");
        logger2.log("This is another log message.");
    }
}
