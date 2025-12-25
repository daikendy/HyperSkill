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

    final private int limitOfQuestion = 5;
    private final LoadQuestionsService service;
    public LogicFlow(LoadQuestionsService service) {this.service = service;}

    // runQuiz method to handle the quiz logic
    // It takes a QuestionType object, input pattern for validation, and input
    // prompt as parameters
    public  List<? extends QuestionType> generateQuestions(Class<? extends QuestionType> questionClass) {
        // Get the list of questions from database
        List<? extends QuestionType> questionList = service.loadQuestions(questionClass);

    }

    /*
     * Method to check the answer and update the score
     * It takes the user's input and the correct answer as parameters
     */
    public boolean checkAnswers(String input, String correctAnswer) {
        return input.equalsIgnoreCase(correctAnswer);
    }
}
