package com.quizzes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@Entity
@Table(name = "tf_questions")
public class TrueOrFalseQuestion implements QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "questions")
    private String questions;

    @Column(name = "answer")
    private String answer;

    @Column(name = "options_a")
    private String options_a;

    @Column(name = "options_b")
    private String options_b;

    @Column(name = "options_c")
    private String options_c;

    @Column(name = "options_d")
    private String options_d;

    @Override
    public boolean hasOptions() {
        return false;
    }

    @Override
    public String getOptions_a() {
        return "";
    }

    @Override
    public String getOptions_b() {
        return "";
    }

    @Override
    public String getOptions_c() {
        return "";
    }

    @Override
    public String getOptions_d() {
        return "";
    }
}
