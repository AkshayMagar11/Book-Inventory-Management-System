import org.example.Book;
import org.example.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class NegativeInventoryTest {
    private Inventory inventory;
    private Book book1;
    private Book book2;

    @BeforeEach
    public void setUp() {
        inventory = new Inventory();
        book1 = new Book("Book One", "Author One", 1, 25.98, "Fiction");
        book2 = new Book("Book Two", "Author Two", 2, 98.45, "Non-Fiction");
        inventory.addBook(book1);
        inventory.addBook(book2);
    }

    @Test
    public void testAddDuplicateBook() {
        Book duplicateBook = new Book("Book One", "Author One", 1, 25.98, "Fiction");
        inventory.addBook(duplicateBook);
        assertEquals(2, inventory.getBookCount(), "Duplicate book should not be added.");
    }

    @Test
    public void testRemoveNonExistentBook() {
        inventory.removeBook(999); // Non-existent ID
        assertEquals(2, inventory.getBookCount(), "Removing a non-existent book should not change the count.");
    }

    @Test
    public void testUpdateNonExistentBook() {
        Book updatedBook = new Book("Non-Existent Book", "Unknown Author", 999, 0.0, "Unknown");
        inventory.updateBook(999, updatedBook); // Non-existent ID
        assertNull(inventory.getBookById(999), "Updating a non-existent book should not add it to the inventory.");
    }

    @Test
    public void testGetBookByInvalidId() {
        Book book = inventory.getBookById(999); // Non-existent ID
        assertNull(book, "Getting a book by an invalid ID should return null.");
    }

    @Test
    public void testSearchByInvalidCategory() {
        List<Book> books = inventory.searchByCategory("Unknown Category");
        assertTrue(books.isEmpty(), "Searching by an invalid category should return an empty list.");
    }

    @Test
    public void testAddBookWithNullValues() {
        Book nullBook = new Book(null, null, 3, 0.0, null);
        inventory.addBook(nullBook);
        assertEquals(3, inventory.getBookCount(), "Book with null values should be added.");
        assertNotNull(inventory.getBookById(3), "Book with null values should be retrievable.");
    }
}