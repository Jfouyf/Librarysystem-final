package librarysystem;

import librarysystem.items.Book;
import librarysystem.items.EBook;
import librarysystem.items.LibraryItem;

import java.util.ArrayList;
import java.util.Scanner;

public class LibrarySystem {
    private ArrayList<LibraryItem> items;

    public LibrarySystem() {
        items = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
        System.out.println(item.getTitle() + " has been added to the library!");
    }

    public void displayAvailableBooksForBorrowing() {
        System.out.println("Books available for borrowing:");
        for (LibraryItem item : items) {
            if (item instanceof Book) {
                Book book = (Book) item;
                if (book.isAvailable()) {
                    System.out.println(book);
                }
            }
        }
    }

    public void displayAllReadableBooks() {
        System.out.println("Books available for reading:");
        for (LibraryItem item : items) {
            if (item instanceof EBook || (item instanceof Book && ((Book) item).isAvailable())) {
                System.out.println(item);
            }
        }
    }

    public void borrowBook(String itemId) {
        for (LibraryItem item : items) {
            if (item instanceof Book && item.getItemId().equals(itemId)) {
                Book book = (Book) item;
                if (book.isAvailable()) {
                    book.setAvailable(false);
                    System.out.println(book.getTitle() + " has been borrowed!");
                    return;
                } else {
                    System.out.println("Book is already borrowed!");
                    return;
                }
            }
        }
        System.out.println("Book not found!");
    }

    public void returnBook(String itemId) {
        for (LibraryItem item : items) {
            if (item instanceof Book && item.getItemId().equals(itemId)) {
                Book book = (Book) item;
                if (!book.isAvailable()) {
                    book.setAvailable(true);
                    System.out.println(book.getTitle() + " has been returned successfully!");
                    return;
                } else {
                    System.out.println("You did not borrow this book. Please check the book ID.");
                    return;
                }
            }
        }
        System.out.println("Invalid input. Either the book ID does not exist or it is an eBook.");
    }

    public void findBookByAuthor(String author) {
        boolean found = false;
        System.out.println("Books by author " + author + ":");
        for (LibraryItem item : items) {
            if (item.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(item);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by this author.");
        }
    }

    public void findBookById(String itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(itemId)) {
                System.out.println("Book found: " + item);
                return;
            }
        }
        System.out.println("No book found with the given ID.");
    }

    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();

        library.addItem(new Book("Java Programming", "John Doe", "B001", true));
        library.addItem(new Book("Data Structures", "Jane Smith", "B002", true));
        library.addItem(new Book("Operating Systems", "Alice Johnson", "B003", false));
        library.addItem(new EBook("Introduction to Algorithms", "Thomas Cormen", "E001"));
        library.addItem(new EBook("Artificial Intelligence", "Stuart Russell", "E002"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: 1. Borrow 2. Read 3. Return 4. Find");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                library.displayAvailableBooksForBorrowing();
                break;
            case 2:
                library.displayAllReadableBooks();
                break;
            case 3:
                System.out.println("Enter the book ID to return:");
                String itemId = scanner.next();
                library.returnBook(itemId);
                break;
            case 4:
                System.out.println("Find by: 1. Author 2. Book ID");
                int findChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (findChoice == 1) {
                    System.out.println("Enter the author's name:");
                    String author = scanner.nextLine();
                    library.findBookByAuthor(author);
                } else if (findChoice == 2) {
                    System.out.println("Enter the book ID:");
                    String bookId = scanner.nextLine();
                    library.findBookById(bookId);
                } else {
                    System.out.println("Invalid choice!");
                }
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

