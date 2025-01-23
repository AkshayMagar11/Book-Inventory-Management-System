import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NegativeBookTest {

    @Test
    public void testSetNullTitle() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setTitle(null);
        });
        assertEquals("Title cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetEmptyTitle() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setTitle("");
        });
        assertEquals("Title cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetNullAuthor() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setAuthor(null);
        });
        assertEquals("Author cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetEmptyAuthor() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setAuthor("");
        });
        assertEquals("Author cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetNegativeId() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setId(-1);
        });
        assertEquals("ID must be positive", exception.getMessage());
    }

    @Test
    public void testSetNullPrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("Book Title", "Author Name", 1, null, "Fiction");
        });
        assertEquals("Price must be positive and not Null", exception.getMessage());
    }

    @Test
    public void testConstructorNegativePrice() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Book("Book Title", "Author Name", 1, -29.99, "Fiction");
        });
        assertEquals("Price must be positive and not Null", exception.getMessage());
    }

    @Test
    public void testSetNullCategory() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setCategory(null);
        });
        assertEquals("Category cannot be null or empty.", exception.getMessage());
    }

    @Test
    public void testSetEmptyCategory() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            book.setCategory("");
        });
        assertEquals("Category cannot be null or empty.", exception.getMessage());
    }
}