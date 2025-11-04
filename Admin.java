import java.util.Scanner;

public class Admin extends User {

    public Admin(String email, String password) {
        super(email, password, "Admin");
    }

    @Override
    public void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    \n===== ADMIN MENU =====
                    1. Manage Users
                       - View all users
                       - Remove users
                       - Update user roles or credentials
                    2. View Reports
                       - View overall scholarship applications
                       - Filter by student status (approved/pending/rejected)
                       - Export reports (simulated in console)
                    0. Logout (back to main)
                    """);
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> System.out.println("Manage Users (not implemented).");
                case "2" -> System.out.println("View Reports (not implemented).");
                case "0" -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
