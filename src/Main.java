import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Question question = new Question();
    
        boolean running = true;
        // checks the condition for menu selection
        while (running) {
            question.showMenu();
            System.out.print("Enter your choice: ");
            String choice = scan.nextLine();
        // Handling user input; only accept valid input 
            while (!choice.matches("[1-3]")) {
                System.out.println("Invalid input. Please enter 1, 2, or 3:");
                choice = scan.nextLine();
                }
                int input = Integer.parseInt(choice);

            switch (input) {
                case 1:
                    System.out.println("--------Choose the correct answer--------");
                    System.out.println();
                    question.multipleChoiceQuestion();
                    break;
                case 2:
                    System.out.println("--------Answer with True or False--------");
                    System.out.println();
                    question.trueOrFalseQuestion();
                    break;
                case 3:
                    question.quitProgram();
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
    
            System.out.println(); // Just for cleaner spacing
        }
    
        System.out.println("Program ended.");
    }
}