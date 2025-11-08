package com.quizzes.services;
import com.quizzes.utilities.InputValidator;

public class Main{
    public static void main(String[] args) {
        Questions question = new Questions();
        boolean running = true;
        // checks the condition for menu selection
        while (running) {
            LogicFlow.showMenu();
            System.out.print("Enter your choice: ");
        // Handling user input; only accept valid input
        int input = InputValidator.avoidInputChoiceError(1,3);
            switch (input) {
                case 1:
                    System.out.println("--------Choose the correct answer--------");
                    System.out.println();
                    question.multipleChoiceQuestion();
                    break;
                case 2:
                    System.out.println("--------Answer with True or False--------");
                    System.out.println();
                    question.trueOrFalseQuestion();
                    break;
                case 3:
                    LogicFlow.quitProgram();
                    running = false; // Exit the loop1
                    break;
            }
    
            System.out.println(); // Just for cleaner spacing
        }
        System.out.println("Program ended.");
    }
}