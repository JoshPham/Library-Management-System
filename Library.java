package LibraryManagementSystem;

import java.util.HashMap;
import java.util.Scanner;

public class Library {
    private HashMap<String, Book> books = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);
    private HashMap<String, Borrower> borrowers = new HashMap<>();

    public Library() {}

    public void addBook() {
        String isbn;
        String title;
        String author;
        String category;
	
        System.out.print("Enter title: ");
        title = sc.nextLine();
        System.out.print("Enter author: ");
        author = sc.nextLine();
        System.out.print("Enter category: ");
        category = sc.nextLine();
        System.out.print("Enter ISBN: ");
        isbn = sc.nextLine();

        books.put(isbn, new Book(isbn, title, author, category));
        System.out.println("Book added successfully.");
    }

    public void removeBook() {
        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        if (books.containsKey(isbn)) {
            books.remove(isbn);
            System.out.println("Book removed successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void checkoutBook() {
        String isbn;
        String name;
        String id;

        System.out.print("Enter ISBN of the book to check out: ");
        isbn = sc.nextLine();

        if (!books.containsKey(isbn)) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter borrower name: ");
        name = sc.nextLine();
        System.out.print("Enter borrower id: ");
        id = sc.nextLine();

        if (!Borrower.containsId(id)) {
            borrowers.put(id, new Borrower(name, id));
        }
        if (books.get(isbn).checkAvailability()) {
            System.out.println("Book is already checked out.");
        } else {
            books.get(isbn).checkout(borrowers.get(id));
            borrowers.get(id).addBook(books.get(isbn));
            System.out.println("Book checked out successfully.");
        }
    }

    public void returnBook() {
        String isbn;
        String id;

        System.out.print("Enter ISBN of the book to return: ");
        isbn = sc.nextLine();

        if (!books.containsKey(isbn)) {
            System.out.println("Book not found.");
            return;
        }

        System.out.print("Enter borrower id: ");
        id = sc.nextLine();

        if (!Borrower.containsId(id)) {
            System.out.println("Borrower not found.");
        } else if (!books.get(isbn).checkAvailability() || !borrowers.get(id).getBooks().containsKey(isbn)) {
            System.out.println("Book is not checked out.");
        } else {
            books.get(isbn).returnBook();
            borrowers.get(id).returnBook(isbn);
            System.out.println("Book returned successfully.");
        }
    }

    public void listBookStatus() {
        if (!books.isEmpty()) {
            for (Book book : books.values()) {
                book.printStatus();
            }
        } else {
            System.out.println("No books in the library.");
        }
    }
}
