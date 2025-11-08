package com.quizzes.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.quizzes.utilities.HibernateUtil;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


interface HasNoOptionsQuestion{
    String getQuestions();
    String getAnswer();
    boolean hasOptions();
    int getId();
}

public interface QuestionType extends HasNoOptionsQuestion{
    Session session = HibernateUtil.getSessionFactory().openSession();
    // returns null for T/F type or empty array
    String getOptions_a();
    String getOptions_b();
    String getOptions_c();
    String getOptions_d();
    
}


@Entity
@Table(name = "mcq_general")
class GeneralMCQ implements QuestionType {

    @Id
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

    public GeneralMCQ() {}

    @Override
    public boolean hasOptions() {
        return true;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptions_a() {
        return options_a;
    }

    public void setOptions_a(String options_a) {
        this.options_a = options_a;
    }

    public String getOptions_b() {
        return options_b;
    }

    public void setOptions_b(String options_b) {
        this.options_b = options_b;
    }

    public String getOptions_c() {
        return options_c;
    }

    public void setOptions_c(String options_c) {
        this.options_c = options_c;
    }

    public String getOptions_d() {
        return options_d;
    }

    public void setOptions_d(String options_d) {
        this.options_d = options_d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

@Entity
@Table(name = "mcq_science")
class MCQScience implements QuestionType  {

    @Id
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

    public MCQScience() {}


    @Override
    public boolean hasOptions() {
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptions_a() {
        return options_a;
    }

    public void setOptions_a(String options_a) {
        this.options_a = options_a;
    }

    public String getOptions_b() {
        return options_b;
    }

    public void setOptions_b(String options_b) {
        this.options_b = options_b;
    }

    public String getOptions_c() {
        return options_c;
    }

    public void setOptions_c(String options_c) {
        this.options_c = options_c;
    }

    public String getOptions_d() {
        return options_d;
    }

    public void setOptions_d(String options_d) {
        this.options_d = options_d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

@Entity
@Table(name = "mcq_geography")
class MCQGeography implements QuestionType {

    @Id
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
    
    public MCQGeography() {}

        @Override
    public boolean hasOptions() {
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public String getOptions_a() {
        return options_a;
    }

    public void setOptions_a(String options_a) {
        this.options_a = options_a;
    }

    public String getOptions_b() {
        return options_b;
    }

    public void setOptions_b(String options_b) {
        this.options_b = options_b;
    }

    public String getOptions_c() {
        return options_c;
    }

    public void setOptions_c(String options_c) {
        this.options_c = options_c;
    }

    public String getOptions_d() {
        return options_d;
    }

    public void setOptions_d(String options_d) {
        this.options_d = options_d;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}

@Entity
@Table(name = "tf_questions")
class TrueOrFalseQuestion implements HasNoOptionsQuestion {

    @Id
    private int id;

    @Column(name="questions")
    private String questions;

    @Column(name="answer")
    private String  answer;

    public TrueOrFalseQuestion(String questions, String answer){
        this.questions = questions;
        this.answer = answer;
    }
    public TrueOrFalseQuestion() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestions() {
        return questions;
    }

    public String getAnswer() {
        return answer;
    }

    @Override
    public boolean hasOptions() {
        return true;
    }
}

