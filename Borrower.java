package LibraryManagementSystem;

import java.util.HashMap;

public class Borrower {
    private String name;
    private int id;
    private HashMap<String, Book> books = new HashMap<>();

    public Borrower(String name, int id) {
        this.name = name;
        this.id = id;
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

    public int getId() {
        return id;
    }
}