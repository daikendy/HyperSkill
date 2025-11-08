import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class MultipleChoiceQuestion{
/* Getters for the arrays and options
   These methods allow access to the private arrays from outside the class */
  public String[] getQuestions() {
    return questions.clone();
  }
public String[][] getOptions() {
    String[][] copy = new String[options.length][];
    for (int i = 0; i < options.length; i++) {
        copy[i] = options[i].clone();
    }
    return copy;
}
  public String[] getAnswer() {
    return answer.clone();
  }

  private String[] questions = {"What is the chemical symbol for gold?\n", 
    "Which organ is responsible for pumping blood throughout the human body?\n", 
    "What gas do plants absorb from the atmosphere for photosynthesis?\n",
    "What is the powerhouse of the cell?",
    "What is H2O commonly known as",
    "Which planet is known as the \"Red Planet\"?",
    "Which part of the atom has a positive charge?",
    "What gas do animals breathe in for survival?",};
  private String[][] options =  {
      {"A) Au", "B) Ag", "C) Gd", "D) Go"},
      {"A) Brain", "B) Kidney", "C) Heart", "D) Lungs"},
      {"A) Oxygen", "B) Nitrogen", "C) Carbon Dioxide", "D) Hydrogen"},
      {"A) Nucleus", "B) Ribosome", "C) Mitochondria", "D) Golgi Apparatus"},
      {"A) Salt", "B) Water", "C) Hydrogen Peroxide", "D) Oxygen"},
      {"A) Earth", "B) Jupiter", "C) Mars", "D) Venus"},
      {"A) Electron", "B) Proton", "C) Neutron", "D) Nucleus"},
      {"A) Carbon Dioxide", "B) Hydrogen", "C) Oxygen", "D) Nitrogen"}
  };
  private String[] answer = {"A", "C", "C", "C", "B", "C", "B", "C"};
}

class TrueOrFalseQuestion{
  /* Getters for the arrays and options
   These methods allow access to the private arrays from outside the class */
  public String[] getQuestions() {
    return questions.clone();
  }
  public String[] getAnswer() {
    return answer.clone();
  }
  private String[] questions = {
    "The Earth revolves around the Sun.",
    "Water boils at 100°C at sea level.",
    "Sound travels faster in air than in water.",
    "Humans share approximately 60% of their DNA with bananas.",
    "The chemical symbol for iron is Fe.",
    "Plants produce oxygen during photosynthesis.",
    "Electric current is measured in volts.",
    "The ozone layer protects Earth from harmful ultraviolet radiation."
  };
  private String[] answer = {"T", "T", "F", "T", "T", "T", "T", "T"};
}

public class Question {
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
  Collections.shuffle(order); // randomly shuffle the question order
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

  public void multipleChoiceQuestion(){
    MultipleChoiceQuestion question = new MultipleChoiceQuestion();
    shuffleQuestions(question.getQuestions().length);
for (int i = 0; i < limitOfQuestion; i++) {
    int index = order.get(i); // get the next random question index

    System.out.println(numberOfQuestion++ + ". " + question.getQuestions()[index]);
// prints the options for the question
    for (String option : question.getOptions()[index]) {
        System.out.println(option);
    }
    // answer input
    String input = getInput("[A-D]", "Enter A, B, C, or D:");
    if (input.equals("BACK")) return;
    // check answer
    checkAnswers(input, question.getAnswer()[index]);
  }
    resetQuestions();
}

// True or False Questions
  public void trueOrFalseQuestion(){
    TrueOrFalseQuestion question = new TrueOrFalseQuestion();
      shuffleQuestions(question.getQuestions().length);
for (int i = 0; i < limitOfQuestion; i++) {
    int index = order.get(i); // get the next random question index

    System.out.println(numberOfQuestion++ + ". " + question.getQuestions()[index]);

    // answer input
    String input = getInput("^[TF]$", "Enter T or F:");
    if (input.equals("BACK")) return;
    // check answer
    checkAnswers(input, question.getAnswer()[index]);
  }
    resetQuestions();
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