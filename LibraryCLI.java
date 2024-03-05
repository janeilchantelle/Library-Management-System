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
                case "addbook":
                    addBook(input);
                    break;
                case "editbook":
                    editBook(tokens); // Pass tokens array
                    break;
                case "removebook":
                    removeBook(input);
                    break;
                case "addauthor":
                    addAuthor(input);
                    break;
                case "editauthor":
                    editAuthor(tokens); // Pass tokens array
                    break;
                case "removeauthor":
                    removeAuthor(input);
                    break;
                case "addpatron":
                    addPatron(input);
                    break;
                case "editpatron":
                    editPatron(tokens); // Pass tokens array
                    break;
                case "removepatron":
                    removePatron(input);
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
        System.out.println("- addbook <title> <author> <isbn> <publisher> <num_copies>: Add a book to the library");
        System.out.println("- editbook <old_isbn> <new_title> <new_author> <new_publisher> <new_num_copies>: Edit a book");
        System.out.println("- removebook <isbn>: Remove a book from the library");
        System.out.println("- addauthor <name> <date_of_birth>: Add an author to the library");
        System.out.println("- editauthor <old_name> <new_name> <new_date_of_birth>: Edit an author");
        System.out.println("- removeauthor <name>: Remove an author from the library");
        System.out.println("- addpatron <name> <address> <phone_number>: Add a patron to the library");
        System.out.println("- editpatron <old_name> <new_name> <new_address> <new_phone_number>: Edit a patron");
        System.out.println("- removepatron <name>: Remove a patron from the library");
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

    // Implement methods for adding, editing, and removing books, authors, and patrons
    private void addBook(String input) {
        // Parse input and call library.addBook() method
    }

    private void editBook(String[] tokens) {
        if (tokens.length == 7) { // Ensure correct number of arguments
            String oldIsbn = tokens[1];
            String newTitle = tokens[2];
            String newAuthor = tokens[3];
            String newPublisher = tokens[4];
            int newNumCopies = Integer.parseInt(tokens[5]);
            Book newBook = new Book(newTitle, new Author(newAuthor, ""), oldIsbn, newPublisher, newNumCopies);
            library.editBook(oldIsbn, newBook); // Call editBook method with appropriate arguments
        } else {
            System.out.println("Invalid editbook command. Format: editbook <old_isbn> <new_title> <new_author> <new_publisher> <new_num_copies>");
        }
    }
    

    private void removeBook(String input) {
        // Parse input and call library.removeBook() method
    }

    private void addAuthor(String input) {
        // Parse input and call library.addAuthor() method
    }

    private void editAuthor(String[] tokens) {
        // Parse input and call library.editAuthor() method
    }

    private void removeAuthor(String input) {
        // Parse input and call library.removeAuthor() method
    }

    private void addPatron(String input) {
        // Parse input and call library.addPatron() method
    }

    private void editPatron(String[] tokens) {
        // Parse input and call library.editPatron() method
    }

    private void removePatron(String input) {
        // Parse input and call library.removePatron() method
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
