import java.util.Scanner;

public class PasswordValidator {

    public static boolean isValidPassword(String password) {
        // Check length
        if (password.length() < 8 || password.length() > 16) {
            return false;
        }

        // Flags for each category
        boolean hasLower = false;
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Allowed special characters
        String specialChars = "~!@#$%^&*()-=+_";

        // Check each character
        for (char ch : password.toCharArray()) {
            if (Character.isLowerCase(ch)) hasLower = true;
            else if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }

        // Count how many categories are satisfied
        int categories = 0;
        if (hasLower) categories++;
        if (hasUpper) categories++;
        if (hasDigit) categories++;
        if (hasSpecial) categories++;

        return categories >= 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password to validate: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password is valid ✅");
        } else {
            System.out.println("Password is INVALID ❌");
        }

        scanner.close();
    }
}