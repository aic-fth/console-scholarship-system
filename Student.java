import java.util.Scanner;

public class Student extends User {

    public Student(String email, String password) {
        super(email, password, "Student");
    }

    @Override
    public void showMenu(Scanner sc) {
        while (true) {
            System.out.println("""
                    \n===== STUDENT MENU =====
                    1. Apply for Scholarship
                       - Fill in name, GPA, family income, essay
                       - Application status will be "Pending"
                    2. View Application Status
                       - See if approved, rejected, or pending
                       - View reviewer feedback/comments
                    3. Update Profile
                       - Edit password or personal info
                    0. Logout (back to main)
                    """);
            System.out.print("Choose an option: ");
            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1" -> System.out.println("Apply for Scholarship (not implemented).");
                case "2" -> System.out.println("View Application Status (not implemented).");
                case "3" -> System.out.println("Update Profile (not implemented).");
                case "0" -> {
                    System.out.println("Logging out...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
