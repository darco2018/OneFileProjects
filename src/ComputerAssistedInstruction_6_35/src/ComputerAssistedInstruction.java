import java.security.SecureRandom;
import java.util.Scanner;


public class ComputerAssistedInstruction {
	
	public static final Scanner keyboard = new Scanner(System.in);
	public static final SecureRandom randomNumbers = new SecureRandom();
	public static final int NUMBER_OF_QUESTIONS = 4;
	public static int difficultyLevel = 1;

	public static void main(String[] args) {
				
		int userAnswer;
		int correctAnswersCount = 0;
		int computerAnswer;
		int arithmeticOperation;
				
		difficultyLevel = setDifficultyLevel();
		System.out.println();
		
		arithmeticOperation = setArithmeticOperation();
		System.out.println();		
		
		System.out.printf("Welcome to level %d. Aritmetic operation %d. We have %d questions to go.%n", 
							difficultyLevel, arithmeticOperation, NUMBER_OF_QUESTIONS);
		
		for ( int counter = 1; counter <= NUMBER_OF_QUESTIONS; counter++)
		{					
			computerAnswer = questionFeed(arithmeticOperation);
			System.out.println();
			
			boolean firstTry = true;
			
			do 
			{
				userAnswer = keyboard.nextInt();
						
				if ( userAnswer == computerAnswer)
				{
					if (firstTry == true)
					{
						correctAnswersCount++;
					}
					System.out.printf(chat(userAnswer == computerAnswer));	
				}
				else
				{
					firstTry = false;
					System.out.printf(chat(userAnswer == computerAnswer));
				}
				
				System.out.println();
			
			} while(userAnswer != computerAnswer);
			
			System.out.println();
		} 
		
		System.out.printf("END OF QUIZ");
		System.out.println();
		evaluate(correctAnswersCount);
	}
	
	public static int setDifficultyLevel()
	{
		System.out.printf("Choose your difficulty level (1, 2 or 3) and press Enter.");
		
		return keyboard.nextInt();
	}
	
	public static int setArithmeticOperation()
	{
		System.out.printf("What arithmetic operation do you want to practice?%n" + 
							"Choose from%naddition(1), %nmultiplication(2), %nsubtraction(3), %ndivision(4)" +
							"%nand press Enter.");
		
		return keyboard.nextInt();
	}
	
	public static int getQuizNumber()
	{
		int number;
		
		switch (difficultyLevel)
		{
			case 1:
				number = 1 + randomNumbers.nextInt(9);
				break;
			case 2:
				number = 10 + randomNumbers.nextInt(90);
				break;
			case 3:
				number = 100 + randomNumbers.nextInt(900);
				break;
			default:
				number = 1;
		}
		
		return number;
	}
	
	
	
	public static int questionFeed(int arithmeticOperation)
	{
		int number1 = getQuizNumber();
		int number2 = getQuizNumber();
		
		switch (arithmeticOperation)
		{
			case 1:
				System.out.printf("How much is %d + %d? ", number1, number2);
				return number1 + number2; 
			case 2:
				System.out.printf("How much is %d * %d? ", number1, number2);
				return number1 * number2; 
			case 3:
				System.out.printf("How much is %d - %d? ", number1, number2);
				return number1 - number2;
			case 4:
				System.out.printf("How much is %d / %d? ", number1, number2);
				return (int)((double) number1 / (double)number2);
			default:
				return number1 + number2; 
		}
	}
	
	public static String chat(boolean correctAnswer)
	{
		String message = "";
		int number = 1 + randomNumbers.nextInt(4);
		
		if (correctAnswer)
		{
			switch(number)
			{
			case 1:
				message = "Very good!";
				break;
			case 2:
				message = "Excellent!";
				break; 
			case 3:	
				message = "Nice work!";
				break;
			case 4:
				message = "Keep up the good work!";
				break;	
			}
		} 
		else
		{
			switch(number)
			{
			case 1:
				message = "No. Please try again.";
				break;
			case 2:
				message = "Wrong. Try once more.";
				break; 
			case 3:	
				message = "Don't give up!";
				break;
			case 4:
				message = "No. Keep trying!";
				break;	
			}
		}
		return message;
	}
	
	public static void evaluate(int correctAnswerCount)
	{
		double correctPercentage = Math.ceil((correctAnswerCount * 100) / NUMBER_OF_QUESTIONS);
		
		if (correctPercentage < 75.0)
			System.out.printf("Your score is %.0f percent. Ask yor teacher for help.", correctPercentage);
		else
			System.out.printf("Your score is %.0f percent. You're ready for the next level!", correctPercentage);
	}
	
	
}
