package com.quizzes.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.quizzes.model.QuestionType;
import org.springframework.stereotype.Service;


@Service
public class LogicFlow {

    private final LoadQuestionsService service;
    public LogicFlow(LoadQuestionsService service) {this.service = service;}

    // Generates Questions
    public  List<QuestionType> generateQuestions(Class<? extends QuestionType> questionClass) {
        // Get the list of questions from database
        List<? extends QuestionType> questionList = service.loadQuestions(questionClass);
        if (questionList.isEmpty()) return Collections.emptyList();

        // Shuffles the questions
        List<QuestionType> shuffled = new ArrayList<>(questionList);
        Collections.shuffle(shuffled);

        // Limit the Questions
        int limitOfQuestion = 10;
        int numberOfQuestions = Math.min(limitOfQuestion, shuffled.size());
        return shuffled.subList(0, numberOfQuestions);
    }

    // Validates Answer
    public boolean checkAnswers(String input, String correctAnswer) {
        if (input == null || correctAnswer == null) return false;
        return input.trim().equalsIgnoreCase(correctAnswer.trim());
    }
}
