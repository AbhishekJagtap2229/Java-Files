package demo;
import java.util.Scanner;

public class RegistrationForm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your email address: ");
        String email = input.nextLine();

        // Validate email format
        while (!isValidEmail(email)) {
            System.out.print("Invalid email address. Please enter a valid email address: ");
            email = input.nextLine();
        }

        System.out.print("Enter your password: ");
        String password = input.nextLine();

        // Validate password length
        while (password.length() < 8) {
            System.out.print("Password must be at least 8 characters. Please enter a valid password: ");
            password = input.nextLine();
        }

        System.out.println("Registration successful!");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Password: " + password);
    }

    // Helper method to validate email format
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";
        return email.matches(emailRegex);
    }
}

