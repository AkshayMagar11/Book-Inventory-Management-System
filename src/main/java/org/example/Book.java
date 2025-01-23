package org.example;


public class Book {
    private String title;
    private String author;
    private int id;
    private Double price;
    private String category;

    public Book(String title, String author, int id, Double price, String category) {
        setTitle(title);
        setAuthor(author);
        setId(id);
        setPrice(price);
        setCategory(category);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public Double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setTitle(String title) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive");
        }
        this.id = id;
    }

    public void setPrice(Double price) {
        if (price == null || price <= 0) {
            throw new IllegalArgumentException("Price must be positive and not Null");
        }
        this.price = price;
    }

    public void setCategory(String category) {
        if (category == null || category.isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }
        this.category = category;
    }


    @Override
    public String toString() {
        return "[title=" + title + ", author=" + author + ", id=" + id + ", price=" + price + ", category=" + category + "]";
    }
}