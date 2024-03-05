import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private String dateOfBirth;
    private List<Book> booksWritten;

    // Constructor
    public Author(String name, String dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = new ArrayList<>();
    }

    // Method to add a book written by the author
    public void addBook(Book book) {
        booksWritten.add(book);
    }

    // Getter and setter methods
    // Add here...
}
