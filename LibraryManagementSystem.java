import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date; // Needed for SQL dates
import java.time.LocalDate; // Needed for Date calculations
import java.util.Scanner;

public class LibraryManagementSystem {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LibraryManagementSystem app = new LibraryManagementSystem();
        app.menu();
    }

    // --- 1. DATABASE CONNECTION ---
    public Connection dbConnect() {
        try {
            String url = "jdbc:mysql://localhost:3306/anp2251"; 
            String username = "root";       
            String password = "Rajan@123";  
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
            return null; 
        }
    }

    // --- 2. INPUT VALIDATOR (NEW FEATURE) ---
    // This method forces the user to enter an ID starting with a specific letter (B or S)
    public String getValidId(String type) {
        String input = "";
        String prefix = (type.equals("BOOK")) ? "B" : "S"; 
        
        while (true) {
            System.out.print("Enter " + type + " ID (must start with '" + prefix + "', e.g., " + prefix + "101): ");
            input = sc.nextLine().trim();

            // Check if input is empty
            if (input.isEmpty()) {
                System.out.println("Error: ID cannot be empty.");
                continue;
            }

            // Check if input starts with correct letter (Case insensitive)
            if (!input.toUpperCase().startsWith(prefix)) {
                System.out.println(">> Invalid Format! ID must start with '" + prefix + "'. Please try again.");
            } else {
                return input; // Input is valid, break loop and return it
            }
        }
    }

    // --- 3. MAIN MENU ---
    public void menu() {
        int choice;
        do {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1: View all books");
            System.out.println("2: Add a book");
            System.out.println("3: Delete a book");
            System.out.println("4: Update a book");
            System.out.println("5: Fetch book by ID");
            System.out.println("6: Issue a Book");
            System.out.println("7: Return a Book");
            System.out.println("8: Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1: viewAllBooks(); break;
                case 2: addBook(); break;
                case 3: deleteBook(); break;
                case 4: updateBook(); break;
                case 5: fetchBookById(); break;
                case 6: issueBook(); break;
                case 7: returnBook(); break;
                case 8: System.out.println("Exiting application..."); break;
                default: System.out.println("Invalid choice. Please try again."); break;
            }
        } while (choice != 8);
    }

    // --- 4. INVENTORY MANAGEMENT ---

    public void addBook() {
        String sql = "INSERT INTO books (bookId, title, author, publisher, year, quantity) VALUES (?,?,?,?,?,?)";
        try (Connection con = dbConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) return;

            // Use Validator for Book ID
            String bid = getValidId("BOOK");
            
            System.out.print("Enter Title: ");
            String title = sc.nextLine();
            System.out.print("Enter Author: ");
            String author = sc.nextLine();
            System.out.print("Enter Publisher: ");
            String publisher = sc.nextLine();
            System.out.print("Enter Year: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Stock Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            ps.setString(1, bid);
            ps.setString(2, title);
            ps.setString(3, author);
            ps.setString(4, publisher);
            ps.setInt(5, year);
            ps.setInt(6, qty);

            int count = ps.executeUpdate();
            if (count > 0) System.out.println("Book added successfully!");
            else System.out.println("Failed to add book.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void viewAllBooks() {
        String sql = "SELECT * FROM books";
        try (Connection con = dbConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) return;
            ResultSet rs = ps.executeQuery();
            System.out.println("\n--- Book Inventory ---");
            System.out.printf("%-10s %-20s %-15s %-15s %-6s %-6s\n", "ID", "Title", "Author", "Publisher", "Year", "Stock");
            System.out.println("---------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-15s %-15s %-6d %-6d\n", 
                    rs.getString("bookId"), 
                    rs.getString("title"), 
                    rs.getString("author"), 
                    rs.getString("publisher"),
                    rs.getInt("year"),
                    rs.getInt("quantity"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteBook() {
        String sql = "DELETE FROM books WHERE bookId=?";
        try (Connection con = dbConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) return;
            String bid = getValidId("BOOK"); // Validator
            ps.setString(1, bid);

            int count = ps.executeUpdate();
            if (count > 0) System.out.println("Book deleted successfully!");
            else System.out.println("No book found with that ID.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void updateBook() {
        String sql = "UPDATE books SET title=?, author=?, publisher=?, year=?, quantity=? WHERE bookId=?";
        try (Connection con = dbConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) return;
            String bid = getValidId("BOOK"); // Validator
            
            System.out.print("Enter new Title: ");
            String title = sc.nextLine();
            System.out.print("Enter new Author: ");
            String author = sc.nextLine();
            System.out.print("Enter new Publisher: ");
            String publisher = sc.nextLine();
            System.out.print("Enter new Year: ");
            int year = Integer.parseInt(sc.nextLine());
            System.out.print("Enter new Stock Quantity: ");
            int qty = Integer.parseInt(sc.nextLine());

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, publisher);
            ps.setInt(4, year);
            ps.setInt(5, qty);
            ps.setString(6, bid);

            int count = ps.executeUpdate();
            if (count > 0) System.out.println("Book updated successfully!");
            else System.out.println("No book found with that ID.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void fetchBookById() {
        String sql = "SELECT * FROM books WHERE bookId=?";
        try (Connection con = dbConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            if (con == null) return;
            String bid = getValidId("BOOK"); // Validator
            ps.setString(1, bid);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("\nFound Book:");
                System.out.println("ID: " + rs.getString("bookId"));
                System.out.println("Title: " + rs.getString("title"));
                System.out.println("Author: " + rs.getString("author"));
                System.out.println("Publisher: " + rs.getString("publisher"));
                System.out.println("Stock: " + rs.getInt("quantity"));
            } else {
                System.out.println("No book found with that ID.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --- 5. ISSUE & RETURN (WITH 10-DAY LOGIC) ---

    public void issueBook() {
        System.out.println("\n--- Issue a Book ---");
        
        // Use Validator for Inputs
        String sid = getValidId("STUDENT");
        String bid = getValidId("BOOK");

        Connection con = dbConnect();
        if (con == null) return;

        try {
            // A. Check Stock
            String checkStockSql = "SELECT title, quantity FROM books WHERE bookId=?";
            PreparedStatement psCheck = con.prepareStatement(checkStockSql);
            psCheck.setString(1, bid);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                String title = rs.getString("title");
                int currentQty = rs.getInt("quantity");

                if (currentQty > 0) {
                    // Calculate Dates
                    LocalDate today = LocalDate.now();
                    LocalDate dueDate = today.plusDays(10); // 10 Days Rule

                    // B. Create Issue Record with Due Date
                    String insertSql = "INSERT INTO issue_records (bookId, studentId, issueDate, dueDate, status) VALUES (?, ?, ?, ?, 'ISSUED')";
                    PreparedStatement psIssue = con.prepareStatement(insertSql);
                    psIssue.setString(1, bid);
                    psIssue.setString(2, sid);
                    psIssue.setDate(3, Date.valueOf(today));
                    psIssue.setDate(4, Date.valueOf(dueDate)); // Insert Due Date

                    psIssue.executeUpdate();

                    // C. Decrease Stock
                    String updateStockSql = "UPDATE books SET quantity = quantity - 1 WHERE bookId=?";
                    PreparedStatement psUpdate = con.prepareStatement(updateStockSql);
                    psUpdate.setString(1, bid);
                    psUpdate.executeUpdate();

                    System.out.println("Success! Book '" + title + "' issued to " + sid + ".");
                    System.out.println("Issue Date: " + today);
                    System.out.println("Due Date (Return within 10 days): " + dueDate);
                } else {
                    System.out.println("FAIL: Book '" + title + "' is OUT OF STOCK!");
                }
            } else {
                System.out.println("Error: Invalid Book ID.");
            }
        } catch (Exception e) {
            System.out.println("Error issuing book: " + e.getMessage());
        }
    }

    public void returnBook() {
        System.out.println("\n--- Return a Book ---");
        String sid = getValidId("STUDENT");
        String bid = getValidId("BOOK");

        Connection con = dbConnect();
        if (con == null) return;

        try {
            // Check if issue exists first to get the dates
            String fetchSql = "SELECT issueDate, dueDate FROM issue_records WHERE bookId=? AND studentId=? AND status='ISSUED'";
            PreparedStatement psFetch = con.prepareStatement(fetchSql);
            psFetch.setString(1, bid);
            psFetch.setString(2, sid);
            ResultSet rs = psFetch.executeQuery();

            if (rs.next()) {
                Date issueDate = rs.getDate("issueDate");
                Date dueDate = rs.getDate("dueDate");
                LocalDate returnDate = LocalDate.now();

                // Update to 'RETURNED'
                String updateSql = "UPDATE issue_records SET returnDate = ?, status = 'RETURNED' WHERE bookId = ? AND studentId = ? AND status = 'ISSUED'";
                PreparedStatement psUpdate = con.prepareStatement(updateSql);
                psUpdate.setDate(1, Date.valueOf(returnDate));
                psUpdate.setString(2, bid);
                psUpdate.setString(3, sid);
                psUpdate.executeUpdate();

                // Increase Stock
                String stockSql = "UPDATE books SET quantity = quantity + 1 WHERE bookId=?";
                PreparedStatement psStock = con.prepareStatement(stockSql);
                psStock.setString(1, bid);
                psStock.executeUpdate();

                System.out.println("\nSuccess! Book returned successfully.");
                System.out.println("Issue Date : " + issueDate);
                System.out.println("Due Date   : " + dueDate);
                System.out.println("Returned On: " + returnDate);
                
                // Simple Check if Late
                if (returnDate.isAfter(dueDate.toLocalDate())) {
                    System.out.println(">> NOTICE: Book returned LATE (After 10 days).");
                } else {
                    System.out.println(">> Book returned on time.");
                }

            } else {
                System.out.println("Error: No active record found. (Did this student actually borrow this book?)");
            }

        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }
}