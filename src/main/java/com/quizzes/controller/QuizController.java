package com.quizzes.controller;

import com.quizzes.model.*;
import com.quizzes.service.LogicFlow;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController // 1. Tells Spring this is the entry point for web requests
@RequestMapping("/api/quiz") // 2. All URLs will start with /api/quiz
public class QuizController {

    private final LogicFlow logicFlow;

    public QuizController(LogicFlow logicFlow) {
        this.logicFlow = logicFlow;
    }

    /**
     * ENDPOINT 1: Start the Quiz
     * URL: GET <a href="http://localhost:8080/api/quiz/start?type=multiple">...</a>
     */
    @GetMapping("/start")
    public List<QuestionType> startQuiz(@RequestParam String type) {

        // FIX 1: Assign the result of the switch to the variable
        Class<? extends QuestionType> questionClass = switch (type) {
            case "TrueOrFalse" -> TrueOrFalseQuestion.class;
            case "McqScience" -> MCQScience.class;
            case "McqGeography" -> MCQGeography.class;
            case "GeneralMCQ" -> GeneralMCQ.class;
            // FIX 2: Add a default to handle invalid or empty inputs
            default -> throw new IllegalArgumentException("Invalid quiz type: " + type);
        };

        return logicFlow.generateQuestions(questionClass);
    }

    /**
     * ENDPOINT 2: Check an Answer
     * URL: POST <a href="http://localhost:8080/api/quiz/submit">...</a>
     * Body: { "userAnswer": "A", "correctAnswer": "A" }
     */
    @PostMapping("/submit")
    public Map<String, Object> submitAnswer(@RequestBody Map<String, String> payload) {
        String userAnswer = payload.get("userAnswer");
        String correctAnswer = payload.get("correctAnswer");

        boolean isCorrect = logicFlow.checkAnswers(userAnswer, correctAnswer);

        // Return a JSON response
        if (isCorrect) {
            return Map.of("result", "Correct", "success", true);
        } else {
            return Map.of("result", "Incorrect", "success", false);
        }
    }
}