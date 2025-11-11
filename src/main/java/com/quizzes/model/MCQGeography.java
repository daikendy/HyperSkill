package com.quizzes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
@Entity
@Table(name = "mcq_geography")
public class MCQGeography implements QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "questions")
    private String questions;

    @Column(name = "options_a")
    private String options_a;

    @Column(name = "options_b")
    private String options_b;

    @Column(name = "options_c")
    private String options_c;

    @Column(name = "options_d")
    private String options_d;

    @Column(name = "answer")
    private String answer;

    @Override
    public boolean hasOptions() {
        return true;
    }
}
