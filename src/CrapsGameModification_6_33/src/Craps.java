// Fig. 6.8: Craps.java
// Craps class simulates the dice game craps.
import java.security.SecureRandom;
import java.util.Scanner;

public class Craps 
{
   // create secure random number generator for use in method rollDice
   private static final SecureRandom randomNumbers = new SecureRandom();

   // enum type with constants that represent the game status
   private enum Status {CONTINUE, WON, LOST, BUSTED};

   // constants that represent common rolls of the dice
   private static final int SNAKE_EYES = 2;
   private static final int TREY = 3;
   private static final int SEVEN = 7;
   private static final int YO_LEVEN = 11;
   private static final int BOX_CARS = 12;

   // plays one game of craps
   public static void main(String[] args)
   {
	  int bankBalance = 1000;	  	  
	  // don't try to scan text with nextLine(); AFTER using nextInt() with the same scanner! 
	  
	  Scanner keyboardInt = new Scanner(System.in);
	  Scanner keyboardText = new Scanner(System.in);
	  int wager;
	  Status gameStatus; // can contain CONTINUE, WON, LOST or BUSTED
	  boolean playAgain = true;
	  
	  do 
	  {
		  do 
		  {
			  System.out.printf("Enter a wager: ");	  
			  wager = keyboardInt.nextInt();
			  
			  if (wager > bankBalance)
				  System.out.println("Your wager cannot be greater than your bank balance!");
			  else
			  {
				  if (wager <= 0)
					  System.out.println("Your wager cannot be less or equal to zero!");
			  }
			  
		  } while (wager > bankBalance || wager <= 0);		  

	      int myPoint = 0; // point if no win or loss on first roll
	      

	      int sumOfDice = rollDice(); // first roll of the dice

	      // determine game status and point based on first roll 
	      switch (sumOfDice) 
	      {
	         case SEVEN: // win with 7 on first roll
	         case YO_LEVEN: // win with 11 on first roll           
	            gameStatus = Status.WON;
	            break;
	         case SNAKE_EYES: // lose with 2 on first roll
	         case TREY: // lose with 3 on first roll
	         case BOX_CARS: // lose with 12 on first roll
	            gameStatus = Status.LOST;
	            break;
	         default: // did not win or lose, so remember point         
	            gameStatus = Status.CONTINUE; // game is not over
	            myPoint = sumOfDice; // remember the point
	            System.out.printf("Point is %d%n", myPoint);
	            break;
	      } 

	      // while game is not complete
	      while (gameStatus == Status.CONTINUE) // not WON or LOST
	      { 
	         sumOfDice = rollDice(); // roll dice again

	         // determine game status
	         if (sumOfDice == myPoint) // win by making point
	            gameStatus = Status.WON;
	         else 
	            if (sumOfDice == SEVEN) // lose by rolling 7 before point
	               gameStatus = Status.LOST;
	      } 

	      // display won or lost message
	      if (gameStatus == Status.WON)
	      {
	         System.out.println("Player wins");
	         bankBalance += wager;
	         System.out.println("The new bank balance is " + bankBalance);
	      }
	      else
	      {
	         System.out.println("Player loses");
	         bankBalance -= wager;
	         System.out.println("The new bank balance is " + bankBalance);
	         
	         if (bankBalance <= 0)
	         {
	        	 System.out.println("Sorry. You busted.");
	        	 playAgain = false;
	         }
	      }
	      
	      chatter();
	      
	      if (bankBalance > 0)
	      {
				System.out.print("Do you want to play again? Y/N");	
				System.out.println();
				playAgain = keyboardText.next().equalsIgnoreCase("Y");
	      }
	      
	      
	  
	  } while(playAgain);
		
	  	System.out.print("Thank you for playing the game.");
	  	keyboardText.close();
	  	keyboardInt.close();
      
   }

   // roll dice, calculate sum and display results
   public static int rollDice()
   {
      // pick random die values
      int die1 = 1 + randomNumbers.nextInt(6); // first die roll
      int die2 = 1 + randomNumbers.nextInt(6); // second die roll

      int sum = die1 + die2; // sum of die values

      // display results of this roll
      System.out.printf("Player rolled %d + %d = %d%n", 
         die1, die2, sum);

      return sum; 
   }
   
   public static void chatter()
   {
	   int answerNumber = randomNumbers.nextInt(3);
	   
	   switch (answerNumber)
	   { 
	   case 0:
		   System.out.println("Sorry, you're going for broke, huh?");
		   break;
	   case 1:
		   System.out.println("Aw c'mon, take a chance!");
		   break;
	   case 2:
		   System.out.println("You're up big. Now's the time to cash in your chips!");
		   break;
		   
	   }
   }
} // end class Craps

