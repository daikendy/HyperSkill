package com.quizzes.service;

import com.quizzes.model.Questions;
import com.quizzes.util.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Menu {

    private final Questions question;
    private final LogicFlow logicFlow;
    @Autowired
    public Menu(Questions questions, LogicFlow logicFlow) {
        this.question = questions;
        this.logicFlow = logicFlow;
    }

    public void runMenu(){
        boolean running = true;
        // checks the condition for menu selection
        while (running) {
            logicFlow.showMenu();
            System.out.print("Enter your choice: ");
            // Handling user input; only accept valid input
            int input = InputValidator.avoidInputChoiceError(1, 3);
            switch (input) {
                case 1:
                    question.multipleChoiceQuestion();
                    break;
                case 2:
                    question.trueOrFalseQuestion();
                    break;
                case 3:
                    logicFlow.quitProgram();
                    System.out.println("Program ended.");
                    running = false; // Exit the loop1
                    break;
            }
        }
    }
}
