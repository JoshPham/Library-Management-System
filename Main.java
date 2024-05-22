package LibraryManagementSystem;

import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();
        boolean exit = false;
        System.out.println("Library Management System");

        while (!exit) {
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Checkout Book");
            System.out.println("4. Return Book");
            System.out.println("5. List Book Status");
            System.out.println("6. Exit");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    library.addBook();
                    break;
                case "2":
                    library.removeBook();
                    break;
                case "3":
                    library.checkoutBook();
                    break;
                case "4":
                    library.returnBook();
                    break;
                case "5":
                    library.listBookStatus();
                    break;
                case "6":
                    System.out.println("Exiting the program.");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }
}

