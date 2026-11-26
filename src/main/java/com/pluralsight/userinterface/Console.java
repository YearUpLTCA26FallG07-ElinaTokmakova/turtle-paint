package com.pluralsight.userinterface;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Console {
    private static final Scanner scanner = new Scanner(System.in);

    // Required user input for string
    public static String promptForString(String prompt) {
        return promptForString(prompt, false);
    }

    // Skippable user input for string
    public static String promptForString(String prompt, boolean skippable) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                if (skippable) { // If a field is skippable
                    return null;
                } else {
                    System.out.println("This field is required."); // If a field is unskippable
                    continue;
                }
            }
            return input;
        }
    }

    // Required user input for integer
    public static int promptForInt(String prompt) {
        return promptForInt(prompt, false);
    }

    // Skippable user input for integer
    public static int promptForInt(String prompt, boolean skippable) {
            while (true) {
                System.out.print(prompt);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    if (skippable) { // If a field is skippable
                        return Integer.parseInt(null);
                    } else {
                        System.out.println("This field is required."); // If a field is unskippable
                        continue;
                    }
                }
                try { // Convert string to integer
                    return Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid whole number.");
                } catch (Exception e) {
                    System.out.println("Something went wrong. Please try again.");
                }
            }
    }

    // User input for any numbers
    public static double promptForDouble(String prompt) {
        double result = 0.0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                result = scanner.nextDouble();
                scanner.nextLine(); // Consume the newline
                isValid = true;     // Input was successful, exit loop
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid input. Please enter a valid number.");
                scanner.nextLine(); // Clear the bad input from the scanner buffer
            }
        } while (!isValid);

        return result;
    }
}
