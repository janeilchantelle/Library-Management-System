public class Book implements Borrowable {
    private String title;
    private Author author;
    private String isbn;
    private String publisher;
    private int numCopies;
    private Status status;

    public Book(String title, Author author, String isbn, String publisher, int numCopies) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numCopies = numCopies;
        this.status = Status.AVAILABLE;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getNumCopies() {
        return numCopies;
    }

    public Status getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public void borrow(int numCopiesToBorrow) {
        if (numCopies >= numCopiesToBorrow) {
            numCopies -= numCopiesToBorrow;
            setStatus(Status.CHECKED_OUT);
            System.out.println(numCopiesToBorrow + " copy/copies of \"" + getTitle() + "\" successfully borrowed.");
        } else {
            System.out.println("Not enough copies available to borrow.");
        }
    }

    @Override
    public void returnBook(int numCopiesToReturn) {
        numCopies += numCopiesToReturn;
        setStatus(Status.AVAILABLE);
        System.out.println(numCopiesToReturn + " copy/copies of \"" + getTitle() + "\" successfully returned.");
    }

    public enum Status {
        AVAILABLE,
        CHECKED_OUT,
        OVERDUE
    }
    
}
