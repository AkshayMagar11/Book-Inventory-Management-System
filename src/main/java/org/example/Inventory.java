package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// DataStructure used is List And Map List is used to store a list of book and Map is used to implement
// search by category as key is category and value is list of books
public class Inventory {
    private static Inventory instance;
    public List<Book> books = new ArrayList<Book>();
    public Map<String , List<Book>> category = new HashMap<String , List<Book>>();
    private Inventory() {}
    public static Inventory getInstance() {
        if (instance == null) {
            instance = new Inventory();
        }
        return instance;
    }

    public Boolean addBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                System.out.println("Book with ID " + book.getId() + " already exists.");
                return false;
            }
        }
        books.add(book);
        category.computeIfAbsent(book.getCategory(), k -> new ArrayList<>()).add(book);
        return true;
    }
// Remove method to remove a book from list and map category
    public void removeBook(int bookId) {
        Book bookToRemove = null;
        for (Book book : books) {
            if (book.getId() == bookId) {
                bookToRemove = book;
                break;
            }
        }
        if (bookToRemove != null) {
            books.remove(bookToRemove);
            category.get(bookToRemove.getCategory()).remove(bookToRemove);
        }
    }
    // This method allows to update the book details by taking id of the book and updated book object
    public void updateBook(int id, Book updatedBook) {
        Book bookToUpdate = null;
        for (Book book : books) {
            if (book.getId() == id) {
                bookToUpdate = book;
                break;
            }
        }
        if (bookToUpdate != null) {
            books.remove(bookToUpdate);
            category.get(bookToUpdate.getCategory()).remove(bookToUpdate);
            String newTitle = updatedBook.getTitle().isEmpty() ? bookToUpdate.getTitle() : updatedBook.getTitle();
            String newAuthor = updatedBook.getAuthor().isEmpty() ? bookToUpdate.getAuthor() : updatedBook.getAuthor();
            Double newPrice = updatedBook.getPrice() == null ? bookToUpdate.getPrice() : updatedBook.getPrice();
            String newCategory = updatedBook.getCategory().isEmpty() ? bookToUpdate.getCategory() : updatedBook.getCategory();

            Book finalUpdatedBook = new Book(newTitle, newAuthor, id, newPrice, newCategory);
            addBook(finalUpdatedBook);
        }
    }
// This function implements search by category where we return list of books for a given category
    public List<Book> searchByCategory(String category) {
        return this.category.getOrDefault(category, new ArrayList<>());

    }
    public List<Book> getBooks() {
        return books;
    }
    public int getBookCount() {
        return books.size();
    }
    public Book getBookById(int id){
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }
    public List<String> getCategories() {
        return new ArrayList<String>(category.keySet());
    }
    public Map<String, List<Book>> getCategoriesMap() {
        return category;
    }
}
