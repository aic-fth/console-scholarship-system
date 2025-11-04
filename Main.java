import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<User> users = new ArrayList<>();

    static {
        // Predefined Admin and Reviewer accounts
        users.add(new Admin("admin@gmail.com", "admin123"));
        users.add(new Reviewer("reviewer@gmail.com", "reviewer123"));
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                displayMainMenu();
                System.out.print("> Enter your choice: ");
                String choice = sc.nextLine().trim();

                switch (choice) {
                    case "1" -> login(sc);
                    case "2" -> register(sc);
                    case "0" -> {
                        System.out.println("\nExiting program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("\nInvalid option. Try again.\n");
                }
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("""
                \n\n===================================================================
                    Console-Based Student Scholarship Management System
                ===================================================================
                                :> SDG #10: Reduced Inequalities
                                :> Batangas State University - Lipa Campus
                                :> Academic Year 2025-2026
                ===================================================================

                Welcome! Ready to manage your scholarship journey?
                Select an option to proceed.

                MAIN MENU
                -------------------------------------------------------------------
                [1] Log In
                [2] Apply for Scholarship / Register
                [0] Exit Program
                -------------------------------------------------------------------
                """);
    }

    private static void login(Scanner sc) {
        System.out.print("\nEnter Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        User user = findUser(email, password);

        if (user != null) {
            System.out.println("\nLogin successful! Redirecting to " + user.getRole() + " menu...\n");
            user.showMenu(sc);
        } else {
            System.out.println("\nInvalid email or password. Try again.\n");
        }
    }

    private static void register(Scanner sc) {
        System.out.print("\nEnter Email: ");
        String email = sc.nextLine().trim();
        System.out.print("Enter Password: ");
        String password = sc.nextLine().trim();

        if (email.isEmpty() || password.isEmpty() || userExists(email)) {
            System.out.println("\nRegistration failed. Email may already exist or fields are empty.\n");
            return;
        }

        User newUser = new Student(email, password); // Students must register
        users.add(newUser);
        System.out.println("\nRegistration successful! Redirecting to Student menu...\n");
        newUser.showMenu(sc);
    }

    private static User findUser(String email, String password) {
        return users.stream()
                .filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }

    private static boolean userExists(String email) {
        return users.stream().anyMatch(u -> u.getEmail().equals(email));
    }
}
