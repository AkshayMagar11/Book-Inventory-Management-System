import org.example.Book;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    public void testBookCreation() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        assertEquals("Book Title", book.getTitle());
        assertEquals("Author Name", book.getAuthor());
        assertEquals(1, book.getId());
        assertEquals(29.99, book.getPrice());
        assertEquals("Fiction", book.getCategory());
    }

    @Test
    public void testSetTitle() {
        Book book = new Book("Old Title", "Author Name", 1, 29.99, "Fiction");
        book.setTitle("New Title");
        assertEquals("New Title", book.getTitle());
    }

    @Test
    public void testSetAuthor() {
        Book book = new Book("Book Title", "Old Author", 1, 29.99, "Fiction");
        book.setAuthor("New Author");
        assertEquals("New Author", book.getAuthor());
    }

    @Test
    public void testSetId() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setId(2);
        assertEquals(2, book.getId());
    }

    @Test
    public void testSetPrice() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setPrice(39.99);
        assertEquals(39.99, book.getPrice());
    }

    @Test
    public void testSetCategory() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        book.setCategory("Non-Fiction");
        assertEquals("Non-Fiction", book.getCategory());
    }

    @Test
    public void testToString() {
        Book book = new Book("Book Title", "Author Name", 1, 29.99, "Fiction");
        String expected = "[title=Book Title, author=Author Name, id=1, price=29.99, category=Fiction]";
        assertEquals(expected, book.toString());
    }
}