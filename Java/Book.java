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

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public int getCopiesCheckedOut() {
        return copiesCheckedOut;
    }

    public void setCopiesCheckedOut(int copiesCheckedOut) {
        this.copiesCheckedOut = copiesCheckedOut;
    }

    // Implement methods from Borrowable interface
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
