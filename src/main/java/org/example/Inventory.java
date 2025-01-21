package org.example;


import java.util.*;

public class Inventory {
    private Map<String, Book> bookMap;
    private Map<String, List<Book>> categoryMap;

    public Inventory() {
        this.bookMap = new HashMap<>();
        this.categoryMap = new HashMap<>();
    }

    // Add a book to the inventory
    public void addBook(Book book) {
        bookMap.put(book.getIsbn(), book);
        categoryMap.computeIfAbsent(book.getCategory().toLowerCase(), k -> new ArrayList<>()).add(book);
    }

    // Remove a book from the inventory
    public void removeBook(String isbn) {
        Book book = bookMap.remove(isbn);
        if (book != null) {
            List<Book> booksInCategory = categoryMap.get(book.getCategory().toLowerCase());
            if (booksInCategory != null) {
                booksInCategory.remove(book);
                if (booksInCategory.isEmpty()) {
                    categoryMap.remove(book.getCategory().toLowerCase());
                }
            }
        }
    }

    // Update a book in the inventory
    public void updateBook(String isbn, Book updatedBook) {
        Book oldBook = bookMap.get(isbn);
        if (oldBook != null) {
            removeBook(isbn);
            addBook(updatedBook);
        }
    }

    // Get a book by ISBN
    public Book getBookByIsbn(String isbn) {
        return bookMap.get(isbn);
    }

    // Search books by category
    public List<Book> searchByCategory(String category) {
        return categoryMap.getOrDefault(category.toLowerCase(), Collections.emptyList());
    }

    public List<Book> getBooks() {
        return new ArrayList<>(bookMap.values());
    }
    // Get all categories
    public Set<String> getCategories() {
        return categoryMap.keySet();
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "books=" + bookMap.values() +
                '}';
    }
    public int getBookCount() {
        return bookMap.size();
    }
}