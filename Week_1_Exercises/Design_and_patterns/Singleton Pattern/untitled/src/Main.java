public class SingletonPatternExample {

    // Singleton Logger class
    public static class Logger {
        // Private static instance of Logger class
        private static Logger instance;

        // Private constructor to prevent instantiation
        private Logger() {
            // Initialize resources if needed
        }

        // Public method to provide access to the instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method for demonstration
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    public static void main(String[] args) {
        // Get the single instance of Logger
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Test the Singleton implementation
        if (logger1 == logger2) {
            System.out.println("Both logger1 and logger2 refer to the same instance.");
        } else {
            System.out.println("Different instances exist.");
        }

        // Use the logger instance to log messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");
    }
}
