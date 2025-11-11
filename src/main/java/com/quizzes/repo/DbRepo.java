package com.quizzes.repo;

import com.quizzes.model.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DbRepo<integer> extends JpaRepository<QuestionType, integer> { }
