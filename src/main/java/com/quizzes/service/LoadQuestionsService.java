package com.quizzes.service;

import com.quizzes.model.*;
import com.quizzes.repo.*;

import java.util.ArrayList;
import java.util.List;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public  class LoadQuestionsService {

    private GeneralMCQRepository genMcq;
    private  MCQScienceRepository scienceMcq;
    private MCQGeographyRepository geographyMcq;
    private TFQuestionRepository tfQuestion;

    @Autowired
    public LoadQuestionsService(GeneralMCQRepository genMcq, MCQScienceRepository scienceMcq, MCQGeographyRepository geographyMcq, TFQuestionRepository tfQuestion) {
        this.genMcq = genMcq;
        this.scienceMcq =  scienceMcq;
        this.geographyMcq =  geographyMcq;
        this.tfQuestion =  tfQuestion;
    }
    // Helper method to load questions
    public  List<? extends QuestionType> loadQuestions(Class<? extends QuestionType> questionClass) {
        if (questionClass.equals(GeneralMCQ.class)){
            return genMcq.findAllByOrderByIdAsc();
        }
        else if (questionClass.equals(MCQScience.class)) {
            return scienceMcq.findAllByOrderByIdAsc();
        }
        else if (questionClass.equals(MCQGeography.class)) {
            return geographyMcq.findAllByOrderByIdAsc();
        }
        else if (questionClass.equals(TrueOrFalseQuestion.class)) {
            return tfQuestion.findAllByOrderByIdAsc();
        }
        return new ArrayList<>();
    }
}
