import java.util.Arrays;
import java.util.Scanner;

class Product implements Comparable<Product> {
    private String productId;
    private String productName;
    private String category;

    public Product(String productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int compareTo(Product other) {
        return this.productId.compareTo(other.productId);
    }
}

class LinearSearch {
    public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
}

class BinarySearch {
    public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Product[] products = new Product[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter productId: ");
            String productId = scanner.nextLine();
            System.out.print("Enter productName: ");
            String productName = scanner.nextLine();
            System.out.print("Enter category: ");
            String category = scanner.nextLine();
            products[i] = new Product(productId, productName, category);
        }

        // Perform Linear Search
        System.out.print("Enter productId to search (Linear Search): ");
        String searchId = scanner.nextLine();
        Product result1 = LinearSearch.linearSearch(products, searchId);
        if (result1 != null) {
            System.out.println("Product found: " + result1);
        } else {
            System.out.println("Product not found");
        }

        // Sort the array for Binary Search
        Arrays.sort(products);

        // Perform Binary Search
        System.out.print("Enter productId to search (Binary Search): ");
        searchId = scanner.nextLine();
        Product result2 = BinarySearch.binarySearch(products, searchId);
        if (result2 != null) {
            System.out.println("Product found: " + result2);
        } else {
            System.out.println("Product not found");
        }

        scanner.close();
    }
}
