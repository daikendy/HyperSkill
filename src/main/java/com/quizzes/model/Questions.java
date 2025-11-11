package com.quizzes.model;

import com.quizzes.service.LogicFlow;
import com.quizzes.util.InputValidator;
import org.springframework.stereotype.Service;

@Service
public class Questions {
    // Multiple Choice Questions
    public void multipleChoiceQuestion() {
        System.out.println();
        System.out.println("""
                ==== Multiple Choice Question ===\
                
                 Choose the type of question\
                
                1. Science Quiz\
                
                2. Geography Quiz\
                
                3. General Knowledge Quiz""");
        int userChoice = InputValidator.avoidInputChoiceError(1, 3);
        switch (userChoice) {
            case 1:
                System.out.println("Welcome to Science Quiz");
                LogicFlow.runQuiz(MCQScience.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
                break;
            case 2:
                System.out.println("Welcome to Geography Quiz");
                LogicFlow.runQuiz(MCQGeography.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
                break;
            case 3:
                System.out.println("Welcome to General MCQ Quiz");
                LogicFlow.runQuiz(GeneralMCQ.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
                break;
        }

    }

    // True or False Questions
    public void trueOrFalseQuestion() {
        LogicFlow.runQuiz(TrueOrFalseQuestion.class, "^[TF]$", "Choose the correct option (T or F):");
    }
}
