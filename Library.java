package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    // private HashMap<String, Borrower> checkedOut = new HashMap<>();

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

        books.add(new Book(isbn, title, author, category));
        System.out.println("Book added successfully.");
    }

    public void checkoutBook() {
        String isbn;
        String id;

        System.out.print("Enter ISBN of the book to check out: ");
        isbn = sc.nextLine();
        System.out.print("Enter borrower name: ");
        sc.nextLine();
        System.out.print("Enter borrower id: ");
        id = sc.nextLine();
    }

    public void listBookStatus() {
        for (Book book : books) {
            book.printStatus();
        }
    }
}