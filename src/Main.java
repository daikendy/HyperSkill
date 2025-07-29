import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        LogicFlow question = new LogicFlow();

        boolean running = true;
        // checks the condition for menu selection
        while (running) {
            question.showMenu();
            System.out.print("Enter your choice: ");
            String choice = scan.nextLine();
        // Handling user input; only accept valid input 
            while (!choice.matches("[1-4]")) {
                System.out.println("Invalid input. Please enter 1, 2, 3, or 4:");
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
                    System.out.println("--------Choose the correct answer--------");
                    System.out.println();
                    question.generalMCQ();
                    break;
                case 3:
                    System.out.println("--------Answer with True or False--------");
                    System.out.println();
                    question.trueOrFalseQuestion();
                    break;
                case 4:
                    question.quitProgram();
                    running = false; // Exit the loop
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
    
            System.out.println(); // Just for cleaner spacing
        }
        scan.close();
        System.out.println("Program ended.");
    }
}