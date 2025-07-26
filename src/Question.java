import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Question {
  Scanner scan = new Scanner(System.in);
  private int totalScore;
  private int questionCounter;
  final private int limitOfQuestion = 5;
  
  public void multipleChoiceQuestion(){
// Array of questions
    String arr[] = {"What is the chemical symbol for gold?\n", 
    "Which organ is responsible for pumping blood throughout the human body?\n", 
    "What gas do plants absorb from the atmosphere for photosynthesis?\n",
    "What is the powerhouse of the cell?",
    "What is H2O commonly known as",
    "Which planet is known as the \"Red Planet\"?",
    "Which part of the atom has a positive charge?",
    "What gas do animals breathe in for survival?",};
// Options of Answers
    String[][] options = {
      {"A) Au", "B) Ag", "C) Gd", "D) Go"},
      {"A) Brain", "B) Kidney", "C) Heart", "D) Lungs"},
      {"A) Oxygen", "B) Nitrogen", "C) Carbon Dioxide", "D) Hydrogen"},
      {"A) Nucleus", "B) Ribosome", "C) Mitochondria", "D) Golgi Apparatus"},
      {"A) Salt", "B) Water", "C) Hydrogen Peroxide", "D) Oxygen"},
      {"A) Earth", "B) Jupiter", "C) Mars", "D) Venus"},
      {"A) Electron", "B) Proton", "C) Neutron", "D) Nucleus"},
      {"A) Carbon Dioxide", "B) Hydrogen", "C) Oxygen", "D) Nitrogen"}
  };
// Randomly selecting a questions
    boolean running = true;
    Random random = new Random();
    while (running){
      int index = random.nextInt(arr.length);
      System.out.println(arr[index]);
// Printing the options
      //System.out.println(Arrays.deepToString(new String[][] {options[index]}));
      for (String option : options[index]) {
        System.out.println(option);
    }    
// answer matching by index
    String answer[] = {"A", "C", "C", "C", "B", "C", "B", "C"};

// checking the answer if correct or incorrect
        String input;
        input = scan.nextLine().trim().toUpperCase();
        // Handling user input; only accept valid input 
            while (!input.matches("[A-D]")) {
                System.out.println("Invalid input. Please enter A, B, C, or D:");
                input = scan.nextLine().trim().toUpperCase();
                }
            if (input.equalsIgnoreCase(answer[index])){
              System.out.println("Correct");
              totalScore++;
              // tracks the number of question and stop at specific condition
              questionCounter++;
              // Limit the question to certain number
                  if(questionCounter == limitOfQuestion){
                    System.out.println("Your Score: " + totalScore + "/" + questionCounter);
                    running = false;
                  }
              }
            else{
              questionCounter++;
              if(questionCounter == limitOfQuestion){  
                System.out.println("Total Score: " +  totalScore + "/" + questionCounter);
                running = false;
              }
            }
    } 
    // resets the score
    totalScore = 0;
    questionCounter = 0;
  }

  public void trueOrFalseQuestion(){

    String questions[] = {"The Earth revolves around the Sun.",
    "Water boils at 100°C at sea level.",
    "Sound travels faster in air than in water."};

    Random random = new Random();
    int index = random.nextInt(questions.length);
    System.out.println(questions[index]);
  }

  public void showMenu(){
    System.out.println("<--------Choose-------->");
    System.out.println("1. Multiple Choice");
    System.out.println("2. True Or False");
    System.out.println("3. Quit");
  }

  public void quitProgram(){
    System.out.println("Quiting the program. See you!");
  }
}
