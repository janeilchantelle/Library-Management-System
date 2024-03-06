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
        Author author3 = new Author("Wayne Johnston", "May 22, 1958");
        Author author4 = new Author("Joel Thomas Hynes", "April 1976");
        Author author5 = new Author("Michael Winter", "1965");
        Author author6 = new Author("Bernice Morgan", "1935");
        Author author7 = new Author("Kevin Major", "September 12, 1949");
        Author author8 = new Author("Ed Riche", "1958");
        Author author9 = new Author("Kenneth J. Harvey", "1962");
        Author author10 = new Author("Jessica Grant", "1976");

        // Add authors to the list of authors
        authors.add(author1);
        authors.add(author2);
        authors.add(author3);
        authors.add(author4);
        authors.add(author5);
        authors.add(author6);
        authors.add(author7);
        authors.add(author8);
        authors.add(author9);
        authors.add(author10);

        // Create books
        Book book1 = new Book("February", author1, "978-1550813370", "Breakwater Books", 5);
        Book book2 = new Book("The Innocents", author2, "978-0385660445", "Doubleday Canada", 8);
        Book book3 = new Book("The Colony of Unrequited Dreams", author3, "978-0394281702", "Knopf Canada", 10);
        Book book4 = new Book("Down to the Dirt", author4, "978-0143013136", "Penguin Canada", 3);
        Book book5 = new Book("The Big Why", author5, "978-0670063831", "Viking Canada", 6);
        Book book6 = new Book("Random Passage", author6, "978-0771029789", "Breakwater Books", 7);
        Book book7 = new Book("New Under the Sun", author7, "978-1550810430", "Breakwater Books", 4);
        Book book8 = new Book("Rare Birds", author8, "978-0143051299", "Penguin Canada", 9);
        Book book9 = new Book("Inside", author9, "978-0670887314", "Viking Canada", 2);
        Book book10 = new Book("Come, Thou Tortoise", author10, "978-0307356149", "Knopf Canada", 5);

        // Add books to the list of books
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);

        // Create patrons
        Patron patron1 = new Patron("Alice Johnson", "123 Main St", "555-123-4567");
        Patron patron2 = new Patron("Bob Smith", "456 Elm St", "555-987-6543");
        Patron patron3 = new Patron("Charlie Brown", "789 Maple St", "555-222-3333");
        Patron patron4 = new Patron("Daisy Johnson", "321 Oak St", "555-444-5555");
        Patron patron5 = new Patron("Eva Martinez", "654 Pine St", "555-666-7777");
        Patron patron6 = new Patron("Franklin Williams", "987 Cedar St", "555-888-9999");
        Patron patron7 = new Patron("Grace Taylor", "135 Walnut St", "555-000-1111");
        Patron patron8 = new Patron("Henry Clark", "246 Birch St", "555-222-3333");
        Patron patron9 = new Patron("Ivy Lee", "357 Spruce St", "555-444-5555");
        Patron patron10 = new Patron("Jack Thompson", "468 Sycamore St", "555-666-7777");

        // Add patrons to the list of patrons
        patrons.add(patron1);
        patrons.add(patron2);
        patrons.add(patron3);
        patrons.add(patron4);
        patrons.add(patron5);
        patrons.add(patron6);
        patrons.add(patron7);
        patrons.add(patron8);
        patrons.add(patron9);
        patrons.add(patron10);

        // Instantiate the Library object with the initialized lists
        Library library = new Library(books, authors, patrons);

        // Instantiate the LibraryCLI object and start the CLI
        LibraryCLI cli = new LibraryCLI(library);
        cli.start();
    }
}
