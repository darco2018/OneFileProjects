import java.util.ArrayList;
import java.util.Scanner;


public class VarLenArgumentList 
{
	private enum Input {CONTINUE, DISCONTINUE};

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Input userInput = Input.CONTINUE;
		ArrayList<Integer> intArray = new ArrayList<>();
		Integer[] copy = new Integer[1];
		
		do
		{
			System.out.print("Enter an integer or 'q' to quit: " );
			String input;
			
			if (keyboard.hasNextInt())
			{
				int number = Integer.parseInt(keyboard.next());
				intArray.add(number);
			}
			else
			{
				try
				{					
					input = keyboard.next();					
					
					if (input.equalsIgnoreCase("q"))
						userInput = Input.DISCONTINUE;
					else
						throw new IllegalArgumentException("You didn't enter 'q' or an integer. Try again!");
				}
				catch (IllegalArgumentException e)
				{
					System.out.println(e.getMessage());
				}
			}
		} while (userInput == Input.CONTINUE);		
		
		if (!(intArray.isEmpty()))
		{
			int product = calculateProduct(intArray.toArray(copy));
			System.out.println("The product of these numbers is " + product );
		}	
		else
		{
			System.out.println("No numbers have been entered. Restart the program." );
		}
	}
	
	public static int calculateProduct (Integer... numbers) 
	{
		int total = 1;
		
		for (Integer element : numbers) // numbers is treated like an array
			total *= element;
		
		return total;
	}
	
	/*private int checkInputForIntegerAndQ() // returns -1 if input is Q/q, 1 if input is an integer, 
	{                                           //0 if its something else
	}
	*/
}
