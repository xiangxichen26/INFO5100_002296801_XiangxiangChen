package org.example;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void testingCases(String pattern, String testElement, String[] testCases){
        System.out.println("Testing Case: " + testElement);
        Pattern compiledPattern = Pattern.compile(pattern);
        for (String testCase : testCases) {
            Matcher matcher = compiledPattern.matcher(testCase);
            System.out.println("   Case \"" + testCase + "\": " + (matcher.matches() ? "Pass" : "Fail"));
        }
        System.out.println("------------------------------------------------------------");
    }
    public static void main(String[] args) {
        // Test Cases
        String[] username = {"KellyChen126", "_kellychen!126"};
        String[] email = {"chen.xiangxi@northeastern.edu", "chen.xiangxi"};
        String[] phoneNumber = {"650-302-7962", "6503027962"};
        String[] password = {"1!12x12C33x", "123456"};
        String[] birthday = {"01/26/1998", "01-26-1998"};

        // Patterns
        String usernamePattern = "^[a-zA-z0-9]+$"; // only letters and numbers
        String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+.[a-zA-Z]{2,}$"; // email pattern
        String phoneNumberPattern = "\\d{3}-\\d{3}-\\d{4}"; // phone number pattern and much be in the format of 123-456-7890
        String passwordPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$"; // at least 8 characters and one is uppercase, one is lowercase, one is digital, and one is special character in
        String birthdayPattern = "^\\d{2}/\\d{2}/\\d{4}"; // birthday pattern and must be in the format of MM/DD/YYYY

        // Testing
        testingCases(usernamePattern, "username", username);
        testingCases(emailPattern, "email", email);
        testingCases(phoneNumberPattern, "phoneNumber", phoneNumber);
        testingCases(passwordPattern, "password", password);
        testingCases(birthdayPattern, "birthday", birthday);

    }

}
