import java.util.HashMap;
import java.util.Map;

class Product {
    private String productId;
    private String productName;
    private int quantity;
    private double price;

    // Constructor
    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

class Inventory {
    private Map<String, Product> products;

    public Inventory() {
        products = new HashMap<>();
    }

    // Add product to inventory
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Update product in inventory
    public void updateProduct(String productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Delete product from inventory
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product with ID " + productId + " not found.");
        }
    }

    // Display all products in inventory
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        // Adding products
        Product product1 = new Product("P001", "Laptop", 10, 999.99);
        Product product2 = new Product("P002", "Smartphone", 20, 499.99);
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        // Displaying products
        System.out.println("Inventory after adding products:");
        inventory.displayProducts();

        // Updating a product
        Product updatedProduct = new Product("P001", "Laptop", 15, 949.99);
        inventory.updateProduct("P001", updatedProduct);

        // Displaying products after update
        System.out.println("Inventory after updating a product:");
        inventory.displayProducts();

        // Deleting a product
        inventory.deleteProduct("P002");

        // Displaying products after deletion
        System.out.println("Inventory after deleting a product:");
        inventory.displayProducts();
    }
}
