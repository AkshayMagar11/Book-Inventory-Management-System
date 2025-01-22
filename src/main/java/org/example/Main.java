package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        Runnable menuRunnable = () -> {
            try {
                while (true) {
                    System.out.println("Choose an option:");
                    System.out.println("1. Add Book");
                    System.out.println("2. Update Book");
                    System.out.println("3. Remove Book");
                    System.out.println("4. Search Books by Category");
                    System.out.println("5. Display Books");
                    System.out.println("6. Display Categories");
                    System.out.println("7. Exit");

                    int choice = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        switch (choice) {
                            case 1:
                                System.out.println("Enter title:");
                                String title = scanner.nextLine();
                                System.out.println("Enter author:");
                                String author = scanner.nextLine();
                                System.out.println("Enter id:");
                                int id = scanner.nextInt();
                                System.out.println("Enter price:");
                                try {
                                    double price = Double.parseDouble(scanner.nextLine());
                                    System.out.println("Enter category:");
                                    String category = scanner.nextLine();
                                    Book newBook = new Book(title, author, id, price, category);
                                    inventory.addBook(newBook);
                                    System.out.println("Book added successfully.");
                                } catch (InputMismatchException e) {
                                    System.out.println("An error occurred: Invalid price input.");
                                    scanner.nextLine(); 
                                }
                                break;
                            case 2:
                                System.out.println("Enter id of the book to update:");
                                int updateId = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Enter new title:");
                                String newTitle = scanner.nextLine();
                                System.out.println("Enter new author:");
                                String newAuthor = scanner.nextLine();
                                System.out.println("Enter new price:");
                                double newPrice = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.println("Enter new category:");
                                try {
                                    String newCategory = scanner.nextLine();
                                    Book updatedBook = new Book(newTitle, newAuthor, updateId, newPrice, newCategory);
                                    inventory.updateBook(updateId, updatedBook);
                                    System.out.println("Book updated successfully.");
                                } catch (InputMismatchException e) {
                                    System.out.println("An error occurred: Invalid input.");
                                    scanner.nextLine();
                                }
                                String newCategory = scanner.nextLine();
                                Book updatedBook = new Book(newTitle, newAuthor, updateId, newPrice, newCategory);
                                inventory.updateBook(updateId, updatedBook);
                                System.out.println("Book updated successfully.");
                                break;
                            case 3:
                                System.out.println("Enter id of the book to remove:");
                                int removeId = scanner.nextInt();
                                inventory.removeBook(removeId);
                                System.out.println("Book removed successfully.");
                                break;
                            case 4:
                                System.out.println("Enter category to search:");
                                String searchCategory = scanner.nextLine();
                                System.out.println("Books in category " + searchCategory + ":");
                                for (Book book : inventory.searchByCategory(searchCategory)) {
                                    System.out.println(book.getTitle() + " by " + book.getAuthor());
                                }
                                break;
                            case 5:
                                System.out.println("All books in inventory:");
                                for (Book book : inventory.getBooks()) {
                                    System.out.println(book.getTitle() + " by " + book.getAuthor() + " in "
                                            + book.getCategory() + " category");
                                }
                                break;
                            case 6:
                                System.out.println("All categories:");
                                for (String cat : inventory.getCategories()) {
                                    System.out.println(cat);
                                }
                                break;

                            case 7:
                                System.out.println("Exiting........");
                                return;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        System.out.println("An error occurred: " + e.getMessage());
                        scanner.nextLine();
                    }
                }
            } finally {
                scanner.close();
            }
        };

        Thread menuThread = new Thread(menuRunnable);
        menuThread.start();
    }
}