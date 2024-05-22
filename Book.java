package LibraryManagementSystem;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private Borrower borrower;

    public Book(String isbn, String title, String author, String category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public void printStatus() {
        String availabilityStatus = checkAvailability()? String.format("Checked out by %s, (ID: %s)", borrower.getName(), borrower.getId()) : "Available";
        System.out.printf("Title: %s, Author: %s, Category: %s, ISBN: %s, Availability: %s", title, author, category, isbn, availabilityStatus);
    }

    public boolean checkAvailability() {
        return borrower != null;
    }

    public String getIsbn() {
        return isbn;
    }
}