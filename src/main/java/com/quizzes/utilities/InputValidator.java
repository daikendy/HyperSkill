package com.quizzes.utilities;

import java.util.Scanner;
import com.quizzes.services.LogicFlow;

public class InputValidator {

static Scanner scan = new Scanner(System.in);
static LogicFlow scores = new LogicFlow();

// Method to avoid input choice error
// It reads the input and checks if it matches the expected pattern
// Returns the parsed integer value of the input
    public static int avoidInputChoiceError(int min, int max) {
        String regex = String.format("[%d-%d]", min, max);
        String scanChoice = scan.nextLine().trim();
    while (!scanChoice.matches(regex)) {
        System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ":");
        scanChoice = scan.nextLine().trim();
    }
        return Integer.parseInt(scanChoice);
    }

    // Reusable method for getting input with BACK option and validation
    public static String getInput(String pattern, String prompt) {
    while (true) {
        System.out.println();
        System.out.println(prompt);
        System.out.println("Type 'BACK' to return to the main menu.");
        System.out.println("Type 'SKIP' to skip to the next question.");
        String input = scan.nextLine().trim().toUpperCase();

        if (input.equals("BACK")) {
            scores.setTotalScore(0);
            scores.setNumberOfQuestion(1);
            return "BACK";
        }
        if (input.equals("SKIP")) return "SKIP";
        if (input.matches(pattern)) {
            return input;
        }
        System.out.println("Invalid input. Try again.");
    }
}

}
