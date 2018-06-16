import java.security.SecureRandom;
import java.util.Scanner;


public class ComputerAssistedInstruction_3 {
	
	private static final Scanner keyboard = new Scanner(System.in);
	private static final SecureRandom randomNumbers = new SecureRandom();
	private static final int NUMBER_OF_QUESTIONS = 4;
	private static enum Level {LEVEL_1, LEVEL_2, LEVEL_3}; 
	private static Level currentLevel;
	private static enum ArithmeticOperation {ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION}; 
	private static ArithmeticOperation currentOperation;

	public static void main(String[] args) {
				
		int userAnswer;
		int correctAnswersCount = 0;
		int computerAnswer;
						
		setDifficultyLevel();
		System.out.println();
		
		setArithmeticOperation();
		System.out.println();		
		
		System.out.printf("Welcome to %s. You chose %s. We have %d questions to go.%n", 
				currentLevel, currentOperation, NUMBER_OF_QUESTIONS);
		
		for ( int counter = 1; counter <= NUMBER_OF_QUESTIONS; counter++)
		{					
			computerAnswer = questionFeed(currentOperation);
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
	
	public static void setDifficultyLevel()
	{
		System.out.printf("Choose your difficulty level (1, 2 or 3) and press Enter.");
		int number = keyboard.nextInt();
		
		switch (number) 
		{
		case 1: 		
			currentLevel = Level.LEVEL_1; // 1-digit numbers in the quiz
			break;
		case 2: 		
			currentLevel = Level.LEVEL_2; // 2-digit numbers in the quiz
			break;
		case 3: 		
			currentLevel = Level.LEVEL_3; // 3-digit numbers in the quiz
			break;
		default:
			currentLevel = Level.LEVEL_1;
			break;
		}
	}
	
	public static void setArithmeticOperation()
	{
		System.out.printf("What arithmetic operation do you want to practice?%n" + 
							"Choose from%naddition(1), %nmultiplication(2), %nsubtraction(3),"
							+ "%ndivision(4), %nmixture(5)" + "%nand press Enter.");
		int number = keyboard.nextInt();
		
		switch (number) 
		{
		case 1: 		
			currentOperation = ArithmeticOperation.ADDITION;
			break;
		case 2: 		
			currentOperation = ArithmeticOperation.MULTIPLICATION;
			break;
		case 3: 		
			currentOperation = ArithmeticOperation.SUBTRACTION;
			break;
		case 4: 
			currentOperation = ArithmeticOperation.DIVISION;
			break;
		default:
			currentOperation = ArithmeticOperation.ADDITION; // should be a mixed type - not implemented yet
			break;
		}
	}
	
	public static int getQuizNumber()
	{
		int number;
		
		switch (currentLevel)
		{
			case LEVEL_1:
				number = 1 + randomNumbers.nextInt(9);
				break;
			case LEVEL_2:
				number = 10 + randomNumbers.nextInt(90);
				break;
			case LEVEL_3:
				number = 100 + randomNumbers.nextInt(900);
				break;
			default:
				number = 1 + randomNumbers.nextInt(9);
		}
		
		return number;
	}
	
	
	
	public static int questionFeed(ArithmeticOperation currentOperation)
	{
		int number1 = getQuizNumber();
		int number2 = getQuizNumber();
		
		switch (currentOperation)
		{
			case ADDITION:
				System.out.printf("How much is %d + %d? ", number1, number2);
				return number1 + number2; 
			case MULTIPLICATION:
				System.out.printf("How much is %d * %d? ", number1, number2);
				return number1 * number2; 
			case SUBTRACTION:
				System.out.printf("How much is %d - %d? ", number1, number2);
				return number1 - number2;
			case DIVISION:
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
