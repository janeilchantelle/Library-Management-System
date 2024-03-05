import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create lists to hold books, authors, and patrons
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Patron> patrons = new ArrayList<>();

        // Create some authors
        Author author1 = new Author("John Doe", "01-01-1970");
        Author author2 = new Author("Jane Smith", "02-02-1980");

        // Add authors to the list of authors
        authors.add(author1);
        authors.add(author2);

        // Create some books
        Book book1 = new Book("Book 1", author1, "1234567890", "Publisher A", 10);
        Book book2 = new Book("Book 2", author2, "0987654321", "Publisher B", 5);

        // Add books to the list of books
        books.add(book1);
        books.add(book2);

        // Create some patrons
        Patron patron1 = new Patron("Patron 1", "Address 1", "123-456-7890");
        Patron patron2 = new Patron("Patron 2", "Address 2", "987-654-3210");

        // Add patrons to the list of patrons
        patrons.add(patron1);
        patrons.add(patron2);

        // Instantiate the Library object
        Library library = new Library(books, authors, patrons);

        // Search for books by title
        List<Book> searchResults = library.searchBooksByTitle("Book 1");
        System.out.println("Books found by title:");
        for (Book book : searchResults) {
            System.out.println(book.getTitle());
        }

        // Search for books by author
        searchResults = library.searchBooksByAuthor(author2);
        System.out.println("\nBooks found by author:");
        for (Book book : searchResults) {
            System.out.println(book.getTitle());
        }

        // Search for books by ISBN
        Book foundBook = library.searchBooksByISBN("0987654321");
        if (foundBook != null) {
            System.out.println("\nBook found by ISBN: " + foundBook.getTitle());
        } else {
            System.out.println("\nBook not found by ISBN.");
        }

        // Borrow a book
        library.borrowBook(patron1, book1, 1);

        // Return a book
        library.returnBook(patron1, book1, 1);
    }
}
