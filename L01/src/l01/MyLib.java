/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package l01;

import java.util.Scanner;

/**
 * Utility class providing input validation methods Used for validating various
 * types of user inputs like phone number, email, address, etc.
 *
 * @author TrongTBCE190757
 */
public class MyLib {

    static Scanner sc = new Scanner(System.in); // Scanner instance for reading input

    /**
     * Prompts the user for a valid phone number input. The phone number is
     * validated based on a regular expression for Vietnamese numbers.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated phone number.
     */
    public static String getPhone(String msg, String errorMsg) {
        String reg = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|"
                + "(7[06-9])|(8[1-689])|(9[0-46-9]))"
                + "(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$"; // Regular expression for phone validation
        String p = null;
        boolean isTrue;
        do {
            isTrue = false;
            System.out.print(msg);
            p = sc.nextLine().trim(); // Get user input
            if (p.length() < 10) {
                System.out.println(errorMsg); // Display error if the phone number is too short
            } else if (!p.matches(reg)) {
                System.out.println(errorMsg); // Display error if the phone number doesn't match the regex
            } else {
                isTrue = true; // Input is valid
            }
        } while (!isTrue); // Repeat if input is invalid
        return p; // Return valid phone number
    }

    /**
     * Prompts the user for a valid email address. The email is validated based
     * on a regular expression for email addresses.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated email address.
     */
    public static String getEmail(String msg, String errorMsg) {
        String reg = "^(?:" // Regular expression for email validation
                + "\"(?:[^\\x00-\\x1F\\x22\\x5C\\x7F-\\xFF]|\\\\[\\x20-\\x7E])*\""
                + "|"
                + "[a-zA-Z0-9]{1,63}(?:\\.[a-zA-Z0-9]{1,63}){0,31}"
                + ")@"
                + "(?:"
                + "(?=.{1,253}$)(?!.*--)(?:[\\p{L}\\p{N}](?:[\\p{L}\\p{N}-]{0,61}[\\p{L}\\p{N}])?\\.)+[\\p{L}]{2,63}"
                + ")$";
        String e = null;
        boolean isTrue;
        do {
            isTrue = false;
            System.out.print(msg);
            e = sc.nextLine().trim(); // Get user input
            if (!e.matches(reg)) {
                System.out.println(errorMsg); // Display error if email doesn't match the regex
            } else {
                isTrue = true; // Input is valid
            }
        } while (!isTrue); // Repeat if input is invalid
        return e; // Return valid email
    }

    /**
     * Prompts the user for a valid address input. The address is validated
     * based on a regular expression that allows letters, digits, and special
     * characters.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated address.
     */
    public static String getAddress(String msg, String errorMsg) {
        String reg = "^(?!\\d+$)([\\p{L}0-9]|[\\p{L}0-9]"
                + "[\\p{L}0-9\\/\\-\\,\\.\\s]*[\\p{L}0-9])$"; // Regular expression for address validation
        String a = null;
        boolean isTrue;
        do {
            isTrue = false;
            System.out.print(msg);
            a = sc.nextLine().trim(); // Get user input
            if (!a.matches(reg)) {
                System.out.println(errorMsg); // Display error if address doesn't match the regex
            } else {
                isTrue = true; // Input is valid
            }
        } while (!isTrue); // Repeat if input is invalid
        return a; // Return valid address
    }

    /**
     * Prompts the user for any valid input string. The string must not be empty
     * and can contain letters, digits, or spaces.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated input string.
     */
    public static String getInfor(String msg, String errorMsg) {
        String n;
        boolean isValid;
        do {
            System.out.print(msg);
            n = sc.nextLine().trim(); // Get user input
            isValid = true;
            if (n.isBlank()) {
                System.out.println(errorMsg); // Display error if input is empty
                isValid = false; // Mark as invalid
                continue;
            }
            for (int i = 0; i < n.length(); i++) {
                char c = n.charAt(i);
                if (!Character.isLetterOrDigit(c) && !Character.isWhitespace(c)) {
                    System.out.println(errorMsg); // Display error if the input contains invalid characters
                    isValid = false;
                    break; // Stop checking further if invalid character is found
                }
            }
        } while (!isValid); // Repeat if input is invalid
        return n; // Return valid input
    }

    /**
     * Prompts the user for a valid string that only contains letters. It also
     * allows spaces or underscores between words.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated input string containing only letters, spaces, or
     * underscores.
     */
    public static String getChar(String msg, String errorMsg) {
        String n = null;
        boolean isValid;
        do {
            System.out.print(msg);
            n = sc.nextLine().trim(); // Get user input
            if (n.isEmpty()) {
                System.out.println(errorMsg); // Display error if input is empty
                isValid = false;
                continue;
            }
            isValid = true;
            for (int j = 0; j < n.length(); j++) {
                if (!Character.isLetter(n.charAt(j))) {
                    System.out.println(errorMsg); // Display error if the input contains non-letter characters
                    isValid = false;
                    break; // Stop checking further if invalid character is found
                }
            }
        } while (!isValid); // Repeat if input is invalid
        return n; // Return valid input
    }

    /**
     * Prompts the user for a valid integer input. If the input is not an
     * integer or if it's out of range, an error message is shown.
     *
     * @param msg The message to prompt the user.
     * @param errorMsg The error message shown for invalid input.
     * @return The validated integer.
     */
    public static int getNumber(String msg, String errorMsg) {
        int n = 0;
        boolean isTrue;
        do {
            try {
                isTrue = true;
                System.out.print(msg);
                String s = sc.nextLine();
                n = Integer.parseInt(s); // Parse input as integer
                if (s.isEmpty()) {
                    System.out.println(errorMsg); // Display error if input is empty
                    isTrue = false;
                    continue;
                }
                if (n >= 'a' && n <= 'z' || n >= 'A' && n <= 'Z') {
                    System.out.println(errorMsg); // Display error if input contains letters
                    isTrue = false;
                }
            } catch (Exception e) {
                System.out.println(errorMsg); // Display error if input is not a valid integer
                isTrue = false;
            }
        } while (!isTrue); // Repeat if input is invalid
        return n; // Return valid integer
    }
}
