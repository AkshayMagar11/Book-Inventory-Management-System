import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NegativeBookTest {

    @Test
    public void testSetNullTitle() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setTitle(null);
        assertNull(book.getTitle(), "Title should be null.");
    }

    @Test
    public void testSetEmptyTitle() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setTitle("");
        assertEquals("", book.getTitle(), "Title should be empty.");
    }

    @Test
    public void testSetNullAuthor() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setAuthor(null);
        assertNull(book.getAuthor(), "Author should be null.");
    }

    @Test
    public void testSetEmptyAuthor() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setAuthor("");
        assertEquals("", book.getAuthor(), "Author should be empty.");
    }

    @Test
    public void testSetNegativeId() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setId(-1);
        });
        assertEquals("ID must be positive.", exception.getMessage());
    }
    @Test
    public void testSetNullPrice() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setPrice(null);
        assertNull(book.getPrice(), "Price should be null.");
    }

    @Test
    public void testConstructorNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("Book Title", "Author Name", 1, -29.99, "Fiction");
        });
        assertEquals("Price must be positive.", exception.getMessage());
    }

    @Test
    public void testSetNullCategory() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setCategory(null);
        assertNull(book.getCategory(), "Category should be null.");
    }

    @Test
    public void testSetEmptyCategory() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setCategory("");
        assertEquals("", book.getCategory(), "Category should be empty.");
    }
}