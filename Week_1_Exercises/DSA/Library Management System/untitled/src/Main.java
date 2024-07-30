import java.util.Arrays;
import java.util.Scanner;

class Book implements Comparable<Book> {
    private String bookId;
    private String title;
    private String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }
}

class BookManager {
    private Book[] books;
    private int count;

    public BookManager(int size) {
        books = new Book[size];
        count = 0;
    }

    public void addBook(Book book) {
        if (count < books.length) {
            books[count] = book;
            count++;
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Book array is full.");
        }
    }

    public void linearSearch(String title) {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found: " + books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public void binarySearch(String title) {
        Arrays.sort(books, 0, count);  // Ensure the array is sorted
        int result = binarySearchHelper(books, title, 0, count - 1);
        if (result == -1) {
            System.out.println("Book not found.");
        } else {
            System.out.println("Book found: " + books[result]);
        }
    }

    private int binarySearchHelper(Book[] books, String title, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return mid;
            }

            if (comparison > 0) {
                return binarySearchHelper(books, title, left, mid - 1);
            }

            return binarySearchHelper(books, title, mid + 1, right);
        }

        return -1;
    }

    public void traverseBooks() {
        if (count == 0) {
            System.out.println("No books to display.");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.println(books[i]);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of books: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        BookManager manager = new BookManager(n);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Linear Search by Title");
            System.out.println("3. Binary Search by Title");
            System.out.println("4. Display All Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter bookId: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    Book book = new Book(bookId, title, author);
                    manager.addBook(book);
                    break;
                case 2:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    manager.linearSearch(title);
                    break;
                case 3:
                    System.out.print("Enter title to search: ");
                    title = scanner.nextLine();
                    manager.binarySearch(title);
                    break;
                case 4:
                    System.out.println("Book list:");
                    manager.traverseBooks();
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}