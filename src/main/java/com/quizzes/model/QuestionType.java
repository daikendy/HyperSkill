package com.quizzes.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

interface HasNoOptionsQuestion{
    String getQuestions();
    String getAnswer();
    boolean hasOptions();
    int getId();
}

public interface QuestionType extends HasNoOptionsQuestion{
    // returns null for T/F type or empty array
    String getOptions_a();
    String getOptions_b();
    String getOptions_c();
    String getOptions_d();
}

@Setter
@Getter
@Entity
@Table(name = "mcq_general")
class GeneralMCQ implements QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="questions")
    private String questions;

    @Column(name="options_a")

    private String options_a;
    @Column(name="options_b")
    private String options_b;

    @Column(name="options_c")
    private String options_c;

    @Column(name="options_d")
    private String options_d;

    @Column(name="answer")
    private String answer;

    @Override
    public boolean hasOptions() {
        return true;
    }

}

@Setter
@Getter
@Entity
@Table(name = "mcq_science")
class MCQScience implements QuestionType  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="questions")
    private String questions;

    @Column(name="options_a")
    private String options_a;

    @Column(name="options_b")
    private String options_b;

    @Column(name="options_c")
    private String options_c;

    @Column(name="options_d")
    private String options_d;

    @Column(name="answer")
    private String answer;

    @Override
    public boolean hasOptions() {
        return true;
    }

}

@Setter
@Getter
@Entity
@Table(name = "mcq_geography")
class MCQGeography implements QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="questions")
    private String questions;

    @Column(name="options_a")
    private String options_a;

    @Column(name="options_b")
    private String options_b;

    @Column(name="options_c")
    private String options_c;

    @Column(name="options_d")
    private String options_d;

    @Column(name="answer")
    private String answer;

    @Override
    public boolean hasOptions() {
        return true;
    }

}
@Setter
@Getter
@Entity
@Table(name = "tf_questions")
class TrueOrFalseQuestion implements QuestionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="questions")
    private String questions;

    @Column(name="answer")
    private String  answer;

    @Column(name="options_a")
    private String options_a;

    @Column(name="options_b")
    private String options_b;

    @Column(name="options_c")
    private String options_c;

    @Column(name="options_d")
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
