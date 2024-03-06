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

    // Method to edit an existing book
    public void editBook(String oldIsbn, Book newBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getISBN().equals(oldIsbn)) {
                books.set(i, newBook);
                return;
            }
        }
        System.out.println("Book with ISBN " + oldIsbn + " not found.");
    }

    // Method to remove a book from the library
    public void removeBook(String isbn) {
        books.removeIf(book -> book.getISBN().equals(isbn));
    }

    // Method to add a new author to the library
    public void addAuthor(Author author) {
        authors.add(author);
    }

    // Method to edit an existing author
    public void editAuthor(Author oldAuthor, Author newAuthor) {
        authors.remove(oldAuthor);
        authors.add(newAuthor);
    }

    // Method to remove an author from the library
    public void removeAuthor(String name) {
        authors.removeIf(author -> author.getName().equals(name));
    }

    // Method to add a new patron to the library
    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    // Method to edit an existing patron
    public void editPatron(Patron oldPatron, Patron newPatron) {
        patrons.remove(oldPatron);
        patrons.add(newPatron);
    }

    // Method to remove a patron from the library
    public void removePatron(String name) {
        patrons.removeIf(patron -> patron.getName().equals(name));
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

    public List<Book> searchBooksByAuthor(String authorName) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().getName().trim().equalsIgnoreCase(authorName.trim())) {
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
    public String borrowBook(Patron patron, Book book, int numCopiesToBorrow) {
        if (book.getNumCopiesAvailable() >= numCopiesToBorrow) {
            book.borrow(numCopiesToBorrow);
            return "Book(s) successfully borrowed by patron " + patron.getName();
        } else {
            return "Book not available for borrowing.";
        }
    }

    // Method to allow a patron to return a book
    public String returnBook(Patron patron, Book book, int numCopiesToReturn) {
        book.returnBook(numCopiesToReturn);
        return "Book(s) successfully returned by patron " + patron.getName();
    }

    // Method to find a patron by ID
    public Patron findPatronById(String patronId) {
        for (Patron patron : patrons) {
            if (patron.getId().equals(patronId)) {
                return patron;
            }
        }
        return null;
    }
}
