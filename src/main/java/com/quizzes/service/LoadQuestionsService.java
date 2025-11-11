package com.quizzes.service;

import com.quizzes.model.*;
import com.quizzes.repo.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public  class LoadQuestionsService {

    @Autowired
    private static GeneralMCQRepository genMcq;
    @Autowired
    private static MCQScienceRepository scienceMcq;
    @Autowired
    private static MCQGeographyRepository geographyMcq;
    @Autowired
    private static TFQuestionRepository tfQuestion;
    // Helper method to load questions
    public  static List<? extends QuestionType> loadQuestions(Class<? extends QuestionType> questionClass) {
        if (questionClass.equals(GeneralMCQ.class)){
            return genMcq.findAllByOrderByIdAsc();
        }
        if (questionClass.equals(MCQScience.class)) {
            return scienceMcq.findAllByOrderByIdAsc();
        }
        if (questionClass.equals(MCQGeography.class)) {
            return geographyMcq.findAllByOrderByIdAsc();
        }
        if (questionClass.equals(TrueOrFalseQuestion.class)) {
            return tfQuestion.findAllByOrderByIdAsc();
        }
        return new ArrayList<>();
    }
}
