import org.example.Book;
import org.example.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class InventoryTest {
    private Inventory inventory;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        book1 = new Book("Book One", "Author One", 1, 25.98,  "Fiction");
        book2 = new Book("Book Two", "Author Two", 2 , 98.45, "Non-Fiction");
        inventory.addBook(book1);
        inventory.addBook(book2);
    }

    @Test
    public void testAddBook() {
        Book book3 = new Book("Book Three", "Author Three", 3 , 87.09, "Fiction");
        inventory.addBook(book3);
        assertEquals(3, inventory.getBookCount());
    }

    @Test
    public void testRemoveBook() {
        inventory.removeBook(1);
        assertEquals(1, inventory.getBookCount());
    }

    @Test
    public void testUpdateBook() {
        Book updatedBook = new Book("Updated Book One", "Updated Author One", 1 , 34.98, "Fiction");
        inventory.updateBook(1, updatedBook);
        assertEquals("Updated Book One", inventory.getBookById(1).getTitle());
    }

    @Test
    public void testGetBookById() {
        Book book = inventory.getBookById(1);
        assertNotNull(book);
        assertEquals("Book One", book.getTitle());
    }

    @Test
    public void testSearchByCategory() {
        List<Book> fictionBooks = inventory.searchByCategory("Fiction");
        assertEquals(1, fictionBooks.size());
    }

    @Test
    public void testGetCategories() {
        List<String> categories = inventory.getCategories();
        assertEquals(2, categories.size());
    }

    @Test
    public void testGetBookCount() {
        assertEquals(2, inventory.getBookCount());
    }

    @Test
    public void testGetBooks() {
        List<Book> books = inventory.getBooks();
        assertEquals(2, books.size());
    }
}