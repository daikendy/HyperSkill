package com.quizzes;

import com.quizzes.model.LogicFlow;
import com.quizzes.model.Questions;
import com.quizzes.util.InputValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {

	static Questions question;
	public Main(Questions questions) {
		question = questions;
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Main.class, args);

		boolean running = true;
		// checks the condition for menu selection
		while (running) {
			LogicFlow.showMenu();
			System.out.print("Enter your choice: ");
			// Handling user input; only accept valid input
			int input = InputValidator.avoidInputChoiceError(1, 3);
			switch (input) {
				case 1:
					question.multipleChoiceQuestion();
					break;
				case 2:
					question.trueOrFalseQuestion();
					break;
				case 3:
					LogicFlow.quitProgram();
					running = false; // Exit the loop1
					break;
			}

			System.out.println(); // Just for cleaner spacing
		}
		System.out.println("Program ended.");
	}
}
