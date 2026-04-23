package BKLOAN.Utilities;

import java.util.regex.Pattern;

public class InputValidator {

    public static boolean isEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    public static boolean isPositiveNumber(double number) {
        return number > 0;
    }

    public static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidInterestRate(double rate) {
        return rate > 0 && rate <= 100;
    }

    public static boolean isValidPhone(String phone) {
        return phone != null && Pattern .matches("\\d{10}", phone);
    }

    public static boolean isValidNationalId(String nationalId) {
        return nationalId != null && Pattern.matches("\\d{16}", nationalId);
    }

    public static boolean isValidLoanType(String type) {
        String[] validTypes = {"Personal", "Home", "Car", "Business", "Student", "Agricultural"};
        for (String t : validTypes) {
            if (t.equalsIgnoreCase(type)) return true;
        }
        return false;
    }

    public static void showError(String message) {
        System.out.println("Error: " + message);
    }
}
