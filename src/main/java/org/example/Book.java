package org.example;

//public class Book {
//    private String title;
//    private String author;
//    private int id;
//    private Double price;
//    private String category;
//    public Book(String title, String author, int id, Double price, String category) {
//        this.title = title;
//        this.author = author;
//        this.id = id;
//        this.price = price;
//        this.category = category;
//    }
//    public String getTitle() {
//        return title;
//    }
//    public String getAuthor() {
//        return author;
//    }
//    public int getId() {
//        return id;
//    }
//    public Double getPrice() {
//        return price;
//    }
//    public String getCategory() {
//        return category;
//    }
//    public void setTitle(String title2) {
//        this.title = title2;
//    }
//    public void setAuthor(String author2) {
//        this.author = author2;
//    }
//    public void setId(int id2) {
//        this.id = id2;
//    }
//    public void setPrice(Double price2) {
//        this.price = price2;
//    }
//    public void setCategory(String category2) {
//        this.category = category2;
//    }
//    @Override
//    public String toString() {
//        return "[title=" + title + ", author=" + author + ", id=" + id + ", price=" + price + ", category="
//                + category + "]";
//    }
//
//}

public class Book {
    private String title;
    private String author;
    private int id;
    private Double price;
    private String category;

    public Book(String title, String author, int id, Double price, String category) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        if (price != null && price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.title = title;
        this.author = author;
        setId(id);
        setPrice(price);
        this.category = category;
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
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be positive.");
        }
        this.id = id;
    }

    public void setPrice(Double price) {
        if (price != null && price <= 0) {
            throw new IllegalArgumentException("Price must be positive.");
        }
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "[title=" + title + ", author=" + author + ", id=" + id + ", price=" + price + ", category=" + category + "]";
    }
}