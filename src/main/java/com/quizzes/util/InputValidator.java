package com.quizzes.util;

import java.util.Scanner;
import com.quizzes.service.LogicFlow;

public class InputValidator {

    static Scanner scan = new Scanner(System.in);

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

}
