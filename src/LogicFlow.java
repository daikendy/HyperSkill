import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LogicFlow {
  Scanner scan = new Scanner(System.in);
  List<Integer> order = new ArrayList<>();
  private int totalScore;
  final private int limitOfQuestion = 5;
  private int numberOfQuestion = 1;

/*shuffleQuestions method to randomize the order of questions
  It takes the total number of questions as a parameter */
  public void shuffleQuestions(int totalIndex){
    order.clear();
    // Shuffle the questions to randomize the order
        for (int i = 0; i < totalIndex; i++) {
            order.add(i); // fill the list with 0 to arr.length - 1
          }
  Collections.shuffle(order);
  }

// runQuiz method to handle the quiz logic
  // It takes a QuestionType object, input pattern for validation, and input prompt as parameters
  public void runQuiz(QuestionType questionType, String inputPattern, String inputPrompt) {
    shuffleQuestions(questionType.getQuestions().length);
    for (int i = 0; i < limitOfQuestion; i++) {
        int index = order.get(i);
        System.out.println(numberOfQuestion++ + ". " + questionType.getQuestions()[index]);
        if (questionType.hasOptions()) {
            for (String option : questionType.getOptions()[index]) {
                System.out.println(option);
            }
        }
        String input = getInput(inputPattern, inputPrompt);
        if (input.equals("BACK")) return;
        checkAnswers(input, questionType.getAnswer()[index]);
    }
    resetQuestions();
}

/* Method to check the answer and update the score
  It takes the user's input and the correct answer as parameters*/ 
  public void checkAnswers(String input, String correctAnswer){
    if (input.equalsIgnoreCase(correctAnswer)) {
        System.out.println("Correct!");
        totalScore++;
    } else {
        System.out.println("Incorrect. The correct answer is " + correctAnswer);
    }
    System.out.println(); // Just for cleaner spacing
  }

/* Method to reset the question counter and score
    displays the total score and a thank you message */
  public void resetQuestions(){
    System.out.println("Total Score: " + totalScore + "/" + limitOfQuestion);
    System.out.println("End of the quiz. Thanks for playing!");
    // Reset the question counter and score for the next quiz
    totalScore = 0;
    numberOfQuestion = 1;
  }

// Reusable method for getting input with BACK option and validation
  public String getInput(String pattern, String prompt) {
    while (true) {
        System.out.println(prompt);
        System.out.println("Type 'BACK' to return to the main menu.");
        String input = scan.nextLine().trim().toUpperCase();

        if (input.equals("BACK")) {
            totalScore = 0;
            numberOfQuestion = 1;
            return "BACK";
        }
        if (input.matches(pattern)) {
            return input;
        }
        System.out.println("Invalid input. Try again.");
    }
}
// Method to avoid input choice error
// It reads the input and checks if it matches the expected pattern
// Returns the parsed integer value of the input
public int avoidInputChoiceError(int min, int max) {
    String regex = String.format("[%d-%d]", min, max);
    String scanChoice = scan.nextLine().trim();
    while (!scanChoice.matches(regex)) {
        System.out.println("Invalid input. Please enter a number between " + min + " and " + max + ":");
        scanChoice = scan.nextLine().trim();
    }
    return Integer.parseInt(scanChoice);
}


// Multiple Choice Questions
  public void multipleChoiceQuestion(){
    System.out.println("choose the type of question" 
        + "\n1. Science Quiz"
        + "\n2. Geography Quiz"
        + "\n3. General Knowledge Quiz");
        int userChoice = avoidInputChoiceError(1,3);
    switch(userChoice){
      case 1: 
        System.out.println("Welcome to Science Quiz");
        runQuiz(new MCQScience(), "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 2: 
        System.out.println("Welcome to Geography Quiz");
        runQuiz(new MCQGeography(), "^[A-D]$", "Choose the correct option (A, B, C, or D):");
        break;
      case 3:
      System.out.println("Welcome to General MCQ Quiz");
      runQuiz(new GeneralMCQ(), "^[A-D]$", "Choose the correct option (A, B, C, or D):");
      break;
    }

}
// True or False Questions
  public void trueOrFalseQuestion(){
    QuestionType question = new TrueOrFalseQuestion();
    runQuiz(question, "^[TF]$", "Choose the correct option (T or F):");
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