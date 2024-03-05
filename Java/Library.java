import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<Author> authors;
    private List<Patron> patrons;

    // Constructor
    public Library(List<Book> books, List<Author> authors, List<Patron> patrons) {
        this.books = books;
        this.authors = authors;
        this.patrons = patrons;
    }

    // Method to add a new book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
    }

    // Method to add a new author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to remove an author from the library
    public void removeAuthor(Author author) {
        authors.remove(author);
    }

    // Method to add a new patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to remove a patron from the library
    public void removePatron(Patron patron) {
        patrons.remove(patron);
    }

    // Method to search for books by title
    public List<Book> searchBooksByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for books by author
    public List<Book> searchBooksByAuthor(Author author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                result.add(book);
            }
        }
        return result;
    }

    // Method to search for books by ISBN
    public Book searchBooksByISBN(String ISBN) {
        for (Book book : books) {
            if (book.getISBN().equalsIgnoreCase(ISBN)) {
                return book;
            }
        }
        return null;
    }

    // Method to allow a patron to borrow a book
    public void borrowBook(Patron patron, Book book, int numCopiesToBorrow) {
        book.borrow(numCopiesToBorrow);
        patron.borrowBook(book);
    }

    // Method to allow a patron to return a book
    public void returnBook(Patron patron, Book book, int numCopiesToReturn) {
        book.returnBook(numCopiesToReturn);
        patron.returnBook(book);
    }
}
