package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.HashMap;

public class Borrower {
    private String name;
    private String id;
    private HashMap<String, Book> books = new HashMap<>();
    private static ArrayList<String> borrowerIds = new ArrayList<>();

    public Borrower(String name, String id) {
        this.name = name;
        this.id = id;
        borrowerIds.add(id);
    }

    public static boolean containsId(String id) {
        return borrowerIds.contains(id);
    }

    public void addBook(Book book) {
        books.put(book.getIsbn(), book);
    }

    public void returnBook(String isbn) {
        books.remove(isbn);
    }

    public HashMap<String, Book> getBooks() {
        return books;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}