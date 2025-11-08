package com.quizzes.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;

import com.quizzes.utilities.HibernateUtil;
import com.quizzes.utilities.InputValidator;

public class LogicFlow {
  Scanner scan = new Scanner(System.in);
  List<Integer> order = new ArrayList<>();
  private int totalScore;
  private int skippedQuestions;
  final private int limitOfQuestion = 5;
  private int numberOfQuestion = 1;

  public int getTotalScore() {
    return totalScore;
  }

  public void setTotalScore(int totalScore) {
    this.totalScore = totalScore;
  }

  public int getNumberOfQuestion() {
    return numberOfQuestion;
  }

  public void setNumberOfQuestion(int numberOfQuestion) {
    this.numberOfQuestion = numberOfQuestion;
  }

/*shuffleQuestions method to randomize the order of questions
  It takes the total number of questions as a parameter */
  public void shuffleQuestions(Class<? extends QuestionType> questionClass) {
    order.clear();
    
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        
        // Only query the specific type you need
        List<?> questionList = session.createQuery(
            "from " + questionClass.getSimpleName() + " order by id asc", 
            questionClass
        ).list();
        
        for (int i = 0; i < questionList.size(); i++) {
            order.add(i);
        }
        
        Collections.shuffle(order);
        session.getTransaction().commit();
        
    } catch (Exception e) {
        e.printStackTrace();
    }
}

// runQuiz method to handle the quiz logic
  // It takes a QuestionType object, input pattern for validation, and input prompt as parameters
    public void runQuiz(Class<? extends QuestionType> questionClass, String inputPattern, String inputPrompt) {
    // Get the list of questions from database
    List<? extends QuestionType> questionList = loadQuestions(questionClass);
    
    if (questionList.isEmpty()) {
        System.out.println("No questions available!");
        return;
    }
    
    // Shuffle the order
    List<Integer> shuffledIndices = new ArrayList<>();
    for (int i = 0; i < questionList.size(); i++) {
        shuffledIndices.add(i);
    }
    Collections.shuffle(shuffledIndices);
    
    // Run quiz with actual questions
    for (int i = 0; i < Math.min(limitOfQuestion, questionList.size()); i++) {
        QuestionType question = questionList.get(shuffledIndices.get(i));
        
        System.out.println(numberOfQuestion++ + ". " + question.getQuestions());
        if (question.hasOptions()) {
            System.out.println("A) " + question.getOptions_a());
            System.out.println("B) " + question.getOptions_b());
            System.out.println("C) " + question.getOptions_c());
            System.out.println("D) " + question.getOptions_d());
        }
        
        String input = InputValidator.getInput(inputPattern, inputPrompt);
        if (input.equals("BACK")) return;
        if (input.equals("SKIP")) {
            System.out.println("Question skipped. Correct answer is " + question.getAnswer());
            skippedQuestions++;
            System.out.println();
            continue;
        }
        checkAnswers(input, question.getAnswer());
    }
    resetQuestions();
}

// Helper method to load questions
private List<? extends QuestionType> loadQuestions(Class<? extends QuestionType> questionClass) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        List<? extends QuestionType> questionList = session.createQuery(
            "from " + questionClass.getSimpleName() + " order by id asc", 
            questionClass
        ).list();
        session.getTransaction().commit();
        return questionList;
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

/* Method to check the answer and update the score
  It takes the user's input and the correct answer as parameters*/ 
  public void checkAnswers(String input, String correctAnswer){
    if (input.equalsIgnoreCase(correctAnswer)) {
        System.out.println("Correct!");
        totalScore++;
    }
    else {
        System.out.println("Incorrect. The correct answer is " + correctAnswer);
    }
    System.out.println(); // Just for cleaner spacing
  }

/* Method to reset the question counter and score
    displays the total score and a thank you message */
  public void resetQuestions(){
    System.out.println("Total Score: " + totalScore + "/" + limitOfQuestion);
    System.out.println("Total skipped questions: " + skippedQuestions);
    System.out.println("End of the quiz. Thanks for playing!");
    // Reset the question counter and score for the next quiz
    totalScore = 0;
    skippedQuestions = 0;
    numberOfQuestion = 1;
  }


// Multiple Choice Questions
  public void multipleChoiceQuestion(){
    System.out.println("choose the type of question" 
        + "\n1. Science Quiz"
        + "\n2. Geography Quiz"
        + "\n3. General Knowledge Quiz");
        int userChoice = InputValidator.avoidInputChoiceError(1,3);
    switch(userChoice){
      case 1: 
        System.out.println("Welcome to Science Quiz");
        runQuiz(MCQScience.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 2: 
        System.out.println("Welcome to Geography Quiz");
        runQuiz(MCQGeography.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 3:
      System.out.println("Welcome to General MCQ Quiz");
      runQuiz(GeneralMCQ.class, "^[A-D]$", "Choose the correct option (A, B, C, or D):");
      break;
    }

}
// True or False Questions
  public void trueOrFalseQuestion(){
    runQuiz(TrueOrFalseQuestion.class, "^[TF]$", "Choose the correct option (T or F):");
  }

  public void showMenu(){
    System.out.println("<--------Choose-------->");
    System.out.println("1. Multiple Choice");
    System.out.println("2. True Or False");
    System.out.println("3. Quit");
  }

  public void quitProgram(){
    System.out.println("Quitting the program. See you!");
  }
}