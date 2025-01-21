package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Book Inventory Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Update Book");
            System.out.println("4. Search Books by Category");
            System.out.println("5. View All Books");
            System.out.println("6. View All Categories");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    Book book = new Book(title, author, isbn, category);
                    inventory.addBook(book);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter ISBN of the book to remove: ");
                    String removeIsbn = scanner.nextLine();
                    inventory.removeBook(removeIsbn);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    System.out.print("Enter ISBN of the book to update: ");
                    String updateIsbn = scanner.nextLine();
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();
                    Book updatedBook = new Book(newTitle, newAuthor, updateIsbn, newCategory);
                    inventory.updateBook(updateIsbn, updatedBook);
                    System.out.println("Book updated successfully!");
                    break;
                case 4:
                    System.out.print("Enter category to search: ");
                    String searchCategory = scanner.nextLine();
                    List<Book> booksByCategory = inventory.searchByCategory(searchCategory);
                    System.out.println("Books in category '" + searchCategory + "':");
                    for (Book b : booksByCategory) {
                        System.out.println(b);
                    }
                    break;
                case 5:
                    List<Book> allBooks = inventory.getBooks();
                    System.out.println("All Books:");
                    for (Book b : allBooks) {
                        System.out.println(b);
                    }
                    break;
                case 6:
                    Set<String> categories = inventory.getCategories();
                    System.out.println("All Categories:");
                    for (String cat : categories) {
                        System.out.println(cat);
                    }
                    break;
                case 7:
                    exit = true;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
