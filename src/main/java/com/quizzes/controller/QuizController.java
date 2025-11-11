package com.quizzes.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    @RequestMapping("/")
    public String getQuizzes() {
        return "Hello, Quizzes!";
    }

}
