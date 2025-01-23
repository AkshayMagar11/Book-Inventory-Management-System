package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    public List<Book> books = new ArrayList<Book>();;
    public Map<String , List<Book>> category = new HashMap<String , List<Book>>();


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
}
