import java.security.SecureRandom;
import java.util.Scanner;


public class ComputerAssistedInstruction_4 {
	
	
	private static final SecureRandom randomNumbers = new SecureRandom(); 
	// 'Thread safe'
	private static final int NUMBER_OF_QUESTIONS = 4;
	private static enum Level {LEVEL_1, LEVEL_2, LEVEL_3}; 
	private Level currentLevel; // currentLevel nie jest wspolny dla wszystkich uzytkownikow, 
	                            // a jedynie dla tego jednego z ktorym program teraz gra. 
								//Dlatego nie static
	private static enum ArithmeticOperation {ADDITION, MULTIPLICATION, SUBTRACTION, DIVISION, MIXED}; 
	private ArithmeticOperation currentOperation; // podobnie to nie static 
												// bo kazdy user moze miec inny
	private static final double passValue = 75.0; // allows user to get to a higher level

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in); //A Scanner is not safe for multithreaded u
        //use without external synchronization.
				
		int userAnswer;
		int correctAnswersCount = 0;
		int computerAnswer;
						
		setInitialDifficultyLevel();
		System.out.println();
		
		setArithmeticOperation();
		System.out.println();		
		
		System.out.printf("Welcome to %s. You chose %s. We have %d questions to go.%n", 
								currentLevel, currentOperation, NUMBER_OF_QUESTIONS);
		
		int playAgain = 1; // sentinel value entered by user at the end of quiz
		
		while (playAgain == 1) 
		{
			for ( int counter = 1; counter <= NUMBER_OF_QUESTIONS; counter++)
			{					
				computerAnswer = questionFeed();
				System.out.println();
				
				boolean firstTry = true;
				
				do 
				{
					userAnswer = keyboard.nextInt();
							
					if (userAnswer == computerAnswer)
					{
						if (firstTry == true) // increment correctAnswersCount ONLY if the correct guess 
						{                     // is the first try
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
			} // end for
			
			// calculate and display the score for this round
			System.out.printf("END OF %s", currentLevel);
			System.out.println();
			double correctnessPercentage = evaluate(correctAnswersCount);
			System.out.println();
			
			// change the level if necessary and reset correctAnswersCount for another round
			if (currentLevel != Level.LEVEL_3)
			{
				setNewDifficultyLevel(correctnessPercentage);			
				System.out.printf("%nWelcome to %s.%n", currentLevel);
				correctAnswersCount = 0;
				
				// determine whether user wants to play again or quit
				System.out.printf("Press 1 and ENTER to play again or 0 and ENTER to quit the quiz.");
				System.out.println();
				playAgain = keyboard.nextInt();
				System.out.println();
			}
			else
				break; // terminate the loop/program if user is at the highest level
			
		} // end while
		
		System.out.printf("Thank you for taking the quiz!");
		
	} // end main
	
	private static void setInitialDifficultyLevel()
	{
		Scanner keyboard = new Scanner(System.in);
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
	
	private static void setArithmeticOperation()
	{
		Scanner keyboard = new Scanner(System.in);
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
			currentOperation = ArithmeticOperation.MIXED;
			break;
		}
	}
	
	
	// displays a quiz question and returns the value of the arithmetic operation
	private static int questionFeed()
	{
		int number1 = getRandomNumber();
		int number2 = getRandomNumber();
		ArithmeticOperation temporaryHolder = currentOperation; // Holds the current arithmetic operation  
																// to restore it at the end of the method.
		                                             // In fact, it will be changed only if currentOperation == MIXED
		
		if (currentOperation == ArithmeticOperation.MIXED) 
		{
			switch (1 + randomNumbers.nextInt(4)) // temporarily change the current arithmetic operation 
			{                                     // to make use of the switch below
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
			}
		}
		
		int value;
		
		switch (currentOperation)
		{
			case ADDITION:
				System.out.printf("How much is %d + %d? ", number1, number2);
				value = number1 + number2; 
				break;
			case MULTIPLICATION:
				System.out.printf("How much is %d * %d? ", number1, number2);
				value = number1 * number2; 
				break;
			case SUBTRACTION:
				System.out.printf("How much is %d - %d? ", number1, number2);
				value = number1 - number2;
				break;
			case DIVISION:
				value = divideTwoNumbers(); // separate method to obtain integer rather than floating-point number
				break;
			default:
				value = 0;
		}
		
		currentOperation = temporaryHolder; // return the original arithmetic operation (MIXED), if the 'MIXED' switch 
		                                // in the if-statement above temporarily changed the value of currentOperation
		
		return value;
	}
	
	private static int getRandomNumber()
	{
		switch (currentLevel)
		{
			case LEVEL_1:
				return 1 + randomNumbers.nextInt(9);				
			case LEVEL_2:
				return 10 + randomNumbers.nextInt(90);				
			case LEVEL_3:
				return 100 + randomNumbers.nextInt(900);				
			default:
				return 1 + randomNumbers.nextInt(9);
		}
	}
	
	private static int divideTwoNumbers()
	{
		int maxNumber1;
		int maxProduct;
				
		switch (currentLevel)
		{
		case LEVEL_1:
			maxNumber1 = 15;	
			maxProduct = 29; //10 - 1 = 5
			break;
		case LEVEL_2:
			maxNumber1 = 50;
			maxProduct = 99;
			break;			
		case LEVEL_3:
			maxNumber1 = 500;	
			maxProduct = 999;
			break;	
		default:
			maxNumber1 = 5;	
			maxProduct = 9;			
		}
		
		int product = 0;
		
			product = 0;
			int number1 = 2 + randomNumbers.nextInt(maxNumber1 - 2);//
			int number2 = 0;
				
		while (product == 0)
		{
						
			number2 = 2 + randomNumbers.nextInt(maxNumber1 - 2);
			if (number1 * number2 <= maxProduct)
				product = number1 * number2;
		}
		
		System.out.printf("How much is %d divided by %d?", product, number1);
		
		
		return number2;
	}
	
	private static String chat(boolean correctAnswer)
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
	
	private static double evaluate(int correctAnswerCount)
	{
		double correctnessPercentage = Math.ceil((correctAnswerCount * 100.0) / NUMBER_OF_QUESTIONS);
		
		if (correctnessPercentage < passValue)
			System.out.printf("Your score is %.0f percent. Ask yor teacher for help.", correctnessPercentage);
		else
		{
			System.out.printf("Your score is %.0f percent. ", correctnessPercentage);
			
			if (currentLevel != Level.LEVEL_3) // makes no sense to say it as Level 3 is the highest level
				System.out.printf("You're ready for the next level!");
		}
		
		return correctnessPercentage;
	}
	
	private static void setNewDifficultyLevel(double correctnessPercentage)
	{
		if (correctnessPercentage >= passValue)
		{
			if (currentLevel == Level.LEVEL_1)
				currentLevel = Level.LEVEL_2;
			else if (currentLevel == Level.LEVEL_2)
				currentLevel = Level.LEVEL_3;
		}
	}
}
	

