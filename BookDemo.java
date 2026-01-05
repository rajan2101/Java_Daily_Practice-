package Lab6;

import java.util.ArrayList;


public class BookDemo 
{
	public static void main(String[] args) {
        // Create the collection
        ArrayList<Book> books = new ArrayList<>();

        // Add Book objects
        books.add(new Book(101, "let us c", "Yashavant P Kanetkar"));
        books.add(new Book(102, "head first java", "Kathy Sierra"));

        // Display all books
        System.out.println("--All Books--");
        for (Book b : books) {
            System.out.println(b); // uses Book.toString()
        }
    }
}
