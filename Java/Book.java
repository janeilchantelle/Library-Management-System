import java.util.ArrayList;
import java.util.List;

public class Book implements Borrowable {
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int numberOfCopies;
    private int copiesCheckedOut;

    // Enum representing the status of a book
    public enum Status {
        AVAILABLE,
        CHECKED_OUT,
        OVERDUE
    }

    private Status bookStatus;

    // Constructor
    public Book(String title, Author author, String ISBN, String publisher, int numberOfCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numberOfCopies = numberOfCopies;
        this.copiesCheckedOut = 0;
        this.bookStatus = Status.AVAILABLE;
    }

    // Getter and setter methods
    // Add here...

    // Method to borrow a book
    @Override
    public void borrow(int numCopiesToBorrow) {
        if (bookStatus == Status.AVAILABLE && numCopiesToBorrow <= numberOfCopies - copiesCheckedOut) {
            copiesCheckedOut += numCopiesToBorrow;
            bookStatus = Status.CHECKED_OUT;
            System.out.println(numCopiesToBorrow + " copies of \"" + title + "\" checked out successfully.");
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    // Method to return a book
    @Override
    public void returnBook(int numCopiesToReturn) {
        if (copiesCheckedOut >= numCopiesToReturn) {
            copiesCheckedOut -= numCopiesToReturn;
            if (copiesCheckedOut == 0) {
                bookStatus = Status.AVAILABLE;
            }
            
            System.out.println(numCopiesToReturn + " copies of \"" + title + "\" returned successfully.");
        } else {
            System.out.println("Invalid number of copies to return.");
        }
    }
}
