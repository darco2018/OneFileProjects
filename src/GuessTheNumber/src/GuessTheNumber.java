import java.security.SecureRandom;
import java.util.Scanner;


public class GuessTheNumber {
	
	private static final SecureRandom randomNumber = new SecureRandom();

	public static void main(String[] args) {
		
		// select a random integer
		int numberToGuess = 1 + randomNumber.nextInt(1000);
		boolean gameOver;
		int counter;
		
		// prompt 
		Scanner keyboard = new Scanner(System.in);
		
		
		do
		{
			System.out.printf("Guess a number between 1 and 1000%n");
			gameOver = false;
			counter = 0;
			
			do
			{
				
				int guess = keyboard.nextInt(); 	//  scan input
				
				counter ++; 	// count guesses
							
				// analyze the situation
				if (guess == numberToGuess)
				{	
					System.out.print("Congratulations! You guessed the number.");
					gameOver = true;
					evaluateScore(counter);
				}
				else
				{
					if (guess > numberToGuess)
						System.out.print("Too high. Try again.");
					else
						System.out.print("Too low. Try again.");
				}
				
				System.out.println();
				
			} while(gameOver != true);
			
			System.out.print("Do you want to play again? Y/N");
			System.out.println();
					
		} while(keyboard.next().equalsIgnoreCase("Y"));
		
		keyboard.close();
		
	}
	
	public static void evaluateScore(int counter)
	{
		System.out.println();
		System.out.println("You tried " + counter + " times to guess the number.");
		
		if (counter == 10)
			System.out.println("Aha, you know the secret!");
		else
		{
			if (counter < 10)
				System.out.println("Either you know the secret or you got lucky!");
			else
				System.out.println("You should be able to do better!");
		}
		
	}

}
