import java.util.Scanner;


public class InputValidationSwitch 
{
	static Scanner keyboard = new Scanner(System.in);
	
	
	
	
	private void inputValidationLoopWithSwitch()
	{
		
		String userinput = "";	
		char choice;
		boolean quit = false;
	
	do
	{ // change your while by this

	    // your own stuff here
	    // then after all your program stuff
	    boolean choiceIsOK = false;
	    do
	    {
	    	userinput = keyboard.next();
		     choice = userinput.toLowerCase().charAt(0);
		    switch(choice)
		    {
		    case 'y':
		        // case y, do nothing, you could even remove that case.
		        choiceIsOK = true;
		        break;
		    case 'n':
		        // case n, do something here
		        choiceIsOK = false;
		        quit = true;
		        break;
		    default:
		        // error or warning
		        System.out.println("Type Y or N to respectively continue or quit");
		        break;
		    }
	    }while(!choiceIsOK);
	}while (!quit);
	}
	
	
	
	
	private void inputValidationWithIf()
	{
		String choice;
		
		choice =keyboard.next().toLowerCase();
		if(choice.equals("y"))
		 {
		  //
		 }
		else
		if(choice.equals("n"))
		 {
		  //
		 }
		else
		{
		 //invalid input
		}
	}
	
	
	
	
	
	// prompts user to enter Y / N to book another ticket
	// will keep looping until Y or N (ignore case) are entered
	// returns true if customer wants another ticket or false if he doesn't
	private static boolean wantsAnotherTicket(){
		
		boolean incorrectInput = false;
		boolean wantsAnotherTicket = false;
		
		do
		{
			System.out.print("Do you want to book another seat? Y / N");
			
			switch (keyboard.next().toLowerCase().charAt(0))
			{
			case 'y':
				incorrectInput = false;
				wantsAnotherTicket = true;
				break;
			case 'n':
				incorrectInput = false;
				wantsAnotherTicket = false;
				break;
			default:
				incorrectInput = true;
				System.out.println("You didn't enter Y or N. Try again!");
			}
			
		} while (incorrectInput);
		
		return wantsAnotherTicket;
	}
}

