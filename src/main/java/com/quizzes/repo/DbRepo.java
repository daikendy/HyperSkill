package com.quizzes.repo;

import com.quizzes.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;

@NoRepositoryBean
public interface DbRepo<T extends QuestionType> extends JpaRepository<T, Long> {
    List<T> findAllByOrderByIdAsc();
}








