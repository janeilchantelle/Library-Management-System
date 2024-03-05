public class Book {
    private String title;
    private Author author;
    private String ISBN;
    private String publisher;
    private int numCopies;
    private int numCopiesBorrowed;

    // Constructor
    public Book(String title, Author author, String ISBN, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.publisher = publisher;
        this.numCopies = numCopies;
        this.numCopiesBorrowed = 0;
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

    public int getNumCopies() {
        return numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public int getNumCopiesBorrowed() {
        return numCopiesBorrowed;
    }

    // Method to borrow copies of the book
    public void borrow(int numCopiesToBorrow) {
        if (numCopiesBorrowed + numCopiesToBorrow <= numCopies) {
            numCopiesBorrowed += numCopiesToBorrow;
        } else {
            System.out.println("Not enough copies available to borrow.");
        }
    }

    // Method to return copies of the book
    public void returnBook(int numCopiesToReturn) {
        if (numCopiesBorrowed >= numCopiesToReturn) {
            numCopiesBorrowed -= numCopiesToReturn;
        } else {
            System.out.println("Invalid number of copies to return.");
        }
    }

    // Method to get the number of copies available for borrowing
    public int getNumCopiesAvailable() {
        return numCopies - numCopiesBorrowed;
    }
}
