package Lab6;

public class Book 
{
	private int bookId;
    private String bookName;
    private String authorName;

    // Parameterized constructor
    public Book(int bookId, String bookName, String authorName) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    // Optional: getters if needed later
    public int getBookId() { return bookId; }
    public String getBookName() { return bookName; }
    public String getAuthorName() { return authorName; }

    // toString to print in the required format
    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", authorName=" + authorName + "]";
    }
}
