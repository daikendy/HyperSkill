package com.quizzes.controller;

import com.quizzes.model.MCQScience;
import com.quizzes.model.Questions;
import com.quizzes.service.LoadQuestionsService;
import com.quizzes.service.LogicFlow;
import com.quizzes.service.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/science")
public class QuizController {

    @RequestMapping("/questions")
    public String getScience (){
        return "Kinda confusing this one with RESTful API...";
    }
}
