public class Main{
    public static void main(String[] args) {
        LogicFlow question = new LogicFlow();
        boolean running = true;
        // checks the condition for menu selection
        while (running) {
            question.showMenu();
            System.out.print("Enter your choice: ");
        // Handling user input; only accept valid input
        int input = question.avoidInputChoiceError(1,3);
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
            }
    
            System.out.println(); // Just for cleaner spacing
        }
        System.out.println("Program ended.");
    }
}