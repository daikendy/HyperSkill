package com.quizzes.model;

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