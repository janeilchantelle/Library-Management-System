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
                    System.out.println("Your session has now ended. See you again soon!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command. Type 'help' to see available commands.");
            }
        }

        scanner.close();
    }

    private void removeBook(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeBook'");
    }

    private void addAuthor(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addAuthor'");
    }

    private void editAuthor(String[] tokens) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editAuthor'");
    }

    private void removeAuthor(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeAuthor'");
    }

    private void addPatron(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addPatron'");
    }

    private void editPatron(String[] tokens) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editPatron'");
    }

    private void removePatron(String input) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removePatron'");
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
        List<Book> books = library.searchBooksByAuthor(authorName);
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

    private void addBook(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length >= 7) {
            String title = tokens[1];
            String authorName = tokens[2];
            String isbn = tokens[3];
            String publisher = tokens[4];
            int numCopies = Integer.parseInt(tokens[5]);
            Author author = new Author(authorName, ""); // You might need to modify this depending on the Author class
            Book book = new Book(title, author, isbn, publisher, numCopies);
            library.addBook(book);
            System.out.println("Book added successfully.");
        } else {
            System.out.println("Invalid addbook command. Format: addbook <title> <author> <isbn> <publisher> <num_copies>");
        }
    }

    // Implement methods for editBook, removeBook, addAuthor, editAuthor, removeAuthor, addPatron, editPatron, and removePatron

    // Example method signature for editBook
    private void editBook(String[] tokens) {
        // Your implementation here
    }
}
