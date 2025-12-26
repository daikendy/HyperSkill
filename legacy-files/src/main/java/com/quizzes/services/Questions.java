package com.quizzes.services;

import com.quizzes.utilities.InputValidator;

public class Questions {

  // Multiple Choice Questions
  public void multipleChoiceQuestion() {
    System.out.println();
    System.out.println("==== Multiple Choice Question ==="
        + "\n Choose the type of question"
        + "\n1. Science Quiz"
        + "\n2. Geography Quiz"
        + "\n3. General Knowledge Quiz");
    int userChoice = InputValidator.avoidInputChoiceError(1, 3);
    switch (userChoice) {
      case 1:
        System.out.println("Welcome to Science Quiz");
        LogicFlow.runQuiz(MCQScience.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 2:
        System.out.println("Welcome to Geography Quiz");
        LogicFlow.runQuiz(MCQGeography.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 3:
        System.out.println("Welcome to General MCQ Quiz");
        LogicFlow.runQuiz(GeneralMCQ.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
    }

  }

  // True or False Questions
  public void trueOrFalseQuestion() {
    LogicFlow.runQuiz(TrueOrFalseQuestion.class, "^[TF]$", "Choose the correct option (T or F):");
  }

}
