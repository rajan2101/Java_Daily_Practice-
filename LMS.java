import java.sql.*;
import java.time.LocalDate;
import java.util.Scanner;

public class LMS {
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        LMS app = new LMS();
        app.mainMenu();
    }

    // --- DATABASE CONNECTION ---
    public Connection dbConnect() {
        try {
            // Update your DB Name and Password here
            String url = "jdbc:mysql://localhost:3306/LMS"; 
            String username = "root";        
            String password = "Rajan@123"; 
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
            return null; 
        }
    }

    // --- INPUT VALIDATOR ---
    public String getValidId(String type) {
        String prefix = "";
        if (type.equals("PUBLISHER")) prefix = "P";
        else if (type.equals("MEMBER")) prefix = "M";
        else if (type.equals("BOOK")) prefix = "B";

        while (true) {
            System.out.print("Enter " + type + " ID (Start with '" + prefix + "'): ");
            String input = sc.nextLine().trim();
            if (input.toUpperCase().startsWith(prefix)) return input;
            System.out.println(">> Invalid ID format. Must start with '" + prefix + "'.");
        }
    }

    // --- MAIN MENU ---
    public void mainMenu() {
        while (true) {
            System.out.println("\n=== Library System ===");
            System.out.println("1. Publisher Management");
            System.out.println("2. Member Management");
            System.out.println("3. Book Management");
            System.out.println("4. Issue Book (Borrowed By)");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            String ch = sc.nextLine();

            switch (ch) {
                case "1": publisherMenu(); break;
                case "2": memberMenu(); break;
                case "3": bookMenu(); break;
                case "4": issueBook(); break;
                case "5": returnBook(); break;
                case "6": System.exit(0);
                default: System.out.println("Invalid Choice");
            }
        }
    }

    // --- 1. PUBLISHER (Maps to Publisher Entity) ---
    public void publisherMenu() {
        System.out.println("\n--- Publisher Menu ---");
        System.out.println("1. Add Publisher");
        System.out.println("2. View Publishers");
        System.out.println("3. Delete Publisher"); // NEW OPTION
        System.out.print("Choice: ");
        String ch = sc.nextLine();

        if (ch.equals("1")) {
            // ADD
            try (Connection con = dbConnect()) {
                String pid = getValidId("PUBLISHER");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Address: ");
                String address = sc.nextLine();

                String sql = "INSERT INTO publisher (pub_id, name, address) VALUES (?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, pid); ps.setString(2, name); ps.setString(3, address);
                ps.executeUpdate();
                System.out.println("Publisher Added!");
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        
        } else if (ch.equals("2")) {
            // VIEW
            printTable("SELECT * FROM publisher", "pub_id", "name", "address");
        
        } else if (ch.equals("3")) {
            // DELETE
            try (Connection con = dbConnect()) {
                String pid = getValidId("PUBLISHER");
                String sql = "DELETE FROM publisher WHERE pub_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, pid);
                int rows = ps.executeUpdate();
                
                if (rows > 0) System.out.println("Publisher Deleted Successfully.");
                else System.out.println("Error: Publisher ID not found.");
                
            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Error: Cannot delete Publisher because they have Books registered in the system.");
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }

    // --- 2. MEMBER (Maps to Member Entity) ---
    public void memberMenu() {
        System.out.println("\n--- Member Menu ---");
        System.out.println("1. Add Member");
        System.out.println("2. View Members");
        System.out.println("3. Delete Member"); // NEW OPTION
        System.out.print("Choice: ");
        String ch = sc.nextLine();

        if (ch.equals("1")) {
            // ADD
            try (Connection con = dbConnect()) {
                String mid = getValidId("MEMBER");
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Address: ");
                String address = sc.nextLine();
                System.out.print("Enter Type (Student/Staff): ");
                String type = sc.nextLine();

                LocalDate joinDate = LocalDate.now();
                LocalDate expiryDate = joinDate.plusYears(1); 

                String sql = "INSERT INTO member (member_id, name, address, member_type, member_date, expiry_date) VALUES (?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, mid); ps.setString(2, name); ps.setString(3, address);
                ps.setString(4, type);
                ps.setDate(5, Date.valueOf(joinDate));
                ps.setDate(6, Date.valueOf(expiryDate));
                ps.executeUpdate();
                System.out.println("Member Added! Expiry Date set to: " + expiryDate);
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        
        } else if (ch.equals("2")) {
            // VIEW
            printTable("SELECT * FROM member", "member_id", "name", "expiry_date");
        
        } else if (ch.equals("3")) {
            // DELETE
            try (Connection con = dbConnect()) {
                String mid = getValidId("MEMBER");
                String sql = "DELETE FROM member WHERE member_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, mid);
                int rows = ps.executeUpdate();

                if (rows > 0) System.out.println("Member Deleted Successfully.");
                else System.out.println("Error: Member ID not found.");

            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Error: Cannot delete Member. They have transaction records (borrowed books).");
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }

    // --- 3. BOOKS (Maps to Books Entity + 'Published by' Relation) ---
    public void bookMenu() {
        System.out.println("\n--- Book Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. View Books");
        System.out.println("3. Delete Book"); // NEW OPTION
        System.out.print("Choice: ");
        String ch = sc.nextLine();

        if (ch.equals("1")) {
            // ADD
            try (Connection con = dbConnect()) {
                String bid = getValidId("BOOK");
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                System.out.print("Enter Author: ");
                String author = sc.nextLine();
                System.out.print("Enter Price: ");
                double price = Double.parseDouble(sc.nextLine());

                System.out.println("--- Select Publisher ---");
                printTable("SELECT * FROM publisher", "pub_id", "name", "address");
                String pid = getValidId("PUBLISHER");

                String sql = "INSERT INTO books (book_id, title, author, price, available, pub_id) VALUES (?,?,?,?,'YES',?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, bid); ps.setString(2, title); ps.setString(3, author);
                ps.setDouble(4, price); ps.setString(5, pid);
                ps.executeUpdate();
                System.out.println("Book Added Successfully!");
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        
        } else if (ch.equals("2")) {
            // VIEW
            printTable("SELECT * FROM books", "book_id", "title", "available");
        
        } else if (ch.equals("3")) {
            // DELETE
            try (Connection con = dbConnect()) {
                String bid = getValidId("BOOK");
                String sql = "DELETE FROM books WHERE book_id=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, bid);
                int rows = ps.executeUpdate();

                if (rows > 0) System.out.println("Book Deleted Successfully.");
                else System.out.println("Error: Book ID not found.");

            } catch (SQLIntegrityConstraintViolationException e) {
                System.out.println("Error: Cannot delete Book. It is referenced in issue records (borrowed_by table).");
            } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
        }
    }

    // --- 4. ISSUE (Maps to 'Borrowed by' Diamond) ---
    public void issueBook() {
        try (Connection con = dbConnect()) {
            System.out.println("\n--- Issue Book (Borrowed By) ---");
            String mid = getValidId("MEMBER");
            String bid = getValidId("BOOK");

            // 1. Check Availability
            String checkSql = "SELECT available FROM books WHERE book_id=?";
            PreparedStatement psCheck = con.prepareStatement(checkSql);
            psCheck.setString(1, bid);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                if ("YES".equalsIgnoreCase(rs.getString("available"))) {
                    // 2. Create 'Borrowed By' Record
                    LocalDate issueDate = LocalDate.now();
                    LocalDate dueDate = issueDate.plusDays(14); // 2 Weeks due

                    String sql = "INSERT INTO borrowed_by (book_id, member_id, issue_date, due_date) VALUES (?,?,?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    ps.setString(1, bid); ps.setString(2, mid);
                    ps.setDate(3, Date.valueOf(issueDate));
                    ps.setDate(4, Date.valueOf(dueDate));
                    ps.executeUpdate();

                    // 3. Update Book Status
                    PreparedStatement psUpdate = con.prepareStatement("UPDATE books SET available='NO' WHERE book_id=?");
                    psUpdate.setString(1, bid);
                    psUpdate.executeUpdate();

                    System.out.println("Book Issued! Due Date: " + dueDate);
                } else {
                    System.out.println("Error: Book is already borrowed.");
                }
            } else {
                System.out.println("Error: Book ID not found.");
            }
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // --- 5. RETURN (Updates 'Borrowed by' and Books) ---
    public void returnBook() {
        try (Connection con = dbConnect()) {
            System.out.println("\n--- Return Book ---");
            String bid = getValidId("BOOK");

            // Find active transaction
            String sql = "SELECT transaction_id FROM borrowed_by WHERE book_id=? AND return_date IS NULL";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, bid);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int transId = rs.getInt("transaction_id");

                // Update Return Date
                String updateSql = "UPDATE borrowed_by SET return_date=? WHERE transaction_id=?";
                PreparedStatement psUpdate = con.prepareStatement(updateSql);
                psUpdate.setDate(1, Date.valueOf(LocalDate.now()));
                psUpdate.setInt(2, transId);
                psUpdate.executeUpdate();

                // Make Book Available
                PreparedStatement psBook = con.prepareStatement("UPDATE books SET available='YES' WHERE book_id=?");
                psBook.setString(1, bid);
                psBook.executeUpdate();

                System.out.println("Book Returned Successfully!");
            } else {
                System.out.println("Error: This book is not currently issued.");
            }
        } catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }

    // Utility to print tables
    private void printTable(String query, String c1, String c2, String c3) {
        try (Connection con = dbConnect(); ResultSet rs = con.createStatement().executeQuery(query)) {
            System.out.printf("%-10s %-20s %-20s%n", c1, c2, c3);
            System.out.println("--------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-10s %-20s %-20s%n", rs.getString(c1), rs.getString(c2), rs.getString(c3));
            }
        } catch (Exception e) {}
    }
}