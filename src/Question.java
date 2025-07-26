import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Question {
  Scanner scan = new Scanner(System.in);
  private int totalScore;
  final private int limitOfQuestion = 5;
  private int numberOfQuestion = 1;

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
// answer matching by index
    String answer[] = {"A", "C", "C", "C", "B", "C", "B", "C"};

// Shuffle the questions to randomize the order
  List<Integer> order = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            order.add(i); // fill the list with 0 to arr.length - 1
          }
  Collections.shuffle(order); // randomly shuffle the question order 
for (int i = 0; i < limitOfQuestion; i++) {
    int index = order.get(i); // get the next random question index

    System.out.println(numberOfQuestion++ + ". " + arr[index]);
// prints the options for the question
    for (String option : options[index]) {
        System.out.println(option);
    }

    // answer input
    String input = scan.nextLine().trim().toUpperCase();

    while (!input.matches("[A-D]")) {
        System.out.println("Invalid input. Please enter A, B, C, or D:");
        input = scan.nextLine().trim().toUpperCase();
    }

    // check answer
    if (input.equalsIgnoreCase(answer[index])) {
        System.out.println("Correct!");
        totalScore++;
    } else {
        System.out.println("Incorrect. The correct answer is " + answer[index]);
    }
    System.out.println(); // Just for cleaner spacing
  }
    System.out.println("Total Score: " + totalScore + "/" + limitOfQuestion);
    System.out.println("End of the quiz. Thanks for playing!");
    // resets the score
    totalScore = 0;
    numberOfQuestion = 1;
}

// prolly the next one im gon be working
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