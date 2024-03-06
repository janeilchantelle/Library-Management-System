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
        String isbn = input.substring(input.indexOf(" ") + 1).trim();
        library.removeBook(isbn);
        System.out.println("Book with ISBN " + isbn + " removed from the library.");
    }

    private void addAuthor(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length >= 4) {
            String name = tokens[1];
            String dateOfBirth = tokens[2];
            Author author = new Author(name, dateOfBirth);
            library.addAuthor(author);
            System.out.println("Author added successfully.");
        } else {
            System.out.println("Invalid addauthor command. Format: addauthor <name> <date_of_birth>");
        }
    }

    private void editAuthor(String[] tokens) {
        if (tokens.length >= 4) {
            String oldName = tokens[1];
            String newName = tokens[2];
            String newDateOfBirth = tokens[3];
            Author oldAuthor = new Author(oldName, ""); // Modify this depending on the Author class
            Author newAuthor = new Author(newName, newDateOfBirth);
            library.editAuthor(oldAuthor, newAuthor);
            System.out.println("Author edited successfully.");
        } else {
            System.out.println("Invalid editauthor command. Format: editauthor <old_name> <new_name> <new_date_of_birth>");
        }
    }

    private void removeAuthor(String input) {
        String name = input.substring(input.indexOf(" ") + 1).trim();
        library.removeAuthor(name);
        System.out.println("Author " + name + " removed from the library.");
    }

    private void addPatron(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length >= 5) {
            String name = tokens[1];
            String address = tokens[2];
            String phoneNumber = tokens[3];
            Patron patron = new Patron(name, address, phoneNumber);
            library.addPatron(patron);
            System.out.println("Patron added successfully.");
        } else {
            System.out.println("Invalid addpatron command. Format: addpatron <name> <address> <phone_number>");
        }
    }

    

    private void editPatron(String[] tokens) {
        if (tokens.length >= 5) {
            String oldName = tokens[1];
            String newName = tokens[2];
            String newAddress = tokens[3];
            String newPhoneNumber = tokens[4];
            Patron oldPatron = new Patron(oldName, "", ""); // Modify this depending on the Patron class
            Patron newPatron = new Patron(newName, newAddress, newPhoneNumber);
            library.editPatron(oldPatron, newPatron);
            System.out.println("Patron edited successfully.");
        } else {
            System.out.println("Invalid editpatron command. Format: editpatron <old_name> <new_name> <new_address> <new_phone_number>");
        }
    }

    private void removePatron(String input) {
        String name = input.substring(input.indexOf(" ") + 1).trim();
        library.removePatron(name);
        System.out.println("Patron " + name + " removed from the library.");
    }

    private void displayHelp() {
        // Display help commands
    }

    private void searchByTitle(String title) {
        // Implement search by title
    }

    private void searchByAuthor(String authorName) {
        // Implement search by author
    }

    private void searchByISBN(String isbn) {
        // Implement search by ISBN
    }

    private void borrowBook(String isbn, String patronId, int numCopies) {
        // Implement borrowing a book
    }

    private void returnBook(String isbn, String patronId, int numCopies) {
        // Implement returning a book
    }

    private void addBook(String input) {
        // Implement adding a book
    }

    private void editBook(String[] tokens) {
        // Implement editing a book
    }
}
