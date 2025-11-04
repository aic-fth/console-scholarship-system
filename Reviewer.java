import java.util.Scanner;

public class Reviewer extends User {

    public Reviewer(String email, String password) {
        super(email, password, "Reviewer");
    }

    @Override
    public void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    \n===== REVIEWER MENU =====
                    1. Review Applications
                       - List pending applications
                       - Approve/Reject applications
                       - Add comments/feedback
                    2. View Reports
                       - See application statistics (approved, rejected, pending)
                       - Track student progress
                    0. Logout (back to main)
                    """);
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> System.out.println("Review Applications (not implemented).");
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
