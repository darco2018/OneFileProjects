

import java.security.SecureRandom;
import java.util.Scanner;

public class CoinTossing {
	
	private static final SecureRandom randomNumbers = new SecureRandom();
	private enum Coin {HEADS, TAILS};

	public static void main(String[] args) {
		
		int headsCounter = 0;
		int tailsCounter = 0;
		int flag = 0;
		Coin currentFlip;
		
		Scanner keyboard = new Scanner(System.in);
		
		// toss a coin each time user chooses the "Toss Coin" menu option
		do
		{
			System.out.print("Press 1 to toss a coin or 0 to quit.");
			flag = keyboard.nextInt();
		
			if (flag == 1)
			{
				currentFlip = flip();
				System.out.println(currentFlip);
				
				switch(currentFlip)  //count the number of heads and tails
				{
					case HEADS:
						headsCounter++;
						break; // zapomnialem o break!
					case TAILS:
						tailsCounter++;
						break;
				}
				
				System.out.println();
			}
		} while(flag == 1);
		
		System.out.println("Number of heads is " + headsCounter + " and number of tails is " + tailsCounter);
		
	}
	
	public static Coin flip()
	{
		Coin coinStatus;
		
		if (randomNumbers.nextInt(2) == 0)
			coinStatus = Coin.HEADS; // zapominam dodac Coin przed HEADS I TAILS
		else
			coinStatus = Coin.TAILS;
				
		return coinStatus;
	}

}
