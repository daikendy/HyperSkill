package com.quizzes.repo;

import com.quizzes.model.TrueOrFalseQuestion;
import org.springframework.stereotype.Repository;

@Repository
public interface TFQuestionRepository extends DbRepo<TrueOrFalseQuestion> {}