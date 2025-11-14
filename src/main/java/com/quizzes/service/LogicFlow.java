package com.quizzes.service;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.quizzes.model.QuestionType;
import com.quizzes.model.TrueOrFalseQuestion;
import org.springframework.stereotype.Service;
import lombok.Getter;
import lombok.Setter;

@Service
public class LogicFlow {
    static Scanner scan = new Scanner(System.in);

    @Setter
    @Getter
    private int totalScore;
    private int skippedQuestions;
    final private int limitOfQuestion = 5;
    @Setter
    @Getter
    private int numberOfQuestion = 1;

    private final LoadQuestionsService service;
    public LogicFlow(LoadQuestionsService service) {
        this.service = service;
    }

    // runQuiz method to handle the quiz logic
    // It takes a QuestionType object, input pattern for validation, and input
    // prompt as parameters
    public void runQuiz(Class<? extends QuestionType> questionClass, String inputPattern, String inputPrompt) {
        // Get the list of questions from database
        List<? extends QuestionType> questionList = service.loadQuestions(questionClass);

        if (questionList.isEmpty()) {
            System.out.println("No questions available!");
            return;
        }

        // Shuffle the order
        List<Integer> shuffledIndices = new ArrayList<>();
        for (int i = 0; i < questionList.size(); i++) {
            shuffledIndices.add(i);
        }
        Collections.shuffle(shuffledIndices);

        // Run quiz with actual questions
        for (int i = 0; i < Math.min(limitOfQuestion, questionList.size()); i++) {
            QuestionType question = questionList.get(shuffledIndices.get(i));

            System.out.println(numberOfQuestion++ + ". " + question.getQuestions());
            if (question.hasOptions()) {
                System.out.println("A) " + question.getOptions_a());
                System.out.println("B) " + question.getOptions_b());
                System.out.println("C) " + question.getOptions_c());
                System.out.println("D) " + question.getOptions_d());
            }
            if (questionClass == TrueOrFalseQuestion.class) {
                System.out.print(
                        question.getOptions_a() + question.getOptions_b() + question.getOptions_c() + question.getOptions_d());
            }

            String input = getInput(inputPattern, inputPrompt);
            if (input.equals("BACK"))
                return;
            if (input.equals("SKIP")) {
                System.out.println("Question skipped. Correct answer is " + question.getAnswer());
                skippedQuestions++;
                System.out.println();
                continue;
            }
            checkAnswers(input, question.getAnswer());
        }
        resetQuestions();
    }

    /*
     * Method to check the answer and update the score
     * It takes the user's input and the correct answer as parameters
     */
    public void checkAnswers(String input, String correctAnswer) {
        if (input.equalsIgnoreCase(correctAnswer)) {
            System.out.println("Correct!");
            totalScore++;
        } else {
            System.out.println("Incorrect. The correct answer is " + correctAnswer);
        }
        System.out.println(); // Just for cleaner spacing
    }

    /*
     * Method to reset the question counter and score
     * displays the total score and a "thank you" message
     */
    public void resetQuestions() {
        System.out.println("Total Score: " + totalScore + "/" + limitOfQuestion);
        System.out.println("Total skipped questions: " + skippedQuestions);
        System.out.println("End of the quiz. Thanks for playing!");
        // Reset the question counter and score for the next quiz
        totalScore = 0;
        skippedQuestions = 0;
        numberOfQuestion = 1;
    }

    // Reusable method for getting input with BACK option and validation
    public String getInput(String pattern, String prompt) {
        while (true) {
            System.out.println();
            System.out.println(prompt);
            System.out.println("Type 'BACK' to return to the main menu.");
            System.out.println("Type 'SKIP' to skip to the next question.");
            String input = scan.nextLine().trim().toUpperCase();

            if (input.equals("BACK")) {
                totalScore = 0;
                skippedQuestions = 0;
                numberOfQuestion = 1;
                return "BACK";
            }
            if (input.equals("SKIP"))
                return "SKIP";
            if (input.matches(pattern)) {
                return input;
            }
            System.out.println("Invalid input. Try again.");
        }
    }

    public void showMenu() {
        System.out.println("<--------Choose-------->");
        System.out.println("1. Multiple Choice");
        System.out.println("2. True Or False");
        System.out.println("3. Quit");
    }

    public void quitProgram() {
        System.out.println("Quitting the program. See you!");
    }
}
