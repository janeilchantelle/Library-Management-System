import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryCLI {
    private Library library;
    private Scanner scanner;

    public LibraryCLI(Library library) {
        this.library = library;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to the Library Management System!");
        System.out.println("Type 'help' to see available commands.");

        boolean running = true;
        while (running) {
            System.out.print("\nEnter a command: ");
            String input = scanner.nextLine();
            String[] tokens = input.split(" ");

            switch (tokens[0].toLowerCase()) {
                case "help":
                    displayHelp();
                    break;
                case "search":
                    if (tokens.length >= 3 && tokens[1].equalsIgnoreCase("title")) {
                        searchByTitle(tokens[2]);
                    } else if (tokens.length >= 3 && tokens[1].equalsIgnoreCase("author")) {
                        searchByAuthor(tokens[2]);
                    } else if (tokens.length >= 3 && tokens[1].equalsIgnoreCase("isbn")) {
                        searchByISBN(tokens[2]);
                    } else {
                        System.out.println("Invalid search command.");
                    }
                    break;
                case "borrow":
                    if (tokens.length >= 4) {
                        borrowBook(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    } else {
                        System.out.println("Invalid borrow command. Format: borrow <isbn> <patron_id> <num_copies>");
                    }
                    break;
                case "return":
                    if (tokens.length >= 4) {
                        returnBook(tokens[1], tokens[2], Integer.parseInt(tokens[3]));
                    } else {
                        System.out.println("Invalid return command. Format: return <isbn> <patron_id> <num_copies>");
                    }
                    break;
                case "exit":
                    System.out.println("Exiting Library Management System.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' to see available commands.");
            }
        }

        scanner.close();
    }

    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("- help: Display available commands");
        System.out.println("- search title <title>: Search for books by title");
        System.out.println("- search author <author>: Search for books by author");
        System.out.println("- search isbn <isbn>: Search for books by ISBN");
        System.out.println("- borrow <isbn> <patron_id> <num_copies>: Borrow a book");
        System.out.println("- return <isbn> <patron_id> <num_copies>: Return a book");
        System.out.println("- exit: Exit the Library Management System");
    }

    private void searchByTitle(String title) {
        System.out.println("Books found by title:");
        List<Book> books = library.searchBooksByTitle(title);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(book -> System.out.println(book.getTitle()));
        }
    }

    private void searchByAuthor(String authorName) {
        System.out.println("Books found by author:");
        Author author = new Author(authorName, ""); // Create a temporary author object with name only
        List<Book> books = library.searchBooksByAuthor(author);
        if (books.isEmpty()) {
            System.out.println("No books found.");
        } else {
            books.forEach(book -> System.out.println(book.getTitle()));
        }
    }

    private void searchByISBN(String isbn) {
        Book book = library.searchBooksByISBN(isbn);
        if (book != null) {
            System.out.println("Book found by ISBN: " + book.getTitle());
        } else {
            System.out.println("Book not found by ISBN.");
        }
    }

    private void borrowBook(String isbn, String patronId, int numCopies) {
        Patron patron = library.findPatronById(patronId);
        if (patron != null) {
            Book book = library.searchBooksByISBN(isbn);
            if (book != null) {
                String message = library.borrowBook(patron, book, numCopies);
                System.out.println(message);
            } else {
                System.out.println("Book not found by ISBN.");
            }
        } else {
            System.out.println("Patron not found.");
        }
    }

    private void returnBook(String isbn, String patronId, int numCopies) {
        Patron patron = library.findPatronById(patronId);
        if (patron != null) {
            Book book = library.searchBooksByISBN(isbn);
            if (book != null) {
                String message = library.returnBook(patron, book, numCopies);
                System.out.println(message);
            } else {
                System.out.println("Book not found by ISBN.");
            }
        } else {
            System.out.println("Patron not found.");
        }
    }

    public static void main(String[] args) {
        // Create lists to hold books, authors, and patrons
        List<Book> books = new ArrayList<>();
        List<Author> authors = new ArrayList<>();
        List<Patron> patrons = new ArrayList<>();

        // Add authors, books, and patrons as needed

        // Instantiate the Library object
        Library library = new Library(books, authors, patrons);

        // Instantiate the LibraryCLI object and start the CLI
        LibraryCLI cli = new LibraryCLI(library);
        cli.start();
    }
}
