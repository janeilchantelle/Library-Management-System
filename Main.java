import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create lists to hold books, authors, and patrons
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Patron> patrons = new ArrayList<>();

        // Create authors
        Author author1 = new Author("Lisa Moore", "February 13, 1964");
        Author author2 = new Author("Michael Crummey", "November 18, 1965");
        // Add other authors similarly

        // Add authors to the list of authors
        authors.add(author1);
        authors.add(author2);
        // Add other authors similarly

        // Create books
        Book book1 = new Book("February", author1, "978-1550813370", "Breakwater Books", 5);
        Book book2 = new Book("The Innocents", author2, "978-0385660445", "Doubleday Canada", 8);
        // Add other books similarly

        // Add books to the list of books
        books.add(book1);
        books.add(book2);
        // Add other books similarly

        // Create patrons
        // Add patrons similarly

        // Add patrons to the list of patrons
        // Add patrons similarly

        // Instantiate the Library object with the initialized lists
        Library library = new Library(books, authors, patrons);

        // Instantiate the LibraryCLI object and start the CLI
        LibraryCLI cli = new LibraryCLI(library);
        cli.start();
    }
}
