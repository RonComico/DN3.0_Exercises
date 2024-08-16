// DependencyInjectionExample.java

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Step 2: Define Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// Step 3: Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    private Map<String, Customer> customers = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Adding some initial data
        customers.put("1", new Customer("1", "John Doe", "john.doe@example.com"));
        customers.put("2", new Customer("2", "Jane Smith", "jane.smith@example.com"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return customers.get(id);
    }
}

// Step 2: Define Model Class
class Customer {
    private String id;
    private String name;
    private String email;

    public Customer(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

// Step 4: Define Service Class
class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// Step 6: Test the Dependency Injection Implementation with User Interaction
public class DependencyInjectionExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerRepository customerRepository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(customerRepository);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Find Customer by ID");
            System.out.println("2. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter customer ID: ");
                    String id = scanner.nextLine();
                    Customer customer = customerService.findCustomerById(id);
                    if (customer != null) {
                        System.out.println("Customer Details:");
                        System.out.println("ID: " + customer.getId());
                        System.out.println("Name: " + customer.getName());
                        System.out.println("Email: " + customer.getEmail());
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;
                case 2:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
